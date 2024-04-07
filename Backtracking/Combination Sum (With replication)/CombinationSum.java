import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        //        print(combinationSum([2,3,7],18))
        //        print("_________________________________________________________________")
        //        print(combinationSum([2,3,6,7],7))
        //        print("_________________________________________________________________")
        //        print(combinationSum([2,3,5],8))
        //        print("_________________________________________________________________")
        //        print(combinationSum([2],1))
        //        print("_________________________________________________________________")
        //        print(combinationSum([8,7,4,3],11))
        System.out.println(Arrays.toString(new int[] { 2, 3, 7 }) + " " + 18);
        System.out.println(combinationSum(new int[] { 2, 3, 7 }, 18));
        System.out.println(Arrays.toString(new int[] { 2, 3, 6, 7 }) + " " + 7);
        System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
        System.out.println(Arrays.toString(new int[] { 2, 3, 5 }) + " " + 8);
        System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
    }
    
    // Solution 1 : Takes too much time and space compared to other solutions of leetcode 
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> listAnswer = new ArrayList<>();
    //     Arrays.sort(candidates);
    //     backTrack(listAnswer, new ArrayList<>(), candidates, target, 0);
    //     return listAnswer;
    // }

    // public void backTrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int remain, int start) {
    //     if (remain < 0)
    //         return;
    //     else if (remain == 0)
    //         list.add(new ArrayList<>(temp));
    //     else {
    //         for (int i = start; i < candidates.length; i++) {
    //             temp.add(candidates[i]);
    //             backTrack(list, temp, candidates, remain - candidates[i], i);
    //             temp.remove(temp.size() - 1);
    //         }
    //     }
    // }
    
    // Solution 2: 
    public static List<List<Integer>> combinationSum(int[] candidate, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(0, candidate, target, answer, new ArrayList<>());
        return answer;
    }
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
}
