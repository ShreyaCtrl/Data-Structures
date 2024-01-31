import java.util.*;

class HeapSort {
    static void buildMaxHeap(int[] arr) {
        int heapSize = arr.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, heapSize);
        }
    }

    static void maxHeapify(int[] arr, int i, int heapSize) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int leftChild(int index) {
        return 2 * index + 1;
    }

    static int rightChild(int index) {
        return 2 * index + 2;
    }

    static void heapSort(int[] arr) {
        int heapSize = arr.length;

        buildMaxHeap(arr);

        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr, 0, i);
            heapSize--;
            maxHeapify(arr, 0, heapSize);
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[]{23, 17, 14, 6, 13, 10, 1, 5, 7, 12};
        System.out.println("Given array");
        printArray(arr);
        heapSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
