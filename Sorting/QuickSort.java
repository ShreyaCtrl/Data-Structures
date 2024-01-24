public class QuickSort {
    static void randomQuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = randomPartition(arr, start, end);
            randomQuickSort(arr, start, pivot-1);
            randomQuickSort(arr, pivot+1, end);
        }
    }

    static int randomPartition(int[] arr, int start, int end) {
        int random = Math.random()*end;
        swap(arr, end, random);
        return partition(arr, start, end);
    }

    static int partition(int[] arr, int start, int end) {
        int x = arr[end];
        int i = start-1;
        for (int j = 0; j < r; j++) {
            if (arr[j] <= x) {
                i = i+1;
                swap(arr, i, j);
            }
        }
        swap(i+1, end);
        return i+1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] arg) {

    }
}