class Node:
    def __init__(self, data, parent):
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None
        self.height = None
        self.balance_factor = 0

    # def find_bal_fac(self):
    #     left_height = -1
    #     if self.left:
    #         left_height = self.left.height
    #     right_height = -1
    #     if self.right:
    #         right_height = self.right.height
    #     self.balance_factor = left_height - right_height
    #     return self.balance_factor
    
    @property
    def balance_factor(self):
        return self.balance_factor
    
    @balance_factor.setter 
    def balance_factor(self):
        self.balance_factor = self.left.height - self.right.height
    
    def find_height(self):
        if not self.right and not self.left:
            self.height = 0
        elif not self.right:
            self.height = self.left.height + 1
        elif not self.left:
            self.height = self.right.height + 1
        else:
            self.height = max(self.right.find_height(), self.left.find_height()) + 1  

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

    def insert_bst(self, root, data):
        if not root:
            root = Node(data)
            root.find_height()
        elif root.data < data:
            self.insert_bst(self, root.right, data)
        elif root.data > data:
            self.insert_bst(self, root.left, data)
    
    def delete(self, data):
        pass