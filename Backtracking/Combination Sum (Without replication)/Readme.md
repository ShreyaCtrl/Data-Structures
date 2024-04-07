## Problem description

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

## Sample Test cases 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

## Constraints:

1 <= candidates.length <= 100

1 <= candidates[i] <= 50

1 <= target <= 30

## Explaination
This code is a Java implementation of the combination sum problem with a twist: it allows duplicates in the input array `candidates`, but it avoids duplicate combinations in the output. Let's break down the code step by step:

1. **Sorting the candidates:**
   ```java
   Arrays.sort(candidates);
   ```
   This line sorts the `candidates` array in ascending order. Sorting is essential for handling duplicates efficiently, as it allows us to skip duplicate elements during the backtracking process.

2. **Main function:**
   ```java
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       ...
   }
   ```
   This is the main function that takes an array of integers `candidates` and an integer `target`. It initializes an empty list called `answer` to store the final combinations and then calls the `backtrack` function to find the combinations that sum up to the target.

3. **Backtracking function:**
   ```java
   public void backtrack(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> currentAnswer) {
       ...
   }
   ```
   This function performs the backtracking algorithm to find combinations that sum up to the target. It takes parameters such as the starting index `index`, the `candidates` array, the remaining `target`, the `ans` list to store valid combinations, and `currentAnswer` to keep track of the current combination being constructed.

4. **Base case:**
   ```java
   if (target == 0) {
       ans.add(new ArrayList<>(currentAnswer));
       return;
   }
   ```
   If the `target` becomes zero, it means we have found a valid combination. We add a copy of `currentAnswer` to `ans` because `currentAnswer` will be modified during backtracking.

5. **Backtracking loop:**
   ```java
   for (int i = index; i < candidates.length; i++) {
       if (i > index && candidates[i] == candidates[i - 1]) {
           continue;
       }
       if (candidates[i] <= target) {
           currentAnswer.add(candidates[i]);
           backtrack(i + 1, candidates, target - candidates[i], ans, currentAnswer);
           currentAnswer.remove(currentAnswer.size() - 1);
       }
   }
   ```
   - The loop iterates over the candidates starting from the `index`.
   - It skips duplicate elements by checking if `i` is greater than `index` and the current element is equal to the previous one.
   - If the current element is less than or equal to the remaining `target`, it adds the element to `currentAnswer`, reduces the `target` accordingly, recursively calls `backtrack` with the updated parameters, and then removes the last element from `currentAnswer` (backtracking step).

Overall, the code efficiently generates unique combinations that sum up to the target, handling duplicates in the input array.