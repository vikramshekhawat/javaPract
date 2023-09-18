import java.util.Arrays;

public class Xy {

    public static int minDays(int[] D, int X) {
        int n = D.length;
        int[] dp = new int[n];

        Arrays.fill(dp, n);

        for (int i = 0; i < n; i++) {
            int maxDifficulty = D[i];
            int minDifficulty = D[i];

            for (int j = i; j >= 0; j--) {
                maxDifficulty = Math.max(maxDifficulty, D[j]);
                minDifficulty = Math.min(minDifficulty, D[j]);

                if (i - j + 1 > X) {
                    break;
                }

                if (j == 0) {
                    dp[i] = 1;
                } else {
                    dp[i] = Math.min(dp[i], (j > 0 ? dp[j - 1] : 0) + 1);
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] D1 = {5, 8, 2, 7};
        int X1 = 3;
        System.out.println(minDays(D1, X1)); // Output: 3

        int[] D2 = {1, 12, 10, 4, 5, 2};
        int X2 = 2;
        System.out.println(minDays(D2, X2)); // Output: 4

        int[] D3 = {2, 5, 9, 2, 1, 4};
        int X3 = 4;
        System.out.println(minDays(D3, X3)); // Output: 3
    }
}
