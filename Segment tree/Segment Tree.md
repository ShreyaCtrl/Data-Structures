# Segment Tree

## Introduction

- A segment tree is a data structure that allows efficient queries on a range of elements in an array. It is often used in problems where we need to find the minimum, maximum, or sum of a range of elements in an array.

- A segment tree for a set I of n intervals uses O(n log n) storage and can be built in O(n log n) time. Segment trees support searching for all the intervals that contain a query point in time O(log n + k), k being the number of retrieved intervals or segments.

## Implementation

The code provided implements a segment tree in Python. The Segment class takes an array as input and builds a segment tree from it. The build_tree method recursively builds the segment tree by dividing the array into smaller segments and creating nodes for each segment. The build_min_query, build_max_query, and build_sum_query methods build the minimum, maximum, and sum queries for each segment, respectively.

The print_tree method prints the segment tree in a hierarchical format.

## Usage

To use the segment tree, we first create a Segment object with the input array. Then, we can build the segment tree by calling the build_tree method. Once the segment tree is built, we can build the minimum, maximum, or sum queries for any range of elements in the array by calling the build_min_query, build_max_query, or build_sum_query methods, respectively.

## Example

The following example shows how to use the segment tree to find the minimum, maximum, and sum of a range of elements in an array:

```python
# Create a segment tree
st_tree = Segment([1, 2, 3, 4, 5])

# Build the segment tree
st_tree.build_tree()

# Build the minimum query
st_tree.build_min_query()

# Build the maximum query
st_tree.build_max_query()

# Build the sum query
st_tree.build_sum_query()

# Print the segment tree
st_tree.print_tree()

# Find the minimum of the range [1, 3]
min_value = st_tree.build_min_query(1, 3)

# Find the maximum of the range [1, 3]
max_value = st_tree.build_max_query(1, 3)

# Find the sum of the range [1, 3]
sum_value = st_tree.build_sum_query(1, 3)

```

## Application

Segment tree data structure can be used to solve various problems like:

- Range Min, Max & Sum Queries, and Range Update Queries
- segment tree with the max build, query, and update.
- segment tree with min build, query, and update.
- Computational geometry: Computational geometry is a mathematical field that includes the design, and analysis of efficient algorithms for solving geometric I/O problems. It is also used for pattern recognition and describes solid modeling algorithms.
- Geographic information systems: A Geographic Information System is a system that uses data that is attached to a unique location, and analyzes and generates geographically referenced information.
- Storing segments in an arbitrary manner.
- Used in competitive programming.
- Segment trees can be used to count the frequency of elements in a given range.
- Segment trees can be used for image processing tasks.

## Advantage and Disadvantage

| S.No | Advantages                                                                                       | Disadvantages                                                                      |
| ---- | ------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------------------------- |
| 1    | There is no need to know tree rotation because in the test cases a divide and conquer algorithm. | Time Complexity of each and every query is O(log^2 max(n))                         |
| 2    | Fast execution of code in general test cases.                                                    | Source code is longer than source using a balanced tree.                           |
| 3    | Allows processing interval or range queries in logarithmic time.                                 | Segment trees require a large amount of memory to store all the nodes of the tree. |
| 4    | It performs well for large datasets.                                                             | The implementation of segment trees can be complex and difficult to                |
