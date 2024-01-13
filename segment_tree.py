class Node:
    def __init__(self, query, start, end):
        self.start = start
        self.end = end
        self.query = query
        self.left = None
        self.right = None

class Segment:
    def __init__(self, arr):
        self.arr = arr
        self.root = None

    def build_tree(self, arr, start, end):
        if start == end:
            new_node = Node(arr[start], start, end)
            return new_node
        else:
            mid = (start+end)//2
            new_node_ = Node(None, start, end)
            new_node_.left = self.build_tree(arr, start, mid)
            new_node_.right = self.build_tree(arr, mid+1, end)
            return new_node_    

    def build_min_query(self, root, start, end):
        if start == end:
            return root.query
        else:
            mid = (start + end) // 2
            root.query = min(self.build_min_query(root.left,start, mid), self.build_min_query(root.right, mid+1, end))
            return root.query

    def build_max_query(self, root, start, end):
        if start == end:
            return root.query
        else:
            mid = (start + end) // 2
            root.query = max(self.build_max_query(root.left, start, mid), self.build_max_query(root.right, mid+1, end))

    def build_sum_query(self, root, start, end):
        if start == end:
            return root.query
        else:
            mid = (start + end) // 2
            root.query = self.build_sum_query(root.left, start, mid) + self.build_sum_query(root.right, mid+1, end)
            return root.query

    def print_tree(self, root):
        if root:
            print(root.query, root.start, root.end)
            self.print_tree(root.left)
            self.print_tree(root.right)

if __name__ == '__main__':
    n = int(input('Enter the number of elements: '))
    arr = []
    for i in range(n):
        arr.append(int(input('Enter the element: ')))
    print('The array is: ', arr)
    st_tree = Segment(arr)
    st_tree.root = st_tree.build_tree(arr, 0, n-1)
    st_tree.print_tree(st_tree.root)
    print('Enter the operation to build query : ')
    print('1. Minimum')
    print('2. Maximum')
    print('3. Sum')
    n = int(input('Enter operation : '))
    if n == 1:
        st_tree.build_min_query(st_tree.root, 0, len(arr)-1)
    elif n == 2:
        st_tree.build_max_query(st_tree.root, 0, len(arr)-1)
    elif n == 3:
        st_tree.build_sum_query(st_tree.root, 0, len(arr)-1)
    st_tree.print_tree(st_tree.root)


