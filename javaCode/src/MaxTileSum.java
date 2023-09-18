/*
There is an array A of N integers and three tiles.
Each tile can cover two neighbouring numbers from the array but cannot intersect with another tile.
It also cannot be placed outside the array, even partially.
*/

public class MaxTileSum {
    public static int maxSumWithThreeTiles(int[] A) {
        int N = A.length;

        if (N <= 3) {
            int sum = 0;
            for (int num : A) {
                sum += num;
            }
            return sum;
        }

        int[] dp = new int[N];
        dp[0] = A[0];
        dp[1] = A[0] + A[1];
        dp[2] = Math.max(dp[1], A[0] + A[2]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + A[i], dp[i - 3] + A[i]));
        }

        return dp[N - 1];
    }

    public static void main(String[] args) {
       // int[] A = {2, 3, 5, 2, 3, 4, 6, 4, 1};
        int[] A = {1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1};
        int result = maxSumWithThreeTiles(A);
        System.out.println("Maximum sum of numbers that can be covered: " + result);
    }
}
