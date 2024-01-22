
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

    void setNullPathLength() {
        if (this.left == null && this.right == null) {
            this.nullPathLength = 0;
        } else if (this.left == null) {
            this.nullPathLength = this.right.nullPathLength + 1;
        } else if (this.right == null) {
            this.nullPathLength = this.left.nullPathLength + 1;
        } else {
            this.nullPathLength = Math.min(this.left.nullPathLength, this.right.nullPathLength) + 1;
        }
    }
}
public class LeftistHeap {
    Node root;
    LeftistHeap(int data) {
        this.root = new Node(data);
    }

    LeftistHeap mergeHeaps(LeftistHeap otherHeap) {
        if (this.root == null) {
            return otherHeap;
        } else if (otherHeap.root == null) {
            return this;
        } else if (this.root.data < otherHeap.root.data) {
            
        }
    }
}
