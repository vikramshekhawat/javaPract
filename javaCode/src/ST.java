import java.util.LinkedList;

public class ST {

    public static int minRelocations(int[] A) {
        int n = A.length;
        int minRelocations = 0;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += A[i];

            // If the current sum becomes negative, we relocate the negative elements to the end.
            if (currentSum < 0) {
                minRelocations++;
                currentSum = 0;
            }
        }

        return minRelocations;
    }
    public static int minRelocations2(int[] A) {
        int n = A.length;
        int minRelocations = 0;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += A[i];

            // If the current sum becomes negative, we relocate the negative elements to the end.
            if (currentSum < 0) {
                minRelocations++;
                currentSum = 0;
            }
        }

        return minRelocations;
    }

    public static int minRelocations1(int[] A) {
        int n = A.length;
        int minRelocations = 0;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += A[i];

            // If the current sum becomes negative, we relocate the negative elements to the end.
            if (currentSum < 0) {
                minRelocations += Math.abs(currentSum); // Number of relocations needed is the absolute value of currentSum
                currentSum = 0;
            }
        }

        return minRelocations;
    }
    public static int solution(int[] A) {
        int current_sum = 0;
        int relocations = 0;

        for (int value : A) {
            current_sum += value;

            if (current_sum < 0) {
                relocations++;
                current_sum = 0; // reset current sum as we're moving the negative number causing the drop
            }
        }

        return relocations;
    }
    public static int minRelocations4(int[] A) {
        int n = A.length;
        int minRelocations = 0;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += A[i];

            // If the current sum becomes negative, we relocate the negative elements to the end.
            if (currentSum < 0) {
                minRelocations++;
                currentSum = 0;
            }
        }

        return minRelocations;
    }

    public static int solution1(int[] A) {
        int relocations = 0;
        int balance = 0;

        for (int i = 0; i < A.length; i++) {
            balance += A[i];
            if (balance < 0) {
                relocations++;
                // Move the current expense to the end of the array.
                int temp = A[i];
                A[i] = A[A.length - 1];
                A[A.length - 1] = temp;
                balance += temp;
            }
        }

        return relocations;
    }

    public static int findMinimumRelocations(int[] A) {
        int relocations = 0;
        int balance = 0;

        for (int i = 0; i < A.length; i++) {
            balance += A[i];
            if (balance < 0) {
                relocations++;
                balance = 0;
            }
        }

        return relocations;
    }
    public static int solution5(int[] A) {
        long cumSum = 0;
        int relocations = 0;
        LinkedList<Integer> negativeQueue = new LinkedList<>();

        for (int value : B) {
            cumSum += value;

            if (value < 1) {
                negativeQueue.add(value);
            }

            while (cumSum < 1 && !negativeQueue.isEmpty()) {
                cumSum -= negativeQueue.poll();
                relocations++;
            }
        }

        return relocations;
    }
    public static void main(String[] args) {
        int[] A1 = {10, -10, -1, -1, 10};
        int[] A2 = {-1, -1, -1, 1, 1, 1, 1};
        int[] A3 = {5, -2, -3, 1};

        System.out.println(solution5(A1)); // Output: 1
        System.out.println(minRelocations(A2)); // Output: 3
        System.out.println(minRelocations(A3)); // Output: 0
    }
}
