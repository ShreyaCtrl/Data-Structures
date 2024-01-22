class Node:
    def __init__(self, data):
        self.data = data
        self.npl = 0
        self.left = None
        self.right = None
        
    def null_path_length(self):
        if  self.left.npl >= self.right.npl:
            self.npl = self.left.npl
        elif self.left.npl < self.right.npl:
            self.left, self.right = self.right, self.left
            self.npl = self.left.npl
        
class LefistHeap:
    def __init__(self, data):
        self.root = Node(data)
        
    def insert(self, data, ):
        pass