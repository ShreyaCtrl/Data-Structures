## Heap Sort

### Introduction

Heap sort is a comparison-based sorting algorithm that works by building a binary heap data structure. It is an in-place algorithm, meaning it does not require any additional memory space. Heap sort is not stable, meaning that the relative order of equal elements in the input may be changed in the output.

### Implementation Details

The implementation of heap sort in Java consists of the following steps:

1. **Building the Max Heap**:
   - The `buildMaxHeap` method takes an array as input and builds a max heap.
   - It starts from the last non-leaf node and recursively calls the `maxHeapify` method on each node to ensure that the heap property is satisfied.
   - The heap property states that for any node, the value of the node is greater than or equal to the values of its children.

```java
static void buildMaxHeap(int[] arr) {
    int heapSize = arr.length;
    for (int i = heapSize / 2 - 1; i >= 0; i--) {
        maxHeapify(arr, i, heapSize);
    }
}
```

2. **Max Heapify**:
   - The `maxHeapify` method maintains the heap property by recursively comparing a node with its children and swapping the values if necessary.
   - It takes three parameters: the array, the index of the current node, and the size of the heap.
   - It first calculates the indices of the left and right children of the current node.
   - It then finds the largest value among the current node and its children.
   - If the largest value is not the current node, it swaps the values of the current node and the largest child and recursively calls `maxHeapify` on the child.

```java
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

static int leftChild(int i) {
    return 2 * i + 1;
}

static int rightChild(int i) {
    return 2 * i + 2;
}

static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

static void heapSort(int[] arr) {
    buildMaxHeap(arr);

    int heapSize = arr.length;
    for (int i = heapSize - 1; i > 0; i--) {
        swap(arr, 0, i);
        heapSize--;
        maxHeapify(arr, 0, heapSize);
    }
}
```

## Advantages of Heap Sort:

- Efficient Time Complexity: Heap Sort has a time complexity of O(n log n) in all cases. This makes it efficient for sorting large datasets. The log n factor comes from the height of the binary heap, and it ensures that the algorithm maintains good performance even with a large number of elements.
- Memory Usage – Memory usage can be minimal because apart from what is necessary to hold the initial list of items to be sorted, it needs no additional memory space to work
- Simplicity – It is simpler to understand than other equally efficient sorting algorithms because it does not use advanced computer science concepts such as recursion.

## Disadvantages of Heap Sort:

- Costly: Heap sort is costly.
- Unstable: Heap sort is unstable. It might rearrange the relative order.
- Efficient: Heap Sort is not very efficient when working with highly complex data.
