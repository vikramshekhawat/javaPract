import java.util.HashMap;
import java.util.Map;

public class Virende {
    public static int minMovesToBalanceArray(int[] A) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count the occurrences of each unique value in the array
        for (int num : A) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int moves = 0;

        for (int num : countMap.keySet()) {
            int count = countMap.get(num);
            moves += Math.abs(count - num); // Calculate the absolute difference
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 1, 3, 4, 4, 4};
        System.out.println(minMovesToBalanceArray(A1)); // Output: 3

        int[] A2 = {1, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(minMovesToBalanceArray(A2)); // Output: 4

        int[] A3 = {1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4};
        System.out.println(minMovesToBalanceArray(A3)); // Output: 5

        int[] A4 = {10, 10, 10};
        System.out.println(minMovesToBalanceArray(A4)); // Output: 3
    }
}
