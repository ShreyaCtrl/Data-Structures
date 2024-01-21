import sys

class Node:
    def __init__(self, data, parent):
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None
        self.height = self.find_height()

    @property
    def balance_factor(self):
        left_height = -1 if not self.left else self.left.height
        right_height = -1 if not self.right else self.right.height
        return left_height - right_height

    def find_height(self):
        if not self.right and not self.left:
            return 0
        elif not self.right:
            self.height = self.left.find_height() + 1
            # print(self.data, self.height)
            return self.height
        elif not self.left:
            self.height = self.right.find_height() + 1
            # print(self.data, self.height)
            return self.height
        else:
            return max(self.right.find_height(), self.left.find_height()) + 1          

class AVLTree:
    def __init__(self, data):
        self.root = Node(data, None)
        
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
        node.height = node.find_height()
        new_root.height = new_root.find_height()
          
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
        node.height = node.find_height()
        new_root.height = new_root.find_height()

    def insert_bst(self, root, data):
        # print(data)
        self.root = self._insert_bst(self.root, data)
        # print('slkfj')
        root = self.search(self.root, data)
        # print('passing', root.data)
        self.balance(root)
        # self.print_helper(avl.root, '    ', True)
        root.height = root.find_height()
        # print(self.root.data)
        return root
    
    def _insert_bst(self, root, data):
        if not root:
            return Node(data, None)
        elif root.data < data:
            # print(root.data, '->')
            root.right = self._insert_bst(root.right, data)
            if root.right:
                # self.print_helper(avl.root, '    ', True)
                root.right.parent = root
                # print('returning ', root.data)
                return root
        elif root.data > data:
            # print(root.data, '->')
            root.left = self._insert_bst(root.left, data)
            if root.left:
                root.left.parent = root
                return root
        else:
            return root

    def search(self, root, data):
        if data == root.data:
            return root
        elif data < root.data:
            return self.search(root.left, data)
        elif data > root.data:
            return self.search(root.right, data)

    def balance(self, root):
        root.height = root.find_height()
        balance_factor = root.balance_factor
        # print(root.data, balance_factor)
        if balance_factor > 1:
            if root.left.balance_factor >= 0:
                # print('Right rotate : ', root.data)
                self.right_rotate(root)
            else:
                # print('RL rotate : ', root.data)
                self.left_rotate(root.left)
                self.right_rotate(root)
        elif balance_factor < -1:
            if root.right.balance_factor <= 0:
                # print('Left rotate : ', root.data)
                self.left_rotate(root)
                # print(self.root.data)
            else:
                # print('LR rotate : ', root.data)
                self.right_rotate(root.right)
                self.left_rotate(root)
        if root.parent is not None:
            self.balance(root.parent)
        else:
            self.root = root
            return

    def delete(self, root, data):
        # Find the node to be deleted and remove it
        if not root:
            return root
        elif data < root.data:
            root.left = self.delete(root.left, data)
        elif data > root.data:
            root.right = self.delete(root.right, data)
        else:
            if root.left is None:
                temp = root.right
                root = None
                return temp
            elif root.right is None:
                temp = root.left
                root = None
                return temp
            temp = self.find_min(root.right)
            root.data = temp.data
            root.right = self.delete(root.right, temp.data)

        # Balance the tree after deletion
        self.balance(root)
        # print('Returning ', root.data)
        return root

    def find_min(self, root):
        if root is None or root.left is None:
            return root
        return self.find_min(root.left)

    def find_max(self, root):
        if root is None or root.right is None:
            print('max is ', root.data)
            return root
        return self.find_max(root.right)

    def print_helper(self, node, indent, last):
        if node is not None:
            sys.stdout.write(indent)
            if last:
                sys.stdout.write("R----")
                indent += "     "
            else:
                sys.stdout.write("L----")
                indent += "|    "

            print(node.data,"(" , node.balance_factor, ")", node.height)
            self.print_helper(node.left, indent, False)
            self.print_helper(node.right, indent, True)
    
print('Insertion')
print(2)
avl = AVLTree(2)
avl.print_helper(avl.root, '    ', True)
print('_______________________________________________________________')
print(12)
avl.root = avl.insert_bst(avl.root, 12)
avl.print_helper(avl.root, '    ', True)
print('_______________________________________________________________')
# avl.root =
print(22)
avl.insert_bst(avl.root, 22)
# print(' dkjfsld', avl.root.data)
avl.print_helper(avl.root, '    ', True)
print('_______________________________________________________________')
# avl.root =
print(26)
avl.insert_bst(avl.root, 26)
avl.print_helper(avl.root, '    ', True)
print('_______________________________________________________________')
# avl.root =
print(32)
avl.insert_bst(avl.root, 32)
avl.print_helper(avl.root, '    ', True)
print('_______________________________________________________________')
# avl.root =
print(37)
avl.insert_bst(avl.root, 37)
avl.print_helper(avl.root, '    ', True)
print('_______________________________________________________________')
# avl.root =
print(42)
avl.insert_bst(avl.root, 42)
avl.print_helper(avl.root, '    ', True)
print('_______________________________________________________________')
print('Deletion')
print('_______________________________________________________________')
print(26)
avl.delete(avl.root, 26)
avl.print_helper(avl.root, '    ', True)
print('_______________________________________________________________')