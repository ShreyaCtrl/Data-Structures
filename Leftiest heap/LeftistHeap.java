
class Node {
    int data;
    int nullPathLength;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.nullPathLength = 0;
        this.left = null;
        this.right = null;
    }

    public int getNullPathLength() {
        return nullPathLength;
    }

    int setNullPathLength() {
        if (this.left == null && this.right == null) {
            this.nullPathLength = 0;
            return 0;
        } else if (this.left == null) {
            this.nullPathLength = 0;
            return this.nullPathLength;
        } else if (this.right == null) {
            this.nullPathLength = 0;
            return this.nullPathLength;
        } else {
            this.nullPathLength = Math.min(this.left.setNullPathLength(), this.right.setNullPathLength()) + 1;
            return this.nullPathLength;
        }
    }

    void swapChildren() {
        Node temp;
        temp = this.left;
        this.left = this.right;
        this.right = temp;
    }
}
public class LeftistHeap {
    Node root;
    LeftistHeap(int data) {
        this.root = new Node(data);
    }

    Node mergeHeaps(Node thisHeap, Node otherHeap) {
        if (thisHeap == null) {
            return otherHeap;
        } else if (otherHeap == null) {
            return thisHeap;
        } else if (thisHeap.data < otherHeap.data) {
            if (thisHeap.left == null) {
                thisHeap.left = otherHeap;
            } else {
                thisHeap.right = this.mergeHeaps(thisHeap.right, otherHeap);
                thisHeap.right.setNullPathLength();
                System.out.println(thisHeap.left.nullPathLength);
                if (thisHeap.left.nullPathLength < otherHeap.right.nullPathLength) {
                    System.out.println(thisHeap.left.data);
                    System.out.println(thisHeap.right.data);
                    thisHeap.swapChildren();
                    System.out.println(thisHeap.left.data);
                    System.out.println(thisHeap.right.data);
                }
                this.root.setNullPathLength();
            }
            return thisHeap;
        } else {
            if (otherHeap.left == null) {
                otherHeap.left = thisHeap;
            } else {
                otherHeap.right = this.mergeHeaps(thisHeap, otherHeap.right);
                otherHeap.right.setNullPathLength();
                if (otherHeap.left.nullPathLength < otherHeap.right.nullPathLength) {
                    System.out.println(thisHeap.left.data);
                    System.out.println(thisHeap.right.data);
                    otherHeap.swapChildren();
                    System.out.println(thisHeap.left.data);
                    System.out.println(thisHeap.right.data);
                }
                otherHeap.setNullPathLength();
            }
            return otherHeap;
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
            System.out.print(node.data);
            System.out.print(' ');
            System.out.println(node.nullPathLength);
            this.printTree(node.left, indent, false);
            this.printTree(node.right, indent, true);
        }
    }

    void insertNode(int data) {
        this.root = this.mergeHeaps(this.root, new Node(data));
    }

    void deleteMin() {
        if (this.root != null) {
            this.root = this.mergeHeaps(this.root.left, this.root.right);
        }
    }

    public static void main(String[] args) {
        class Node {
            int data;
            int nullPathLength;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
                this.nullPathLength = 0;
                this.left = null;
                this.right = null;
            }

            public int getNullPathLength() {
                return nullPathLength;
            }

            int setNullPathLength() {
                if (this.left == null && this.right == null) {
                    return 0;
                } else if (this.left == null) {
                    return this.right.nullPathLength + 1;
                } else if (this.right == null) {
                    return this.left.nullPathLength + 1;
                } else {
                    this.nullPathLength = Math.min(this.left.setNullPathLength(), this.right.setNullPathLength()) + 1;
                    return this.nullPathLength;
                }
            }

            void swapChildren() {
                Node temp = this.left;
                this.left = this.right;
                this.right = temp;
            }
        }

        public class LeftistHeap {
            Node root;

            LeftistHeaps(int data) {
                this.root = new Node(data);
            }

            Node mergeHeaps(Node thisHeap, Node otherHeap) {
                if (thisHeap == null) {
                    return otherHeap;
                } else if (otherHeap == null) {
                    return thisHeap;
                } else if (thisHeap.data < otherHeap.data) {
                    if (thisHeap.left == null) {
                        thisHeap.left = otherHeap;
                    } else {
                        thisHeap.right = this.mergeHeaps(thisHeap.right, otherHeap);
                        thisHeap.right.setNullPathLength();
                        if (thisHeap.left.nullPathLength < thisHeap.right.nullPathLength) {
                            thisHeap.swapChildren();
                        }
                        thisHeap.setNullPathLength();
                    }
                    return thisHeap;
                } else {
                    if (otherHeap.left == null) {
                        otherHeap.left = thisHeap;
                    } else {
                        otherHeap.right = this.mergeHeaps(thisHeap, otherHeap.right);
                        otherHeap.right.setNullPathLength();
                        if (otherHeap.left.nullPathLength < otherHeap.right.nullPathLength) {
                            otherHeap.swapChildren();
                        }
                        otherHeap.setNullPathLength();
                    }
                    return otherHeap;
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
                    System.out.print(node.data);
                    System.out.print(' ');
                    System.out.println(node.nullPathLength);
                    this.printTree(node.left, indent, false);
                    this.printTree(node.right, indent, true);
                }
            }

            void insertNode(int data) {
                this.root = this.mergeHeaps(this.root, new Node(data));
            }

            void deleteMin() {
                if (this.root != null) {
                    this.root = this.mergeHeaps(this.root.left, this.root.right);
                    if (this.root != null) {
                        this.root.setNullPathLength();
                    }
                }
            }

            public static void main(String[] args) {
                // Your main method remains unchanged
                System.out.println("Leftist Heap");
                System.out.println("_________________________________________");
                System.out.println("leftHeap Tree Insertion");
                System.out.println("_________________________________________");
                System.out.println(23);
                LeftistHeap leftHeap = new LeftistHeap(23);
                leftHeap.printTree(leftHeap.root, "     ", true);
                System.out.println("_________________________________________");
                System.out.println(12);
                leftHeap.insertNode(12);
                leftHeap.printTree(leftHeap.root, "     ", true);
                System.out.println("_________________________________________");
                System.out.println(17);
                leftHeap.insertNode( 17);
                leftHeap.printTree(leftHeap.root, "     ", true);
                System.out.println("_________________________________________");
                System.out.println(35);
                leftHeap.insertNode(35);
                leftHeap.printTree(leftHeap.root, "     ", true);
                System.out.println("_________________________________________");
                System.out.println(20);
                leftHeap.insertNode(20);
                leftHeap.printTree(leftHeap.root, "     ", true);
                System.out.println("_________________________________________");
                System.out.println(25);
                leftHeap.insertNode(25);
                leftHeap.printTree(leftHeap.root, "     ", true);
                System.out.println("_________________________________________");
                System.out.println(40);
                leftHeap.insertNode(40);
                leftHeap.printTree(leftHeap.root, "     ", true);
                System.out.println("_________________________________________");
                System.out.println(30);
                leftHeap.insertNode(30);
                leftHeap.printTree(leftHeap.root, "     ", true);
                System.out.println("_________________________________________");
                System.out.println(19);
                leftHeap.insertNode(19);
                leftHeap.printTree(leftHeap.root, "     ", true);
                System.out.println("_________________________________________");
                System.out.println("leftHeap Tree Deletion");
                System.out.println("_________________________________________");
                System.out.println("Delete Min");
                // System.out.println(19);
                leftHeap.deleteMin();
                leftHeap.printTree(leftHeap.root, "     ", true);
            }
        }

    }
}
