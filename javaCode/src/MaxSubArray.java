import java.util.HashMap;

/*
You are given an array A consisting of N positive integers. Consider subarrays of A,
with at least two elements, whose first and last elements have the same value.
Your task is to find the largest possible sum of such a subarray.
*/
public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3};
        int result = maxSumSubarray1(arr);
        System.out.println(result); // Output: 19
    }

    public static int maxSumSubarray(int[] arr) {
        int n = arr.length;
        int maxSum = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    int subarraySum = 0;
                    for (int k = i; k <= j; k++) {
                        subarraySum += arr[k];
                    }
                    maxSum = Math.max(maxSum, subarraySum);
                }
            }
        }

        return maxSum;
    }
    public static int maxSumSubarray1(int[] arr) {
        int n = arr.length;
        int maxSum = -1;
        HashMap<Integer, Integer> lastIndexMap = new HashMap<>();
        int[] prefixSum = new int[n];

        for (int i = 0; i < n; i++) {
            if (lastIndexMap.containsKey(arr[i])) {
                int lastIndex = lastIndexMap.get(arr[i]);
                int subarraySum = (lastIndex == 0) ? prefixSum[i] : prefixSum[i] - prefixSum[lastIndex - 1];
                maxSum = Math.max(maxSum, subarraySum);
            }

            if (i == 0) {
                prefixSum[i] = arr[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }

            lastIndexMap.put(arr[i], i);
        }

        return maxSum;
    }

}
