import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        // Test Cases
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(Arrays.toString(coins1)+amount1);
        System.out.println("Test Case 1: (expected)=3 (actual)=" + findChange(coins1, amount1)); // Expected output: 3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(Arrays.toString(coins2)+amount2);
        System.out.println("Test Case 2: (expected)=-1 (actual)=" + findChange(coins2, amount2)); // Expected output: -1

        int[] coins3 = {1, 2, 3};
        int amount3 = 0;
        System.out.println(Arrays.toString(coins3)+amount3);
        System.out.println("Test Case 3: (expected)=0 (actual)=" + findChange(coins3, amount3)); // Expected output: 0

        int[] coins4 = {1};
        int amount4 = 1;
        System.out.println(Arrays.toString(coins4)+amount4);
        System.out.println("Test Case 4: (expected)=1 (actual)=" + findChange(coins4, amount4)); // Expected output: 1

        int[] coins5 = {1, 5, 10, 25};
        int amount5 = 99;
        System.out.println(Arrays.toString(coins5)+amount5);
        System.out.println("Test Case 5: (expected)=9 (actual)=" + findChange(coins5, amount5)); // Expected output: 9

        int[] coins6 = {1, 2, 5, 10, 20, 50, 100};
        int amount6 = 567;
        System.out.println(Arrays.toString(coins6)+amount6);
        System.out.println("Test Case 6: (expected)=9 (actual)=" + findChange(coins6, amount6)); // Expected output: 7

        int[] coins7 = {3, 7, 11};
        int amount7 = 5;
        System.out.println(Arrays.toString(coins7)+amount7);
        System.out.println("Test Case 7: (expected)=-1 (actual)=" + findChange(coins7, amount7)); // Expected output: -1

        int[] coins8 = {1, 3, 4};
        int amount8 = 6;
        System.out.println(Arrays.toString(coins8)+amount8);
        System.out.println("Test Case 8: " + findChange(coins8, amount8)); // Expected output: 2

        int[] coins9 = {2, 4, 6};
        int amount9 = 7;
        System.out.println(Arrays.toString(coins9)+amount9);
        System.out.println("Test Case 9: " + findChange(coins9, amount9)); // Expected output: -1
    }
//    static int findChange(int[] coins, int amount) {
//        int ans=-1;
////        int[][] dynamicLookUp = new int[amount][coins.length];
//        if (amount == 0) return 0;
//        if (coins.length == 1) {
//            if (coins[0] == amount) return 1;
//            else if (amount%coins[0] == 0) return amount/coins[0];
//            else return -1;
//        }
////        for (int amt = 0; amt < amount; amt++) {
////            if (amt < coins[0])
////                dynamicLookUp[amt][0] = -1;
////            else if (amt == coins[0]) dynamicLookUp[amt][0] = 1;
////            else if ((amt > coins[0]) && (amt%coins[0] == 0)) dynamicLookUp[amt][0] = amt/coins[0];
////            else
////                dynamicLookUp[amt][0] = -1;
////        }
////        for (int cin = 1; cin < coins.length; cin++) {
////            for (int amt = 1; amt < amount; amt++) {
////                if (coins[cin] == amt) {
////                    dynamicLookUp[amt][cin] = 1;
////                } else if (coins[cin] > amt) {
////                    dynamicLookUp[amt][cin] = Math.min(dynamicLookUp[amt][cin-1], dynamicLookUp[amt-1][cin]+1);
////                } else {
////                    int x = amt - coins[cin];
////                    dynamicLookUp[amt][cin] = Math.min(dynamicLookUp[amt][cin-1], dynamicLookUp[amt-1][x]+1);
////                }
////            }
////        }
////        return dynamicLookUp[amount-1][coins.length-1];
//        int[] dynamicLookUp = new int[amount + 1];
//        Arrays.fill(dynamicLookUp, amount + 1);
//        dynamicLookUp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int coin : coins) {
//                if (coin <= i) {
//                    dynamicLookUp[i] = Math.min(dynamicLookUp[i], dynamicLookUp[i - coin] + 1);
//                }
//            }
//        }
//
//        return dynamicLookUp[amount] > amount ? -1 : dynamicLookUp[amount];
//    }
    static int findChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
