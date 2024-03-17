import java.util.*;
class RodCutting {
    int memoizedCutRod(int[] price, int n) {
        int[] revenue = new int[n];
        int[] cut = new int[n];
        for (int i = 0; i < n; i++) {
            revenue[i] = -1;
        }
        return memoizedCutRodAuxiliary(price, n-1, revenue, cut);
    }

    int memoizedCutRodAuxiliary(int[] price, int n, int[] revenue, int[] cut) {
        int q = 0;
        if (revenue[n] >= 0) {
            return revenue[n];
        } else if (n == 0) {
            q = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                int calCost = price[i]+memoizedCutRodAuxiliary(price, n-i, revenue, cut);
                if (q < calCost) {
                    cut[n] = i;
                    q = Math.max(q, calCost);
                }
            }
            System.out.println("Cut at length " + (n) + ", Price: " + price[n] + ", Optimal cost: " + q);
        }
        revenue[n] = q;
        return q;
    }

   void printCuttingSolution(int[] price, int n) {
       while (n > 0) {
           int q = memoizedCutRod(price, n);
           System.out.println("Cut at length " + (n) + ", Price: " + price[n] + ", Optimal cost: " + q);
           n = n - q; // Moving to next piece
       }
   }

    public static void main(String[] arg) {
        RodCutting rodCutting = new RodCutting();
        int[] price = {1, 5, 18, 9, 10, 17, 17, 20}; // Example prices for rod lengths 1 to 8
        int n = price.length;
        int optimalCost = rodCutting.memoizedCutRod(price, n-1); // n - 1 because array is 0-based
        System.out.println("Optimal Cost: " + optimalCost);
       System.out.println("Optimal Cutting:");
       rodCutting.printCuttingSolution(price, n-1);
    }
}