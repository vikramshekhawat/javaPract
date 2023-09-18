public class Smallest {

    public static int findSmallestNumberWithDigitSum(int N) {
        if (N == 0) {
            return 0;
        }

        // Handle special case where N is 1-9, as these are the smallest digits themselves.
        if (N >= 1 && N <= 9) {
            return N;
        }

        // Initialize the result as an empty string.
        StringBuilder result = new StringBuilder();

        // Start with digit 9 and subtract from N until N becomes 0.
        while (N > 0) {
            if (N >= 9) {
                result.append("9");
                N -= 9;
            } else {
                result.append(N);
                N = 0;
            }
        }

        // Convert the result string to an integer.
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        int N = 16;
        int smallestNumber = findSmallestNumberWithDigitSum(N);
        System.out.println("Smallest number with digit sum " + N + ": " + smallestNumber);
    }
}
