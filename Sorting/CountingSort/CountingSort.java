import java.util.*;

class CountingSort {
    static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    static int[] countFrequency(int[] arr, int[] frequencyArr) {
        // count frequency of individual items
        for (int i = 0; i < arr.length; i++) {
            frequencyArr[arr[i]]++;
        }
        // count cumulative frequency
        for (int i = 1; i < frequencyArr.length; i++) {
            frequencyArr[i] = frequencyArr[i - 1] + frequencyArr[i];
        }
        return frequencyArr;
    }

    static void sortItems(int[] arr, int[] frequencyArr) {
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = --frequencyArr[arr[i]];
            sortedArray[index] = arr[i];
        }
        printArray(sortedArray);
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9};
        int max = findMax(inputArray);
        System.out.println(max);
        int[] frequencyArr = countFrequency(inputArray, new int[max + 1]);
        sortItems(inputArray, frequencyArr);
    }
}
