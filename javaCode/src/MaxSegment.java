import java.util.ArrayList;
import java.util.List;

public class MaxSegment {
    public static int solution(int[] P, int[] S) {
        int N = P.length;
        int[] freeSeats = new int[N];
        List<Integer> sortedIndices = new ArrayList<>();

        // Calculate the number of free seats for each car and initialize the sortedIndices list.
        for (int i = 0; i < N; i++) {
            freeSeats[i] = S[i] - P[i];
            sortedIndices.add(i);
        }

        // Sort the indices based on the free seats in descending order.
        sortedIndices.sort((i, j) -> Integer.compare(freeSeats[j], freeSeats[i]));

        int result = N;

        for (int i = 0; i < N; i++) {
            int currentIdx = sortedIndices.get(i);
            if (freeSeats[currentIdx] == 0) {
                continue;
            }

            for (int j = N - 1; j > i; j--) {
                int passengerIdx = sortedIndices.get(j);

                if (P[passengerIdx] == 0) {
                    continue;
                }

                int transfer = Math.min(freeSeats[currentIdx], P[passengerIdx]);
                P[currentIdx] += transfer;
                freeSeats[currentIdx] -= transfer;
                P[passengerIdx] -= transfer;

                if (P[passengerIdx] == 0) {
                    result--;
                }
                if (freeSeats[currentIdx] == 0) {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] P = {1, 4, 1};
       int[] S = {1, 5, 1};
        System.out.println(solution(P,S));  // Output: 2

        int[] P1 = {4, 4, 2, 4};
        int[] S1 = {15, 5, 2, 5};
        System.out.println(solution(P1,S1));  // Output: 3

        int[] P2 = {12, 3, 4, 2};
        int[] S2 = {2, 5, 7, 2};
        System.out.println(solution(P2,S2));  // Output: 2


    }
}
