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
                this.splayNode(root.left, this.root);
            } else {
                this.insertNode(root.left, data);
            }
        } else if (root.data < data) {
            if (root.right == null) {
                root.right = new Node(data, root);
                this.splayNode(root.right, this.root);
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

    void splayNode(Node node, Node root) {
        if (node.data == root.data) {
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
                this.splayNode(node, this.root);
            } else if (parent.right == node && grandParent.right == parent) {
//                zag-zag rotation
                this.leftRotate(grandParent);
                this.leftRotate(parent);
                this.splayNode(node, this.root);
            } else if (parent.right == node && grandParent.left == parent) {
//                zig-zag rotation
                this.leftRotate(parent);
                this.rightRotate(grandParent);
                this.splayNode(node, this.root);
            } else if (parent.left == node && grandParent.right == parent) {
//                zag-zig rotation
                this.rightRotate(parent);
                this.leftRotate(grandParent);
                this.splayNode(node, this.root);
            }
        }
    }

    void topDownDelete(Node root, int data) {
        if (root == null) {
            return;
        }
        if (root.data == data) {
//            System.out.println(root.data);
            this.splayNode(root, this.root);
//            this.printTree(this.root, "     ", true);
//            System.out.println(root.data);
            if (root.left != null) {
                Node newRoot = root.left;
                while (newRoot.right != null) {
                    newRoot = newRoot.right;
                }
//                System.out.println(newRoot.data);
                this.splayNode(newRoot, this.root.left);
//                this.printTree(this.root, "     ", true);
                newRoot.right = root.right;
                if (root.right != null)
                    root.right.parent = newRoot;
                if (root.left != null) {
                    root.left.parent = null; // Update parent pointer of the left child
                }
                this.root = root.left;
            } else if (root.right != null) {
                this.root = root.right;
                root.right.parent = null;
            } else {
                this.root = null;
            }
        } else if (root.data > data) {
            if (root.left == null) {
                this.splayNode(root, this.root);
            } else
                this.topDownDelete(root.left, data);
        } else {
            if (root.right == null) {
                this.splayNode(root, this.root);
            } else
                this.topDownDelete(root.right, data);
        }
    }

    void bottomUpDelete(Node root, int data) {
        if (root == null) {
            return;
        }
        if (root.data == data) {
            this.bottomUpDeleteCases(root, root.parent);
            this.splayNode(root.parent, this.root);
        } else if (root.data > data) {
            if (root.left == null) {
                this.splayNode(root, this.root);
            } else
                this.bottomUpDelete(root.left, data);
        } else if (root.data < data) {
            if (root.right == null) {
                this.splayNode(root, this.root);
            } else
                this.bottomUpDelete(root.right, data);
        }
    }

    void bottomUpDeleteCases(Node root, Node parent) {
        if (parent == null) {
            this.root = null;
        } else if (root.left != null) {
            Node inOrderPredecessor = root.left;
            while(inOrderPredecessor.right != null) {
                inOrderPredecessor = inOrderPredecessor.right;
            }
            root.data = inOrderPredecessor.data;
            this.bottomUpDeleteCases(inOrderPredecessor, inOrderPredecessor.parent);
        } else if (root.right != null) {
            Node inOrderSuccessor = root.right;
            while(inOrderSuccessor.left != null) {
                inOrderSuccessor = inOrderSuccessor.left;
            }
            root.data = inOrderSuccessor.data;
            this.bottomUpDeleteCases(inOrderSuccessor, inOrderSuccessor.parent);
        } else if (root.right == null && root.left == null) {
            if (parent.left == root) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }

    void searchNode(Node root, int data) {
        if (root.data > data) {
            if (root.left == null) {
                this.splayNode(root, this.root);
            } else {
                this.searchNode(root.left, data);
            }
        } else if (root.data < data) {
            if (root.right == null) {
                this.splayNode(root, this.root);
            } else {
                this.searchNode(root.right, data);
            }
        } else {
            this.splayNode(root, this.root);
        }
    }

    public static void main(String[] arg) {
        System.out.println("_________________________________________");
        System.out.println("Splay Tree Insertion");
        System.out.println("_________________________________________");
        System.out.println(23);
        SplayTree Splay = new SplayTree(23);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println(12);
        Splay.insertNode(Splay.root, 12);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println(17);
        Splay.insertNode(Splay.root, 17);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println(35);
        Splay.insertNode(Splay.root, 35);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println(20);
        Splay.insertNode(Splay.root, 20);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println(25);
        Splay.insertNode(Splay.root, 25);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println(40);
        Splay.insertNode(Splay.root, 40);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println(30);
        Splay.insertNode(Splay.root, 30);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println(19);
        Splay.insertNode(Splay.root, 19);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println("Splay Tree Deletion");
        System.out.println("_________________________________________");
        System.out.println("Bottom Up Approach");
        System.out.println(20);
        Splay.bottomUpDelete(Splay.root, 20);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println("Top Down Approach");
        System.out.println(19);
        Splay.topDownDelete(Splay.root, 19);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
        System.out.println("Splay Tree Searching");
        System.out.println("_________________________________________");
        System.out.println(25);
        Splay.searchNode(Splay.root, 25);
        Splay.printTree(Splay.root, "     ", true);
        System.out.println("_________________________________________");
    }
}
