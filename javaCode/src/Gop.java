public class Gop {
    public static int maxRookSum(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        // Find the maximum value in each row and column
        int[] maxRowValues = new int[N];
        int[] maxColValues = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxRowValues[i] = Math.max(maxRowValues[i], A[i][j]);
                maxColValues[j] = Math.max(maxColValues[j], A[i][j]);
            }
        }

        // Find the two maximum values from maxRowValues and maxColValues
        int max1 = 0, max2 = 0;

        for (int value : maxRowValues) {
            if (value > max1) {
                max2 = max1;
                max1 = value;
            } else if (value > max2) {
                max2 = value;
            }
        }

        for (int value : maxColValues) {
            if (value > max1) {
                max2 = max1;
                max1 = value;
            } else if (value > max2) {
                max2 = value;
            }
        }

        // Return the sum of the two maximum values
        return max1 + max2;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 4}, {2, 3}};
        int[][] matrix2 = {{15, 1, 5}, {16, 3, 8}, {2, 6, 4}};
        int[][] matrix3 = {{12, 12}, {12,12}, {0,7}};
        int[][] matrix4 = {{1,2,14}, {8,3,15}};

        System.out.println(maxRookSum(matrix1)); // Output: 6
        System.out.println(maxRookSum(matrix2)); // Output: 23
        System.out.println(maxRookSum(matrix3)); // Output: 24
        System.out.println(maxRookSum(matrix4)); // output: 22
    }
}
