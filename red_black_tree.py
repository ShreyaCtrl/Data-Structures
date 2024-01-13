import sys

class Node:
    def __init__(self, data):
        self.data = data
        self.parent = None
        self.left = NullNode()
        self.right = NullNode()
        # Node initially red when inserted in a red-black tree
        self.color = 'red'

class NullNode:
    def __init__(self):
        self.color = 'black'

class RedBlackTree:
    def __init__(self, data):
        self.root = Node(data)
        self.root.color = 'black'

    def inorder(self, root):
        if root is None or isinstance(root, NullNode):
            # print('Tree is empty')
            return
        else:
            self.inorder(root.left)
            print(root.data,f'({root.color})', end=' ')
            self.inorder(root.right)

    def inorder_succesor(self, root, data):
        if root is None:
            return None
        else:
            root = self.search(data)
            if root is None:
                return
            else:
                maximum = self.maximum(root.left)
                if maximum is not None:
                    return maximum
                else:
                    return None

    def maximum(self, root):
        if root is None:
            return None
        else:
            while root.right is not None and not isinstance(root.right, NullNode):
                root = root.right
            return root
        
    def insert(self, data):
        new_node = Node(data)
        if self.root is None:
            self.root = new_node
            self.root.color = 'black'
            return
        else:
            current = self.root
            parent = None
            while isinstance(current, Node):
                parent = current
                if data < current.data:
                    current = current.left
                elif data > current.data:
                    current = current.right
            new_node.parent = parent
            if data < parent.data:
                parent.left = new_node
            else:
                parent.right = new_node
            if parent.color == 'black':
                return
            elif parent.color == 'red':
                grand_parent = parent.parent
                uncle = None
                if grand_parent.left == parent:
                    uncle = grand_parent.right
                else:
                    uncle = grand_parent.left
                self.imbalance(new_node, parent, grand_parent, uncle)

    def delete(self, data):
        node_to_delete = self.search(data)  # Find the node to delete
        if node_to_delete is not None:
            self._delete_node(node_to_delete)

    def _delete_node(self, node):
        if isinstance(node, NullNode):
            return

        parent = node.parent

        # Case 1: Node has two children
        if not isinstance(node.left, NullNode) and not isinstance(node.right, NullNode):
            successor = self.minimum(node.right)
            node.data = successor.data
            self._delete_node(successor)
            return

        # Case 2: Node has one child (or no children)
        if isinstance(node.left, NullNode):
            child = node.right
        else:
            child = node.left

        self._replace_node(node, child)

        if node.color == 'black':
            if child.color == 'red':
                child.color = 'black'
            else:
                self._delete_balance(child, parent)

    def _replace_node(self, old_node, new_node):
        if old_node.parent is None:
            self.root = new_node
        elif old_node == old_node.parent.left:
            old_node.parent.left = new_node
        else:
            old_node.parent.right = new_node

        new_node.parent = old_node.parent

    def _delete_balance(self, node, parent):
        while node != self.root and node.color == 'black':
            if node == parent.left:
                sibling = parent.right
                if sibling.color == 'red':
                    sibling.color = 'black'
                    parent.color = 'red'
                    self.left_rotate(parent)
                    sibling = parent.right
                if sibling.left.color == 'black' and sibling.right.color == 'black':
                    sibling.color = 'red'
                    node = parent
                else:
                    if sibling.right.color == 'black':
                        sibling.left.color = 'black'
                        sibling.color = 'red'
                        self.right_rotate(sibling)
                        sibling = parent.right
                    sibling.color = parent.color
                    parent.color = 'black'
                    sibling.right.color = 'black'
                    self.left_rotate(parent)
                    node = self.root
            else:
                sibling = parent.left
                if sibling.color == 'red':
                    sibling.color = 'black'
                    parent.color = 'red'
                    self.right_rotate(parent)
                    sibling = parent.left
                if sibling.right.color == 'black' and sibling.left.color == 'black':
                    sibling.color = 'red'
                    node = parent
                else:
                    if sibling.left.color == 'black':
                        sibling.right.color = 'black'
                        sibling.color = 'red'
                        self.left_rotate(sibling)
                        sibling = parent.left
                    sibling.color = parent.color
                    parent.color = 'black'
                    sibling.left.color = 'black'
                    self.right_rotate(parent)
                    node = self.root

        node.color = 'black'

    def search(self, data):
        current = self.root
        while current is not None and not isinstance(current, NullNode):
            if data == current.data:
                print('Node found')
                return current
            elif data < current.data:
                current = current.left
            elif data > current.data:
                current = current.right
        print('Node not found')
        return None

    def imbalance(self, new_node, parent, grand_parent, uncle):
        if self.root == new_node:
            print('changing root to black again')
            new_node.color = 'black'

        elif uncle.color == 'red':
            # Recoloring
            parent.color = 'black'
            uncle.color = 'black'
            grand_parent.color = 'red'
            new_node = grand_parent
            parent = grand_parent.parent
            if parent is not None:
                grand_parent = parent.parent
                if grand_parent is not None and grand_parent.left == parent:
                    uncle = grand_parent.right
                elif grand_parent is not None:
                    uncle = grand_parent.left
                self.imbalance(new_node, parent, grand_parent, uncle)
            else:
                self.imbalance(new_node, parent, None, None)

        else:  # Uncle is black
            if parent.left == new_node and grand_parent.left == parent:
                # LLb case: Right rotation and recoloring
                self.right_rotate(grand_parent)
                parent.color = 'black'
                grand_parent.color = 'red'
            elif parent.right == new_node and grand_parent.right == parent:
                # RRb case: Left rotation and recoloring
                self.left_rotate(grand_parent)
                parent.color = 'black'
                grand_parent.color = 'red'
            elif parent.right == new_node and grand_parent.left == parent:
                # LRb case: Left rotation on parent and transform into LLb
                self.left_rotate(parent)
                self.right_rotate(grand_parent)
                new_node.color = 'black'
                grand_parent.color = 'red'
            elif parent.left == new_node and grand_parent.right == parent:
                # RLb case: Right rotation on parent and transform into RRb
                self.right_rotate(parent)
                self.left_rotate(grand_parent)
                new_node.color = 'black'
                grand_parent.color = 'red'
            new_node = grand_parent
            parent = grand_parent.parent
            if parent is not None:
                grand_parent = parent.parent
                if grand_parent is not None:
                    if grand_parent.left == parent:
                        uncle = grand_parent.right
                    elif grand_parent.right == parent:
                        uncle = grand_parent.left
                    else:
                        uncle = None
                self.imbalance(new_node, parent, grand_parent, uncle)
            else:
                self.root = new_node
                self.imbalance(new_node, parent, None, None)

    # Helper function for right rotation
    def right_rotate(self, node):
        new_root = node.left
        node.left = new_root.right
        if new_root.right:
            new_root.right.parent = node
        new_root.parent = node.parent
        if not node.parent:
            self.root = new_root
        elif node == node.parent.left:
            node.parent.left = new_root
        else:
            node.parent.right = new_root
        new_root.right = node
        node.parent = new_root

    # Helper function for left rotation
    def left_rotate(self, node):
        new_root = node.right
        node.right = new_root.left
        if new_root.left:
            new_root.left.parent = node
        new_root.parent = node.parent
        if not node.parent:
            self.root = new_root
        elif node == node.parent.left:
            node.parent.left = new_root
        else:
            node.parent.right = new_root
        new_root.left = node
        node.parent = new_root

    def print_tree(self, root):
        if root is None or isinstance(root, NullNode):
            return
        else:
            print('      ')
            print(root.data, root.color)
            self.print_tree(root.left)
            self.print_tree(root.right)

    def print_helper(self, node, indent, last):
        if node is not None and not isinstance(node, NullNode):
            sys.stdout.write(indent)
            if last:
                sys.stdout.write("R----")
                indent += "     "
            else:
                sys.stdout.write("L----")
                indent += "|    "

            print(str(node.data) + "(" + node.color + ")")
            self.print_helper(node.left, indent, False)
            self.print_helper(node.right, indent, True)

if __name__ == '__main__':
    n = int(input('Enter the number of nodes: '))
    rbt = RedBlackTree(int(input('Enter the root node: ')))
    for _ in range(n-1):
        rbt.insert(int(input('Enter the node: ')))
    # rbt.print_tree(rbt.root)
    rbt.print_helper(rbt.root, "     ", True)

    print("\nRed-Black Tree Structure:")
    rbt.print_helper(rbt.root, "     ", True)

    switch = True
    while(switch):
        print('1. Insert')
        print('2. Delete')
        print('3. Inorder Transversal')
        print('4. Print Tree')
        print('5. Search')
        print('6. Inorder Successor')
        print('7. Exit')
        n = int(input('enter the operation : '))
        if n == 1:
            rbt.insert(int(input('Enter the node: ')))
        elif n == 2:
            rbt.delete(int(input('enter the node : ')))
        elif n == 3:
            rbt.inorder(rbt.root)
            print()
        elif n == 4:
            rbt.print_helper(rbt.root, "     ", True)
        elif n == 5:
            rbt.search(int(input('enter the node : ')))
        elif n == 6:
            rbt.inorder_succesor(rbt.root, int(input('enter the node : ')))
        elif n == 7:
            switch = False
        else:
            print('Invalid input')
