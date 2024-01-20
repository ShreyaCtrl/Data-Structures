import java.util.*;


class AvlTree {
    Node root;
    AvlTree(Node root) {
        this.root = root;
    }
    public static void main(String[] args) {
        Node root = new Node(1, null, null, null);

    }
}
class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    Node(int data, Node left, Node right, Node parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    
    Node leftRotate() {
        Node new_root = this.right;
        this.right = new_root.left;
        if (new_root.left != null) {
            new_root.left.parent = this;
        }
        new_root.parent = this.parent;
        if (this.parent != null) {
            
        }
            self.root = new_root
        elif this == this.parent.left:
            this.parent.left = new_root
        else:
            this.parent.right = new_root
        new_root.left = this
        this.parent = new_root
    }

    Node rightRotate(Node child) {
        return child;
    }
}