import java.util.Scanner;

class MatrixChain {
    static void matrixChainOrder(int[] p, int[][] scalarMultiplication, int[][] optimalBreak) {
        int n = p.length-1;
        for (int i = 0; i <=n; i++) {
            scalarMultiplication[i][i] = 0;
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n-length+1; i++) {
                int j = i + length-1;
                scalarMultiplication[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int q = scalarMultiplication[i][k] + scalarMultiplication[k+1][j] + p[i]*p[j]*p[k];
                    if (q < scalarMultiplication[i][j]) {
                        scalarMultiplication[i][j] = q;
                        optimalBreak[i][j] = k;
                    }
                }
            }
        }
        printOptimalParenthesis(optimalBreak, 1, n);
    }

    static void printOptimalParenthesis(int[][] optimalBreak, int i, int j) {
        if (i == j) {
            System.out.print("M"+i);
        } else {
            System.out.print("(");
            printOptimalParenthesis(optimalBreak, i, optimalBreak[i][j]);
            printOptimalParenthesis(optimalBreak, optimalBreak[i][j]+1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] arg) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i< n; i++) {
            p[i] = sc.nextInt();
        }
        matrixChainOrder(p, new int[p.length][p.length], new int[p.length][p.length]);
    }
}
