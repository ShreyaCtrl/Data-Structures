## Dynamic Programming

Dynamic programming is a technique used in computer programming to solve complex problems by breaking them down into simpler overlapping subproblems. It is particularly useful when the problem can be divided into smaller subproblems that can be solved independently, and the solution to the larger problem can be constructed from the solutions of the subproblems.

The key idea behind dynamic programming is to store the solutions to the subproblems in a table or an array, so that they can be reused when needed. This avoids redundant computations and improves the overall efficiency of the algorithm.

Dynamic programming is often used to solve optimization problems, where the goal is to find the best solution among a set of possible solutions. It is widely used in various domains, including algorithms, artificial intelligence, operations research, and economics.

Some well-known algorithms that use dynamic programming include the Fibonacci sequence, the knapsack problem, and the shortest path problem.

In order to apply dynamic programming, the problem must have two key properties: optimal substructure and overlapping subproblems. Optimal substructure means that the optimal solution to the problem can be constructed from the optimal solutions of its subproblems. Overlapping subproblems means that the same subproblems are solved multiple times.

By using dynamic programming, we can solve complex problems efficiently and avoid unnecessary computations, leading to faster and more optimized algorithms.

### Characteristics of Dynamic Programming Algorithm:
- In general, dynamic programming (DP) is one of the most powerful techniques for solving a certain class of problems. 
- There is an elegant way to formulate the approach and a very simple thinking process, and the coding part is very easy. 
- Essentially, it is a simple idea, after solving a problem with a given input, save the result as a reference for future use, so you won’t have to re-solve it.. briefly ‘Remember your Past’ :). 
- It is a big hint for DP if the given problem can be broken up into smaller sub-problems, and these smaller subproblems can be divided into still smaller ones, and in this process, you see some overlapping subproblems. 
- Additionally, the optimal solutions to the subproblems contribute to the optimal solution of the given problem (referred to as the Optimal Substructure Property).
-  The solutions to the subproblems are stored in a table or array (memoization) or in a bottom-up manner (tabulation) to avoid redundant computation.
- The solution to the problem can be constructed from the solutions to the subproblems.
- Dynamic programming can be implemented using a recursive algorithm, where the solutions to subproblems are found recursively, or using an iterative algorithm, where the solutions are found by working through the subproblems in a specific order.

### Techniques to solve Dynamic Programming Problems:
1. Top-Down(Memoization):
Break down the given problem in order to begin solving it. If you see that the problem has already been solved, return the saved answer. If it hasn’t been solved, solve it and save it. This is usually easy to think of and very intuitive, This is referred to as Memoization.

2. Bottom-Up(Dynamic Programming):
Analyze the problem and see in what order the subproblems are solved, and work your way up from the trivial subproblem to the given problem. This process ensures that the subproblems are solved before the main problem. This is referred to as Dynamic Programming.

