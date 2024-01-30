import java.util.*;
class MaxHeap {
    static void buildMaxHeap(int[] arr) {
        int heapSize = arr.length;
        for (int i = heapSize/2; i >0; i--) {
            maxHeapify(arr, i);
        }
    }

    static void maxHeapify(int[] arr, int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if ((left < arr.length) && (arr[left] > arr[i])) {
            largest = left;
        }
        if ((right < arr.length) && (arr[right] > arr[i])) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest);
        }
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int leftChild(int index) {
        return index*2;
    }

    static int rightChild(int index) {
        return index*2+1;
    }

    public static void main(String[] arg) {
        System.out.println("Enter the number of elements : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        arr = new int[]{23, 17, 14, 6, 13, 10, 1, 5, 7, 12};
        buildMaxHeap(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}