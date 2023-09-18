import java.util.Arrays;

public class Dev {
    public static int[] minimumInitialBalances(String R, int[] V) {
        int balanceA = 0;
        int balanceB = 0;

        for (int i = 0; i < R.length(); i++) {
            char recipient = R.charAt(i);
            int value = V[i];

            if (recipient == 'A') {
                balanceA += value;
            } else {
                balanceB += value;
            }

            // Ensure the balances don't go below 0
            balanceA = Math.max(0, balanceA);
            balanceB = Math.max(0, balanceB);
        }

        return new int[]{balanceA, balanceB};
    }
    public static int[] solution(String recipients, int[] amounts) {
        int minA = 0;
        int minB = 0;

        int balA = 0;
        int balB = 0;

        for (int i = 0; i < recipients.length(); i++) {
            if (recipients.charAt(i) == 'A') {
                balA += amounts[i];
                balB -= amounts[i];
                if (balB < minB) {
                    minB = balB;
                }
            } else if (recipients.charAt(i) == 'B') {
                balB += amounts[i];
                balA -= amounts[i];
                if (balA < minA) {
                    minA = balA;
                }
            }
        }

        return new int[] { -minA, -minB };
    }
    public static void main(String[] args) {
        String R = "BAABA";
        int[] V = {2, 4, 1, 1, 2};
        int[] result = solution(R, V);
        System.out.println(Arrays.toString(result)); // Output: [2, 4]
    }

}
