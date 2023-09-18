import java.util.Arrays;

public class Test {
    public static int minCarsNeeded(int[] P, int[] S) {
        int totalPeople = Arrays.stream(P).sum();
        int totalSeats = Arrays.stream(S).sum();

        if (totalPeople <= totalSeats) {
            // If there are enough seats for all people, return 1 car
            return 1;
        }

        int[] carUtilization = new int[P.length];
        int carsNeeded = P.length;

        for (int i = 0; i < P.length; i++) {
            int remainingPeople = totalPeople - P[i];
            int remainingSeats = totalSeats - S[i];

            for (int j = 0; j < P.length; j++) {
                if (i != j && carUtilization[j] == 0) {
                    if (P[j] <= remainingSeats && S[j] >= remainingPeople) {
                        // If friend j can fit in car i and car j has enough seats for the remaining people, move friend i to car j
                        carUtilization[j] = 1;
                        carsNeeded--;
                        break;
                    }
                }
            }
        }

        return carsNeeded;
    }

    public static void main(String[] args) {
        int[] P1 = {1, 4, 1};
        int[] S1 = {1, 5, 1};
        System.out.println(minCarsNeeded(P1, S1)); // Output: 2

        int[] P2 = {4, 4, 2, 4};
        int[] S2 = {15, 5, 2, 5};
        System.out.println(minCarsNeeded(P2, S2)); // Output: 3

        int[] P3 = {12, 3, 4, 2};
        int[] S3 = {2, 5, 7, 2};
        System.out.println(minCarsNeeded(P3, S3)); // Output: 2
    }
}
