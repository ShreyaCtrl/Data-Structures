class Node:
    def __init__(self, data):
        self.data = data
        self.parent = None
        self.left = None
        self.right = None
        self.height = 
        self.balance_factor = 0

    def find_bal_fac(self):
        left_height = -1
        if self.left:
            left_height = self.left.height
        right_height = -1
        if self.right:
            right_height = self.right.height
        self.balance_factor = left_height - right_height
        return self.balance_factor

class AVLTree:
    def __init__(self, data):
        self.root = Node(data)
        
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

    def insert(self, data):
        pass
    
    def delete(self, data):
        pass