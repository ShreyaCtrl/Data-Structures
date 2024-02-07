import java.util.*;
class MergeSort {
    static void mergeSort(int arr[], int left, int middle, int right) {
        int n1 = middle - left +1;
        int n2 = right - middle;

        int leftPart[] = new int[n1];
        int rightPart[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftPart[i] = arr[left +i];
        }
        for (int i = 0; i < n2; i++) {
            rightPart[i] = arr[middle+i+1];
        }
        int i = 0, j = 0, k =left;
        while (i < n1 && j < n2) {
            if (leftPart[i] <= rightPart[j]) {
                arr[k] = leftPart[i];
                i++;
            } else {
                arr[k] = rightPart[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftPart[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = rightPart[j];
            j++;
            k++;
        }
    }

    static void partition(int arr[], int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            partition(arr, left, middle);
            partition(arr, middle+1, right);
            mergeSort(arr, left, middle, right);
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] arg) {
        int n = 10;
        int[] arr = new int[]{23, 17, 14, 6, 13, 10, 1, 5, 7, 12};
        System.out.println("Given array");
        printArray(arr);
        partition(arr, 0, arr.length -1);
        System.out.println("Sorted array");
        printArray(arr);
    }
}