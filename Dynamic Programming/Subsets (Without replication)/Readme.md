## Problem description

Given an integer array nums of unique elements, return all possible
subsets
(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


## Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

## Test cases

For the problem of generating all possible subsets of an integer array, you'd want to test various scenarios to ensure your solution is robust and handles different cases correctly. Here are some different test cases you can use:

1. **Empty Array:**
   Input: `[]`
   Output: `[[]]`
   Explanation: The only subset of an empty array is an empty array itself.

2. **Single Element:**
   Input: `[1]`
   Output: `[[], [1]]`
   Explanation: The subsets are an empty set and the set containing the single element.

3. **Array with Multiple Elements:**
   Input: `[1, 2, 3]`
   Output: `[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]`
   Explanation: All possible subsets including the empty set, single-element subsets, and the full array itself.

4. **Array with Negative Numbers:**
   Input: `[-1, -2, -3]`
   Output: `[[], [-1], [-2], [-1, -2], [-3], [-1, -3], [-2, -3], [-1, -2, -3]]`
   Explanation: Similar to the previous case but with negative numbers.

5. **Array with Duplicate Elements:**
   Input: `[1, 2, 2]`
   Output: `[[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]`
   Explanation: Duplicate elements can create duplicate subsets, which should be handled to avoid repetitions.

6. **Array with Zero:**
   Input: `[0, 1]`
   Output: `[[], [0], [1], [0, 1]]`
   Explanation: Including zero in the array and ensuring it's handled correctly in subsets.

7. **Large Array:**
   Input: `[1, 2, 3, ..., 10]` (an array with elements from 1 to 10)
   Output: A total of `2^10 = 1024` subsets, including the empty set and all combinations of elements.

These test cases cover a range of scenarios, including edge cases like empty arrays, arrays with single elements, arrays with negative numbers or duplicates, and larger arrays to test scalability and correctness.

## Explaination
The problem asks you to generate all possible subsets of a given array of unique integers, also known as the power set. A subset of a set is a collection of some or all of its elements. For example, if you have the set {1, 2, 3}, its subsets are {}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, and {1, 2, 3}. The empty set {} and the set itself {1, 2, 3} are considered subsets as well.

### Approach:

1. **Dynamic Programming:**
    - Initialize an empty list of subsets `dp`.
    - Add an empty subset to `dp` initially.
    - Iterate through each number in the input array.
    - For each number, iterate through the existing subsets in `dp`.
    - Create a new subset by adding the current number to each existing subset and add it to `dp`.
    - Finally, return `dp` containing all subsets.

2. **Example:**
   Let's take the input array `[1, 2, 3]` as an example:
    - Start with an empty subset: `[]`
    - Add 1 to each existing subset: `[]` and `[1]` => `[]`, `[1]`
    - Add 2 to each existing subset: `[]`, `[1]`, `[2]`, `[1, 2]`
    - Add 3 to each existing subset: `[]`, `[1]`, `[2]`, `[1, 2]`, `[3]`, `[1, 3]`, `[2, 3]`, `[1, 2, 3]`
    - Return `dp`: `[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]`

### Complexity Analysis:

- **Time Complexity:** The time complexity is O(2^N), where N is the number of elements in the input array. This is because there are 2^N subsets in the power set, and we generate each subset once.
- **Space Complexity:** The space complexity is also O(2^N) because we store all subsets in the `dp` list.

This dynamic programming approach efficiently generates all subsets without duplicates, making it suitable for arrays with a reasonable number of elements.