import java.util.*;

public class QuickSort {

    static void randomQuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = randomPartition(arr, start, end);
            System.out.println("Pivot element : " + pivot);
            randomQuickSort(arr, start, pivot - 1);
            randomQuickSort(arr, pivot + 1, end);
        }
    }

    static int randomPartition(int[] arr, int start, int end) {
        Random rand = new Random();
        int random = rand.nextInt(end - start + 1) + start;
        swap(arr, end, random);
        return partition(arr, start, end);
    }

    static int partition(int[] arr, int start, int end) {
        int x = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= x) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] arg) {
        int n;
        System.out.println("Enter the number of elements : ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        randomQuickSort(arr, 0, n - 1);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
