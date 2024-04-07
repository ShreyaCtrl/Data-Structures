## Problem Description

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

## Test cases 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []


## Constraints:

1 <= candidates.length <= 30

2 <= candidates[i] <= 40

All elements of candidates are distinct.

1 <= target <= 40

## Explaination
This code is a Java implementation of the combination sum problem using a backtracking approach. It aims to find all unique combinations of numbers from the `candidate` array that sum up to the given `target`. Let's break down the code step by step:

1. **Main function:**
   ```java
   public static List<List<Integer>> combinationSum(int[] candidate, int target) {
       List<List<Integer>> answer = new ArrayList<>();
       backtrack(0, candidate, target, answer, new ArrayList<>());
       return answer;
   }
   ```
    - The `combinationSum` function is the entry point for finding combinations.
    - It initializes an empty list called `answer` to store the final combinations.
    - It calls the `backtrack` function with the starting index `0`, the `candidate` array, the `target`, an empty `answer` list, and an initially empty `currentAnswer` list.

2. **Backtracking function:**
   ```java
   public static void backtrack(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> currentAnswer) {
       if (candidates.length == index) {
           if (target == 0)
               ans.add(new ArrayList<>(currentAnswer));
           return;
       }
       if(candidates[index] <= target) {
           currentAnswer.add(candidates[index]);
           backtrack(index, candidates, target-candidates[index], ans, currentAnswer);
           currentAnswer.remove(currentAnswer.size()-1);
       }
       backtrack(index+1, candidates, target, ans, currentAnswer);
   }
   ```
    - The `backtrack` function performs the core backtracking algorithm.
    - It has parameters like the current `index`, the `candidates` array, the remaining `target`, the `ans` list to store valid combinations, and `currentAnswer` to keep track of the current combination being constructed.
    - The base case is when `index` reaches the length of `candidates`. If `target` is also zero, it means we have found a valid combination, so we add a copy of `currentAnswer` to `ans`.
    - The function then recursively explores two possibilities:
        1. Include the current candidate at `index` in the combination if it doesn't exceed the target.
        2. Skip the current candidate and move to the next index.

Overall, this code efficiently generates all unique combinations of numbers from the `candidate` array that sum up to the target using backtracking.