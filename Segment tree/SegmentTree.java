import java.util.*;
class Node {
    int start_index, end_index, sum;
    Node left, right;
    Node(int start_index, int end_index, int sum) {
        this.end_index = end_index;
        this.start_index = start_index;
        this.sum = sum;
        this.left = null;
        this.right = null;
    }
}

class SegmentTree {
    private static int[] arr;
    private Node root;

    public SegmentTree(int[] arr) {
        root = build(arr, 0, arr.length - 1);
    }

    private Node build(int[] arr, int start, int end) {
        if (start == end) {
            return new Node(start, end, arr[end]);
        }
        int mid = (start + end)/ 2;
        Node left_node = build(arr, start, mid);
        Node right_node = build(arr, mid+1, end);
        int sum = left_node.sum + right_node.sum;
        Node new_node = new Node(start, end, sum);
        new_node.left = left_node;
        new_node.right = right_node;
        return new_node;
    }

    private int query(int query_start, int query_end) {
        return query(query_start, query_end, root);
//        only a private method can call a private variable and not a public one
    }

    public int query(int query_start, int query_end, Node root) {
        if ((query_start > root.end_index) || (query_end < root.start_index) || (root == null))
            return 0;
        else if (query_start <= root.start_index && query_end >= root.end_index)
            return root.sum;
        int left_sum = query(query_start, query_end, root.left);
        int right_sum = query(query_start, query_end, root.right);
        return left_sum+right_sum;
    }

    public static void main(String[] arg) {
        int n;
        System.out.println("Enter the number of elements : ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        System.out.println("enter elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SegmentTree st = new SegmentTree(arr);
        System.out.println("enter start and end of query : ");
        int sq = sc.nextInt();
        int se = sc.nextInt();
        System.out.println("the query output : "+st.query(sq, se));
    }
}
