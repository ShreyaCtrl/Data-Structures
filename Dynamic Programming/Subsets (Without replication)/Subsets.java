import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalAnswer = new ArrayList<>();
        finalAnswer.add(new ArrayList<>());

        for (int num: nums) {
            int size = finalAnswer.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(finalAnswer.get(i));
                subset.add(num);
                finalAnswer.add(subset);
            }
        }
        return finalAnswer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(subsets(arr));
    }
}