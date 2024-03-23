import java.util.Arrays;
import java.util.Scanner;

public class Sample1 {
    public static void main(String[] args) {
//        System.out.println("Enter energy : ");
//        Scanner sc = new Scanner(System.in);
//        int energy, n;
//        energy = sc.nextInt();
//        System.out.println("Enter number of exercises : ");
//        n = sc.nextInt();
//        int[] arr = new int[n];
//        System.out.println(consumeEnergy(arr, energy));

        // Example test cases
        int energy1 = 6;
        int[] exercises1 = {1, 2};
        System.out.println(Arrays.toString(exercises1));
//        int result1 = minExercisesToTire(energy1, exercises1);
//        System.out.println(result1);  // Output: 4
        int result1 = consumeEnergy(energy1, exercises1);
        System.out.println(result1);  // Output: 4


        int energy2 = 10;
        int[] exercises2 = {1, 2};
        System.out.println(Arrays.toString(exercises2));
//        int result2 = minExercisesToTire(energy2, exercises2);
//        System.out.println(result2);  // Output: -1
        int result2 = consumeEnergy(energy2, exercises2);
        System.out.println(result2);  // Output: -1

        int energy3 = 2;
        int[] exercises3 = {1, 5, 2};
        System.out.println(Arrays.toString(exercises3));
//        int result3 = minExercisesToTire(energy3, exercises3);
//        System.out.println(result3);  // Output: -1
        int result3 = consumeEnergy(energy3, exercises3);
        System.out.println(result3);  // Output: -1

        // Additional test cases
        int energy4 = 15;
        int[] exercises4 = {3, 5, 4};
        System.out.println(Arrays.toString(exercises4));
//        int result4 = minExercisesToTire(energy4, exercises4);
//        System.out.println(result4);  // Output: 3
        int result4 = consumeEnergy(energy4, exercises4);
        System.out.println(result4);  // Output: 3

        int energy5 = 8;
        int[] exercises5 = {4, 2, 3};
        System.out.println(Arrays.toString(exercises5));
//        int result5 = minExercisesToTire(energy5, exercises5);
//        System.out.println(result5);  // Output: 2
        int result5 = consumeEnergy(energy5, exercises5);
        System.out.println(result5);  // Output: 2
    }

    static int consumeEnergy(int e, int[] arr) {
        Arrays.sort(arr);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
        System.out.println("Energy is " + e);
        int temp = e, ans = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (temp >= 2 * arr[i]) {
                System.out.println("Exercise "+i+" can be performed 2 times");
                ans += 2;
                temp = temp - 2 * arr[i];
            } else if (temp >= arr[i]) {
                System.out.println("Exercise "+i+" can be performed once");
                ans++;
                temp = temp - arr[i];
            } else {
                if (temp == 0) break;
            }
        }
        if (temp <= 0) {
            return ans;
        } else if (ans == 2* arr.length) {
            return -1;  // If all exercises were performed but energy remains
        } else return ans;
    }


//    Do not uncomment below code it doesnt work
//    public static int minExercisesToTire(int energy, int[] exercises) {
//        Arrays.sort(exercises);  // Sort exercises in increasing order
//        int count = 0;
//
//        for (int ex : exercises) {
//            if (energy <= 0) {  // If energy reaches zero or below, return count
//                return count;
//            }
//
//            if (ex <= energy) {  // If enough energy to perform exercise
//                energy -= ex;
//                count++;
//            }
//
//            if (ex * 2 <= energy) {  // If enough energy to perform exercise twice
//                energy -= ex * 2;
//                count++;
//            }
//        }
//
//        if (energy <= 0) {
//            return count;
//        } else {
//            return -1;  // If all exercises were performed but energy remains
//        }
//    }
}
