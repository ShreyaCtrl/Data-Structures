# Splay Tree Implementation in Java

## Introduction

A Splay tree is a self-balancing binary search tree (BST) where the most recently accessed elements are stored near the root of the tree, allowing for faster access to frequently used data. This document provides a detailed explanation of the implementation of a Splay tree in Java, along with step-by-step instructions on how to use it.

## Implementation Details

The Splay tree implementation in Java consists of the following key components:

- **Node Class**: Represents a node in the Splay tree. Each node contains a data value, references to its left and right child nodes, and a reference to its parent node.

- **SplayTree Class**: Implements the Splay tree data structure. It contains methods for inserting, deleting, and searching for nodes, as well as methods for performing splaying operations.

## Step-by-Step Explanation of the Code

### 1. Node Class

```java
class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    Node(int data, Node parent) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
}
```

- The `Node` class represents a node in the Splay tree.
- Each node has a `data` field to store the value, `left` and `right` fields to point to its child nodes, and a `parent` field to point to its parent node.
- The constructor initializes a new node with the given `data` and `parent`.

### 2. SplayTree Class

- The `insertNode` method takes a `root` node and an `data` value as input.
- It recursively traverses the tree to find the correct location to insert the new node.
- If the `data` value is less than the current node's `data`, it moves to the left child; otherwise, it moves to the right child.
- Once the new node is inserted, it performs a splaying operation on the path from the leaf node to the root node to balance the tree.

### 4. Deletion

- The `deleteNode` method takes a `root` node and an `data` value as input.
- It recursively traverses the tree to find the node with the given `data` value.
- If the node is found, it performs the following steps:
  - If the node has no children, it sets the root to null.
  - If the node has one child, it sets the root to the non-null child and sets the child's parent to null.
  - If the node has two children, it finds the minimum value in the right subtree (the successor), copies the successor's data value to the current node, and recursively deletes the successor node.
- Once the node is deleted, it performs a splaying operation on the path from the leaf node to the root node to balance the tree.
- Otherwise, it finds the "successor" which is the smallest node in the right sub

### 5. Searching

- The splay method takes a node as input and performs a splaying operation on the path from the leaf node to the node.
- The rotateLeft and rotateRight methods perform left and right rotations, respectively, on a node and its child nodes.
- These rotations help balance the tree and move the accessed node closer to the root.

### 6. Splaying

- After accessing or deleting a node, we call the `splay` function on that node
- The `splay` function takes a node as input and performs a splaying operation on the path from the leaf node to the node.
- The `rotateLeft` and `rotateRight` methods perform left and right rotations, respectively, on a node and its child nodes.
- These rotations help balance the tree and move the accessed node closer to the root.

## Drawbacks of splay tree data structure:

- Unbalanced Trees: Splay trees can become unbalanced and inefficient if the tree is repeatedly rotated in the same direction.
- Memory Usage: Splay trees can use a lot of memory compared to other data structures because each node contains additional information.
- Complexity: Splay trees can have a high time complexity for basic operations such as insertion and deletion because the trees need to be reorganized after every operation.
- Reorganization Overhead: The splaying operation required in every operation can be time-consuming and result in a high overhead.
- Limited Use Cases: Splay trees are not suitable for all data structures and have limited use cases because they don’t handle duplicate keys efficiently.

## Applications of the splay tree:

- Caching: Splay trees can be used to implement cache memory management, where the most frequently accessed items are moved to the top of the tree for quicker access.
- Database Indexing: Splay trees can be used to index databases for faster searching and retrieval of data.
- File Systems: Splay trees can be used to store file system metadata, such as the allocation table, directory structure, and file attributes.
- Data Compression: Splay trees can be used to compress data by identifying and encoding repeating patterns.
- Text Processing: Splay trees can be used in text processing applications, such as spell-checkers, where words are stored in a splay tree for quick searching and retrieval.
- Graph Algorithms: Splay trees can be used to implement graph algorithms, such as finding the shortest path in a weighted graph.
- Online Gaming: Splay trees can be used in online gaming to store and manage high scores, leaderboards, and player statistics.
