# QuickSort Java Implementation with Random Pivot Selection

This repository contains a Java implementation of the QuickSort algorithm with a random pivot selection strategy. QuickSort is a widely used sorting algorithm known for its efficiency in sorting large arrays.

## Understanding the Code

### 1. Importing Necessary Libraries

```java
import java.util.*;
```

This line imports the necessary Java libraries, including the `Scanner` class for user input and the `Random` class for generating random numbers.

### 2. `QuickSort` Class

The `QuickSort` class contains the main logic for sorting an array of integers using the QuickSort algorithm.

### 3. `randomQuickSort` Method

```java
static void randomQuickSort(int[] arr, int start, int end) {
    if (start < end) {
        int pivot = randomPartition(arr, start, end);
        System.out.println("Pivot element : " + pivot);
        randomQuickSort(arr, start, pivot - 1);
        randomQuickSort(arr, pivot + 1, end);
    }
}
```

This method implements the QuickSort algorithm with a random pivot selection strategy. It takes three parameters:

- `arr`: The array to be sorted.
- `start`: The starting index of the subarray to be sorted.
- `end`: The ending index of the subarray to be sorted.

The algorithm works as follows:

1. If the `start` index is less than the `end` index, it means there are elements to be sorted.
2. It calls the `randomPartition` method to select a random pivot element and partition the array around the pivot.
3. It prints the selected pivot element.
4. It recursively calls itself to sort the left and right subarrays created by the partitioning.

### 4. `randomPartition` Method

```java
static int randomPartition(int[] arr, int start, int end) {
    Random rand = new Random();
    int random = rand.nextInt(end - start + 1) + start;
    swap(arr, end, random);
    return partition(arr, start, end);
}
```

This method selects a random pivot element and partitions the array around the pivot. It takes three parameters:

- `arr`: The array to be partitioned.
- `start`: The starting index

### 5. `partition` Method

```java
static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = (start - 1);

    for (int j = start; j < end; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, end);
    return (i + 1);
}
```

This method partitions the array around a pivot element. It takes three parameters:

`arr`: The array to be partitioned.
`start`: The starting index of the subarray to be partitioned.
`end`: The ending index of the subarray to be partitioned.
The algorithm works as follows:

It selects the last element of the subarray as the pivot element.
It initializes an index i to one less than the starting index.
It iterates through the subarray, comparing each element with the pivot element.
If an element is less than or equal to the pivot element, it increments the i index and swaps the element at the i index with the current element.
After the loop, it swaps the pivot element with the element at the i + 1 index.
It returns the final i + 1 index, which is the position of the pivot element in the sorted subarray.
