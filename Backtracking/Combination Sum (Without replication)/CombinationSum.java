import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CombinationSum {
    public static List<List<Integer>> combinationSum2(int[] candidate, int target) {
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
            backtrack(index+1, candidates, target-candidates[index], ans, currentAnswer);
            currentAnswer.remove(currentAnswer.size()-1);
        }
        backtrack(index+1, candidates, target, ans, currentAnswer);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] candidate = new int[n];
        int target = scanner.nextInt();
        System.out.println(combinationSum2(candidate, target));
    }
}