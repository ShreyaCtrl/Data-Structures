import java.util.*;
//import java.lang.*;
import java.io.*;

class IntervalTree {
    Node root;
    IntervalTree(int low, int high) {
        this.root = new Node(low, high, new Null(), new Null(), new Null());
        this.balanceInsert(this.root);
    }

    void insertNode(Node root, int low, int high) {
        if (root.low > low) {
            if (root.left.isNullNode()) {
                root.left = new Node(low, high, root,  new Null(), new Null());
                if (root.isRed() && root.left.isRed()) {
                    this.balanceInsert(root.left);
                }
                this.root.max = this.root.findMax();
            } else {
                this.insertNode(root.left, low, high);
            }
        } else if (root.low < low) {
            if (root.right.isNullNode()) {
                root.right = new Node(low, high, root, new Null(), new Null());
                if (root.isRed() && root.right.isRed()) {
                    this.balanceInsert(root.right);
                }
                this.root.max = this.root.findMax();
            } else {
                this.insertNode(root.right, low, high);
            }
        }
    }

    void leftRotate(Node node) {
        Node new_root = node.right;
        node.right = new_root.left;
//        changing the pointer of the new root to its children
        if (new_root.left != null) {
//            if it exists then after rotating it will change its location
            new_root.left.parent = node;
        }
        new_root.parent = node.parent;
        if (node.parent == null) {
//            if it doesnt exist change root of the tree
            this.root = new_root;
        } else if (node.parent.left == node) {
            node.parent.left = new_root;
        } else
            node.parent.right = new_root;
        new_root.left = node;
        node.parent = new_root;
    }

    void rightRotate(Node node) {
        Node new_root = node.left;
        node.left = new_root.right;
        if (new_root.right != null) {
            new_root.right.parent = node;
        }
        new_root.parent = node.parent;
        if (node.parent == null) {
            this.root = new_root;
        } else if (node == node.parent.left) {
            node.parent.left = new_root;
        } else{
            node.parent.right = new_root;
        }
        new_root.right = node;
        node.parent = new_root;
    }

    void balanceInsert(Node node) {
        if (this.root == node) {
            node.colour = 'B';
            return;
        }
        Node parent = node.parent;
        Node grandparent = parent.parent;
        Node uncle;
        if (!grandparent.isNullNode()) {
            uncle = grandparent.left == node.parent ? grandparent.right : grandparent.left;
        } else {
            uncle = new Null();
        }
        if (uncle.isRed()) {
            parent.colour = 'B';
            uncle.colour = 'B';
            grandparent.colour = 'R';
            this.balanceInsert(grandparent);
        } else {
            if ((parent == grandparent.left) && (node == parent.left)) {
                this.rightRotate(grandparent);
                parent.colour = 'B';
                grandparent.colour = 'R';
            } else if ((parent == grandparent.left) && (node == parent.right)) {
                this.leftRotate(parent);
                this.rightRotate(grandparent);
                node.colour = 'B';
                grandparent.colour = 'R';
            } else if ((parent == grandparent.right) && (node == parent.right)) {
                this.leftRotate(grandparent);
                parent.colour = 'B';
                grandparent.colour = 'R';
            } else if ((parent == grandparent.right) && (node == parent.left)) {
                this.rightRotate(parent);
                this.leftRotate(grandparent);
                node.colour = 'B';
                grandparent.colour = 'R';
            }
            this.balanceInsert(grandparent);
        }
//        if (node.parent.isRed()) {
//            if (node.parent.parent.left == node.parent) {
//                if (node.parent.parent.right.isRed()) {
//                    node.parent.parent.left.colour = 'B';
//                    node.parent.parent.right.colour = 'B';
//                    node.parent.parent.colour = 'R';
//                    this.balanceInsert(node.parent.parent);
//                } else {
//                    if (node.parent.right == node) {
//                        this.rotateLeft(node.parent);
//                        this.rotateRight(node.parent);
//                        node.colour = 'B';
//                        node.left.colour = 'R';
//                        node.right.colour = 'R';
//                    } else {
//                        this.rotateRight(node.parent.parent);
//                        node.parent.colour = 'B';
//                        node.parent.right.colour = 'R';
//                    }
//                }
//            } else {
//                if (node.parent.parent.left.isRed()) {
//                    node.parent.parent.left.colour = 'B';
//                    node.parent.parent.right.colour = 'B';
//                    node.parent.parent.colour = 'R';
//                    this.balanceInsert(node.parent.parent);
//                } else {
//                    if (node.parent.left == node) {
//                        this.rotateRight(node.parent);
//                        this.rotateLeft(node.parent);
//                        node.colour = 'B';
//                        node.left.colour = 'R';
//                        node.right.colour = 'R';
//                    } else {
//                        this.rotateLeft(node.parent.parent);
//                        node.parent.colour = 'B';
//                        node.parent.left.colour = 'R';
//                    }
//                }
//            }
//        }
    }

    void printTree(Node node, String indent, boolean last) {
        if (node instanceof Node) {
//             && (node != null)
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
//            System.out.println(node.data);
//            System.out.println( "(", node.low, node.high, ")", "(", node.colour, ")", ':', node.max);
            System.out.println("(" + node.low + ", " + node.high + ") (" + node.colour + ") : " + node.max);
            if (!(node.left instanceof Null))
                this.printTree(node.left, indent, false);
            if (!(node.right instanceof Null))
                this.printTree(node.right, indent, true);
        }

    }
    void singleOverlapNoBacktracking(Node root, int low, int high) {
        if (!(root instanceof Null)) {
            if ((root.low < high) && (root.high > low)) {
                System.out.println("Overlapping interval found");
                System.out.println("("+root.low+","+root.high+")");
            } else if (low < root.left.max) {
                this.singleOverlapNoBacktracking(root.left, low, high);
            } else {
                this.singleOverlapNoBacktracking(root.right, low, high);
            }
        } else {
            System.out.println("No Overlapping interval found");
        }
    }

    void allOverlappingIntervals(Node root, int low, int high, Stack st) {
        if (!(root instanceof Null)) {
            if ((root.low < high) && (root.high > low)) {
                this.allOverlappingIntervals(root.left, low, high, st);
                this.allOverlappingIntervals(root.right, low, high, st);
                st.push(root);
            } if (low < root.left.max) {
                this.allOverlappingIntervals(root.left, low, high, st);
            } if (low < root.right.max) {
                this.allOverlappingIntervals(root.right, low, high, st);
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[][] nodes = {{20, 25}, {15, 40}, {30, 65}, {5, 80}, {18, 70}, {25, 70}, {40, 50}};
//        Node root = new Node(nodes[0][0], nodes[0][1], new Null());
        IntervalTree intervalTree = new IntervalTree(nodes[0][0], nodes[0][1]);
        intervalTree.root.findMax();
        intervalTree.printTree(intervalTree.root, "    ", true);
        System.out.println("____________________________________________________");
        for (int i = 1; i < 7; i++) {
            System.out.println(i);
            intervalTree.insertNode(intervalTree.root, nodes[i][0], nodes[i][1]);
//            intervalTree.buildMaxValue(intervalTree.treeRoot);
            intervalTree.printTree(intervalTree.root, "    ", true);
            System.out.println("____________________________________________________");
        }
        System.out.println("Enter the interval to check overlap : ");
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println("Single Overlap No Backtracking");
        intervalTree.singleOverlapNoBacktracking(intervalTree.root, low, high);
        System.out.println("All Overlapping intervals");
        Stack<Node> st = new Stack<Node>();
        intervalTree.allOverlappingIntervals(intervalTree.root, low, high, st);
        for (int i = 0; i < st.size(); i++) {
            Node root = st.pop();
            System.out.println("("+root.low+","+root.high+")");
        }
    }
}
class Node {
    int low, high;
    int max;
    char colour;
    Node left, right, parent;
    Node(int low, int high, Node parent, Node left, Node right) {
//        super();
        this.low = low;
        this.high = high;
        this.max = 0;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.colour = 'R';
    }

    boolean isNode() {
        return (this instanceof Node);
    }

    int findMax() {
        if (this.left.isNullNode() && this.right.isNullNode()) {
            this.max = this.high;
            return this.max;
        } else if (this.left.isNullNode()) {
            this.max = Math.max(this.high, this.right.findMax());
            return this.max;
        } else if (this.right.isNullNode()) {
            this.max = Math.max(this.high, this.left.findMax());
            return this.max;
        } else {
            this.max = Math.max(this.high, Math.max(this.left.findMax(), this.right.findMax()));
            return this.max;
        }
    }

    boolean isRed() {
        return this.colour == 'R';
    }

    boolean isNullNode() {
        return ((this.colour == 'B') && (this instanceof Null));
    }
}
class Null extends Node {
    //    char colour;
    Null() {
        super(Integer.MIN_VALUE, Integer.MAX_VALUE, null, null, null);
        this.colour = 'B';
    }

//    boolean isRed() {
//        return this.colour == 'R';
//    }


}