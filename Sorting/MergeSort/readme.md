# Merge Sort

This repository contains an implementation of the Merge Sort algorithm in [programming language].

## Description

Merge Sort is a divide-and-conquer algorithm that divides an array into two halves, sorts them separately, and then merges the sorted halves to produce a sorted array. It is an efficient sorting algorithm with a time complexity of O(n log n).

## Implementation

The Merge Sort algorithm is implemented in the file [filename]. It takes an array as input and returns a sorted array. The algorithm follows these steps:

1. If the array has only one element, it is already sorted, so return the array.
2. Divide the array into two halves.
3. Recursively sort the two halves.
4. Merge the sorted halves to produce a sorted array.

## Usage

To use the Merge Sort algorithm, follow these steps:

1. Include the [filename] file in your project.
2. Call the `mergeSort` function, passing in the array you want to sort.
3. The function will return the sorted array.

```java
def mergeSort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]

    left = mergeSort(left)
    right = mergeSort(right)

    return merge(left, right)

def merge(left, right):
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])

    return result
```

This implementation follows the steps outlined in the documentation:

- If the array has only one element, it is already sorted, so return the array.
- Divide the array into two halves.
- Recursively sort the two halves.
- Merge the sorted halves to produce a sorted array.
- The mergeSort function takes an array as input and returns a sorted array. It first checks if the array has only one element, in which case it returns the array. If not, it divides the array into two halves, sorts them recursively using mergeSort, and then merges the sorted halves using the merge function.
- The merge function takes two sorted arrays as input and merges them into a single sorted array. It does this by iterating over both arrays and comparing their elements. The smaller element is added to the result array, and the iteration continues with the next element. Once one of the arrays is exhausted, the remaining elements from the other array are added to the result array.

To use this implementation, you can include the code in your Python project and call the mergeSort function with the array you want to sort. The function will return the sorted array.

## Complexity Analysis of Merge Sort

- Time Complexity: O(N log(N)), Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation.
- T(n) = 2T(n/2) + θ(n)
- The above recurrence can be solved either using the Recurrence Tree method or the Master method. It falls in case II of the Master Method and the solution of the recurrence is θ(Nlog(N)). The time complexity of Merge Sort isθ(Nlog(N)) in all 3 cases (worst, average, and best) as merge sort always divides the array into two halves and takes linear time to merge two halves.
- Auxiliary Space: O(N), In merge sort all elements are copied into an auxiliary array. So N auxiliary space is required for merge sort.

## Applications of Merge Sort:

- Sorting large datasets: Merge sort is particularly well-suited for sorting large datasets due to its guaranteed worst-case time complexity of O(n log n).
- External sorting: Merge sort is commonly used in external sorting, where the data to be sorted is too large to fit into memory.
- Custom sorting: Merge sort can be adapted to handle different input distributions, such as partially sorted, nearly sorted, or completely unsorted data.

## Advantages of Merge Sort:

- Stability: Merge sort is a stable sorting algorithm, which means it maintains the relative order of equal elements in the input array.
- Guaranteed worst-case performance: Merge sort has a worst-case time complexity of O(N logN), which means it performs well even on large datasets.
- Parallelizable: Merge sort is a naturally parallelizable algorithm, which means it can be easily parallelized to take advantage of multiple processors or threads.

## Drawbacks of Merge Sort:

- Space complexity: Merge sort requires additional memory to store the merged sub-arrays during the sorting process.
- Not in-place: Merge sort is not an in-place sorting algorithm, which means it requires additional memory to store the sorted data. This can be a disadvantage in applications where memory usage is a concern.
- Not always optimal for small datasets: For small datasets, Merge sort has a higher time complexity than some other sorting algorithms, such as insertion sort. This can result in slower performance for very small datasets.
