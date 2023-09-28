class Node:
    def __init__(self, data):
        self.data = data
        self.parent = None
        self.left = None
        self.right = None


class AVLTree:
    def __init__(self, data):
        self.root = Node(data)
