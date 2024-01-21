import sys

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.parent = None

class Splay_Tree:
    def __init__(self, root):
        self.root = root

    def insert(self, data, node):
        if data < node.data:
            if not node.left:
                child = Node(data)
                child.parent = node
                node.left = child
                self.splaying(child)
            else:
                self.insert(data, node.left)
        elif data > node.data:
            if not node.right:
                child = Node(data)
                child.parent = node
                node.right = child
                self.splaying(child)
            else:
                self.insert(data, node.right)

    def delete(self, data, node, parent):
        if data < node.data:
            if node.left:
                self.delete(data, node.left, node)
            else:
                self.splaying(node)
        elif data > node.data:
            if node.right:
                self.delete(data, node.right, node)
            else:
                self.splaying(node)
        elif data == node.data:
            self._delete_cases(node, parent)
            self.splaying(parent)

    def _delete_cases(self, node, parent):
        if node.left is None and node.right is None:
            if parent.left == node:
                parent.left = None
            else:
                parent.right = None
        elif node.right is not None:
            inorder_successor = self.minimum(node.right)
            node.data = inorder_successor.data
            self._delete_cases(inorder_successor, inorder_successor.parent)
        elif node.right is None and node.left is not None:
            inorder_predecessor = self.maximum(node.left)
            node.data = inorder_predecessor.data
            self._delete_cases(inorder_predecessor, inorder_predecessor.parent)

    def minimum(self, root):
        if root is None:
            return None
        else:
            while root.left is not None:
                root = root.left
            return root

    def maximum(self, root):
        if root is None:
            return None
        else:
            while root.right is not None:
                root = root.right
            return root

    def search(self, data, node):
        if data < node.data:
            self.search(data, node.left)
        elif data > node.data:
            self.search(data, node.right)
        elif data == node.data:
            print('data found\n')
            self.splaying(node)
            return node
        else:
            print('data not found\n')
            return None

    def splaying(self, node):
        if node is self.root:
            return
        parent = node.parent
        grandparent = None
        if parent:
            grandparent = parent.parent
        if parent.left == node and grandparent is None:
            self.zig(parent)
        elif parent.right == node and grandparent is None:
            self.zag(parent)
        elif parent.right == node and grandparent.right == parent:
            self.zag_zag(node, parent, grandparent)
        elif parent.left == node and grandparent.left == parent:
            self.zig_zig(node, parent, grandparent)
        elif parent.right == node and grandparent.left == parent:
            self.zig_zag(node, parent, grandparent)
        elif parent.left == node and grandparent.right == parent:
            self.zag_zig(node, parent, grandparent)
        self.splaying(node)


    def zig_zig(self, node, parent, grandparent):
        self.right_rotate(grandparent)
        self.right_rotate(parent)

    def zag_zag(self, node, parent, grandparent):
        self.left_rotate(grandparent)
        self.left_rotate(parent)


    def zig_zag(self, node, parent, grandparent):
        self.left_rotate(parent)
        self.right_rotate(grandparent)

    def zag_zig(self, node, parent, grandparent):
        self.right_rotate(parent)
        self.left_rotate(grandparent)

    def zig(self,parent):
        self.right_rotate(parent)

    def zag(self, parent):
        self.left_rotate(parent)

    def left_rotate(self, node):
        new_root = node.right
        node.right = new_root.left
        # changing the pointer of the new root to its children
        if new_root.left:
            # if it exists then after rotating it will change its location
            new_root.left.parent = node
        new_root.parent = node.parent
        if not node.parent:
            # if it doesnt exist change root of the tree
            self.root = new_root
        elif node.parent.left == node:
            node.parent.left = new_root
        else:
            node.parent.right = new_root
        new_root.left = node
        node.parent = new_root

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

    def inorder(self, node):
        if node:
            self.inorder(node.left)
            print(node.data, end=' ')
            self.inorder(node.right)
        else:
            return

    def print_helper(self, node, indent, last):
        if node is not None:
            sys.stdout.write(indent)
            if last:
                sys.stdout.write("R----")
                indent += "     "
            else:
                sys.stdout.write("L----")
                indent += "|    "

            print(node.data)
            self.print_helper(node.left, indent, False)
            self.print_helper(node.right, indent, True)


if __name__ == '__main__':
    spt = Splay_Tree(Node(int(input('enter the root : '))))

    switch = True
    while(switch):
        print('\n1. Insert\n2. Inorder\n3. Delete\n4. Search\n5. Print Tree\n6. Minimum\n7. Maximum')
        n = int(input('enter the operation : '))
        if n == 1:
            spt.insert(int(input('enter data to insert : ')), spt.root)
        elif n == 2:
            spt.inorder(spt.root)
        elif n == 3:
            spt.delete(int(input('enter data to delete : ')), spt.root, None)
        elif n == 4:
            spt.search(int(input('enter the data : ')), spt.root)
        elif n == 5:
            spt.print_helper(spt.root, "     ", True)
        elif n == 6:
            minx = spt.minimum(spt.root)
            print(f'the minimum element is {minx.data}')
        elif n == 7:
            maxn = spt.maximum(spt.root)
            print(f'the maximum element is {maxn.data}')
        else:
            switch = False
