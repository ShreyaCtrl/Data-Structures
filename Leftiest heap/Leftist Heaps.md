# Leftist Heaps

Leftist heaps are a type of binary heap that maintain the heap property while also ensuring that the path from the root to any leaf is as short as possible. This is achieved by storing the length of the longest path from each node to a leaf in the `nullPathLength` attribute of each node.

## Implementation Details

### Node Class

The `Node` class represents a node in the leftist heap. It has the following attributes:

- `data`: The data stored in the node.
- `nullPathLength`: The length of the longest path from the node to a leaf.
- `left`: A reference to the left child of the node.
- `right`: A reference to the right child of the node.

The `Node` class also has the following methods:

- `getNullPathLength()`: Returns the length of the longest path from the node to a leaf.
- `setNullPathLength()`: Calculates and sets the length of the longest path from the node to a leaf.
- `swapChildren()`: Swaps the left and right children of the node.

### LeftistHeaps Class

The `LeftistHeaps` class represents a leftist heap. It has the following attributes:

- `root`: A reference to the root node of the heap.

The `LeftistHeaps` class also has the following methods:

- `mergeHeaps(Node thisHeap, Node otherHeap)`: Merges two leftist heaps into a single leftist heap.
- `printTree(Node node, String indent, boolean last)`: Prints the leftist heap in a tree-like format.
- `insertNode(int data)`: Inserts a new node into the leftist heap.
- `deleteMin()`: Deletes the node with the minimum data value from the leftist heap.

## Example Usage

The following code shows how to use the `LeftistHeaps` class to create and manipulate a leftist heap:

```java
public class Main {

    public static void main(String[] args) {
        // Create a leftist heap
        LeftistHeaps leftHeap = new LeftistHeaps(23);

        // Insert nodes into the leftist heap
        leftHeap.insertNode(12);
        leftHeap.insertNode(17);
        leftHeap.insertNode(35);
        leftHeap.insertNode(20);
        // Print the leftist heap
        leftHeap.printTree();

        // Delete the minimum node
        leftHeap.deleteMin();

        // Print the leftist heap after deleting the minimum node
        leftHeap.printTree();
    }
}
```

### Merge Heap Operation

The mergeHeaps operation is used to merge two leftist heaps into a single leftist heap. It takes two nodes, thisHeap and otherHeap, as input arguments and returns a new node that represents the merged heap.

The mergeHeaps operation first checks if either thisHeap or otherHeap is null. If one of them is null, it returns the non-null heap as the merged heap.

If both thisHeap and otherHeap are non-null, it compares their data values to determine which one should be the root of the merged heap. The heap with the smaller data value becomes the root of the merged heap.

If thisHeap has a smaller data value than otherHeap, it recursively merges thisHeap.right with otherHeap using the mergeHeaps operation. The returned node from the recursive call becomes the right child of thisHeap. It then updates the nullPathLength of thisHeap to be the maximum of its current nullPathLength and the nullPathLength of its left child, and then swaps the left and right children of thisHeap if necessary to ensure that the left child has a smaller nullPathLength than the right child.

If otherHeap has a smaller data value than thisHeap, it recursively merges thisHeap with otherHeap.right using the mergeHeaps operation. The returned node from the recursive call becomes the right child of otherHeap. It then updates the nullPathLength of otherHeap to be the maximum of its current nullPathLength and the nullPathLength of its left child, and then swaps the left and right children of otherHeap if necessary to ensure that the left child has a smaller nullPathLength than the right child.

Finally, it returns the root of the merged heap, which is either thisHeap or otherHeap, depending on which one has the smaller data value.

The mergeHeaps operation ensures that the resulting merged heap is still a leftist heap by maintaining the leftist heap property, which states that the nullPathLength of the left child of any node is greater than or equal to the nullPathLength of the right child. This is achieved by swapping the left and right children of a node if necessary to ensure that the left child has a smaller nullPathLength than the right child.

## Time Complexity

The time complexity of all operations like Insert(), deleteMin(), findMin() and Merge() on a Leftist Heap is O(log n). This is because the height of a Leftist Heap is always O(log n).

## Auxiliary Space

The space complexity of a Leftist Heap is O(n). This is because the Leftist Heap requires space for storing n number of elements.

## Advantages of Leftist Tree:

- Efficient extract-min operation: The extract-min operation has a time complexity of O(log n), making it one of the most efficient data structures for this operation.
- Efficient merging: The merge operation has a time complexity of O(log n), making it one of the fastest data structures for merging two binary heaps.
- Simple implementation: The leftist tree has a relatively simple implementation compared to other binary heap data structures, such as Fibonacci heaps.

## Disadvantages of Leftist Tree:

- Slower insert operation: The insert operation in a leftist tree has a time complexity of O(log n), making it slower than other binary heap data structures, such as binary heaps.
- Increased memory usage: The leftist tree uses more memory than other binary heap data structures, such as binary heaps, due to its requirement for the maintenance of null path length values for each node.
