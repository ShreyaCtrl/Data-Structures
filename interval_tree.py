import sys
class Node:
    def __init__(self, interval, parent):
        self.interval = interval
        self.parent = parent
        self.max = None
        self.color = 'R'
        self.left = Null()
        self.right = Null()
        
class Null:
    def __init__(self):
        self.color = 'B'

class Interval_tree:
    def __init__(self, root):
        self.tree_root = root
        self.imbalance(root)
    
    def insert(self, root, interval):
        # if root is None:
        #     new_node = Node(interval)
        #     return new_node
        if root.interval[0] > interval[0]:
            if isinstance(root.left, Null):
                root.left = Node(interval, root)
                if root.color == 'R' and root.left.color == 'R':
                    self.imbalance(root.left)
                return
            else:
                self.insert(root.left, interval)
        elif root.interval[0] < interval[0]:
            if isinstance(root.right, Null):
                root.right = Node(interval, root)
                if root.color == 'R' and root.left.color == 'R':
                    self.imbalance(root.right)
                return
            else:
                self.insert(root.right, interval)
        
    def imbalance(self, child):
        if self.tree_root == child:
            child.color = 'B'
            return
        parent = child.parent
        grandparent = parent.parent
        if not isinstance(grandparent, Null):
            if grandparent.left == parent:
                uncle = grandparent.right
            else:
                # Also handles the case where grandparent is there but there is no uncle
                # grandparent.left can be Null 
                uncle = grandparent.left
        else:
            grandparent = Null()
            uncle = Null()
        if uncle.color == 'R':
            parent.color = 'B'
            uncle.color = 'B'
            grandparent.color = 'R'
            self.imbalance(grandparent)
        elif uncle.color == 'B':
            if grandparent.left == parent and parent.left == child: 
                # LLb
                self.right_rotate(grandparent)
                parent.color = 'B'
                grandparent.color = 'R'
            elif grandparent.right == parent and parent.left == child:
                # RLb
                self.right_rotate(parent)
                self.left_rotate(grandparent)
                child.color = 'B'
                grandparent.color = 'R'
            elif grandparent.left == parent and parent.right == child:
                self.left_rotate(parent)
                self.right_rotate(grandparent)
                child.color = 'B'
                grandparent.color = 'R'
            elif grandparent.right == parent and parent.right == child:
                self.left_rotate(grandparent)
                grandparent.color = 'R'
                parent.color = 'B'
            self.imbalance(grandparent)

    def left_rotate(self, node):
        new_root = node.right
        node.right = new_root.left
        if new_root.left:
            new_root.left.parent = node
        new_root.parent = node.parent
        if not node.parent:
            self.tree_root = new_root
        elif node == node.parent.left:
            node.parent.left = new_root
        else:
            node.parent.right = new_root
        new_root.left = node
        node.parent = new_root

    def right_rotate(self, rotate_node):
        new_root = node.left
        rotate_node.left = new_root.right
        if new_root.right:
            new_root.right.parent = rotate_node
        new_root.parent = rotate_node.parent
        if not rotate_node.parent:
            self.tree_root = new_root
        elif rotate_node == rotate_node.parent.left:
            rotate_node.parent.left = new_root
        else:
            rotate_node.parent.right = new_root
        new_root.right = rotate_node
        rotate_node.parent = new_root
    
    def build_max_value(self, root):
        if isinstance(root.left, Null) and isinstance(root.right, Null):
            root.max = root.interval[1]
            return root.max
        elif isinstance(root.left, Null):
            root.max = self.build_max_value(root.right)
            return root.max
        elif isinstance(root.right, Null):
            root.max = self.build_max_value(root.left)
            return root.max
        else:
            root.max = max(self.build_max_value(root.right), self.build_max_value(root.left))
            return root.max
    
    def overlap_interval(self, root, check_interval):
        if not isinstance(root.left, Null):
            if check_interval[0] < root.interval[1] and check_interval[1] > root.interval[0]:
                print('Overlapping interval found')
                print(root.interval)
            elif check_interval[0] < root.left.max:
                self.overlap_interval(root.left, check_interval)
            else:
                self.overlap_interval(root.right, check_interval)
        else:
            print('No overlapping interval found')
        
    def print_tree(self, root):
        if root is None or isinstance(root, Null):
            return
        else:
            print('      ')
            print(root.interval, '(', root.color, ')', ':', root.max)
            self.print_tree(root.left)
            self.print_tree(root.right)


    def print_helper(self, node, indent, last):
        if node is not None and not isinstance(node, Null):
            sys.stdout.write(indent)
            if last:
                sys.stdout.write("R----")
                indent += "     "
            else:
                sys.stdout.write("L----")
                indent += "|    "

            print(str(node.interval) + "(" + node.color + ")", ':', node.max)
            self.print_helper(node.left, indent, False)
            self.print_helper(node.right, indent, True)
        
if __name__ == '__main__':
    # n = int(input('Number of nodes : '))
    node = [(20,25),(15,40),(30,65),(5,80),(18,70),(25,70),(40,50)]
    rt = Node(node[0], Null())
    it = Interval_tree(rt)
    it.build_max_value(it.tree_root)
    it.print_helper(it.tree_root, '    ', True)
    print('____________________________________________________')
    for i in range(1,7):
        # intv = (int(input('Enter lower : ')), int(input('Enter upper')))
        # print(type(intv))
        # print(it.tree_root.interval, it.tree_root.color)
        print(i)
        it.insert(it.tree_root, node[i])
        it.build_max_value(it.tree_root)
        it.print_helper(it.tree_root, '    ', True)
        print('____________________________________________________')
        
    it.overlap_interval(it.tree_root, (15,23))
    it.overlap_interval(it.tree_root, (10,20))