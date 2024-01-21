import java.util.*;
class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    Node(int data, Node parent) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
}
public class SplayTree {
    Node root;

    SplayTree(int data) {
        this.root = new Node(data, null);
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

    void insertNode(Node root, int data) {
        if (root.data > data) {
            if (root.left == null) {
                root.left = new Node(data, root);
                this.splayNode(root.left);
            } else {
                this.insertNode(root.left, data);
            }
        } else if (root.data < data) {
            if (root.right == null) {
                root.right = new Node(data, root);
                this.splayNode(root.right);
            } else {
                this.insertNode(root.right, data);
            }
        }
    }

    void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
            System.out.println(node.data);
            this.printTree(node.left, indent, false);
            this.printTree(node.right, indent, true);
        }
    }

    void splayNode(Node node) {
        if (node == this.root) {
            return;
        }
        Node parent = node.parent;
        Node grandParent = null;
        if (parent != null) {
            grandParent = parent.parent;
        }
        if (grandParent == null) {
            if (parent.left == node) {
//                zig rotation
                this.rightRotate(parent);
            } else if (parent.right == node) {
//                zag rotation
                this.leftRotate(parent);
            }
        } else {
            if (parent.left == node && grandParent.left == parent) {
//                zig-zig rotation
                this.rightRotate(grandParent);
                this.rightRotate(parent);
            } else if (parent.right == node && grandParent.right == parent) {
//                zag-zag rotation
                this.leftRotate(grandParent);
                this.leftRotate(parent);
            } else if (parent.right == node && grandParent.left == parent) {
//                zig-zag rotation
                this.leftRotate(parent);
                this.rightRotate(grandParent);
            } else if (parent.left == node && grandParent.right == parent) {
//                zag-zig rotation
                this.rightRotate(parent);
                this.leftRotate(grandParent);
            }
        }
    }

    public static void main(String[] arg) {
        SplayTree Splay = new SplayTree(23);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        Splay.insertNode(Splay.root, 12);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        Splay.insertNode(Splay.root, 17);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        Splay.insertNode(Splay.root, 35);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        Splay.insertNode(Splay.root, 20);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
    }
}
