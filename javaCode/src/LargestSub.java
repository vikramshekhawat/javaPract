import java.util.*;

public class LargestSub {

    public static int largestSumSubarray(int[] A) {
        int maxSum = -1;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int current = A[i];
            if (map.containsKey(current)) {
                List<Integer> indices = map.get(current);
                for (int j : indices) {
                    int sum = findSum(A, j, i);
                    maxSum = Math.max(maxSum, sum);
                }
            }
            map.computeIfAbsent(current, k -> new ArrayList<>()).add(i);
        }

        return maxSum;
    }

    private static int findSum(int[] A, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 3, 6, 1, 6, 6, 9, 9};
        int[] A2 = {5, 1, 4, 3};
        int[] A3 = {2, 2, 2, 3, 2, 3};

        System.out.println("Result for A1: " + solution(A1)); // Should return 19
        System.out.println("Result for A2: " + solution(A2)); // Should return -1
        System.out.println("Result for A3: " + solution(A3)); // Should return 11
    }

    static int maxValue(int[] a, int n)
    {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {

            // Build prefix sum array
            if (i != 0)
                prefix[i] = prefix[i - 1] + a[i];
            else
                prefix[i] = a[i];
            // If the value hasn't been encountered before,
            // It is the first occurrence
            if (!first.containsKey(a[i]))
                first.put(a[i], i);

            // Keep updating the last occurrence
            last.put(a[i], i);
        }

        int ans = -1;

        // Find the maximum sum with same first and last
        // value
        for (int i = 0; i < n; i++) {
            int start = first.get(a[i]);
            int end = last.get(a[i]);
            int sum = 0;
            if(start == 0)
                sum = prefix[end];
            else
                sum = prefix[end] - prefix[start - 1];
            if(sum > ans)
                ans = sum;
        }

        return ans;
    }

    public static int solution(int[] A) {
        Map<Integer, int[]> map = new HashMap<>(); // stores [firstOccurrence, lastOccurrence] for each integer

        // Populate the first and last occurrences of each integer
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], new int[]{i, i});
            } else {
                map.get(A[i])[1] = i;
            }
        }

        int maxSum = -1;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] indices = entry.getValue();
            if (indices[0] != indices[1]) { // If first and last occurrence is different
                int sum = 0;
                for (int i = indices[0]; i <= indices[1]; i++) {
                    sum += A[i];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
