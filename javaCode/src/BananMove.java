public class BananMove {
    public static int maxBananaMoves(String S) {
        // Initialize counts for each letter in "BANANA"
        int countB = 0, countA = 0, countN = 0;

        // Count the occurrences of each letter in the input string
        for (char c : S.toCharArray()) {
            if (c == 'B') countB++;
            else if (c == 'A') countA++;
            else if (c == 'N') countN++;
        }

        // Calculate the maximum number of moves possible
        int maxMoves = Math.min(countB, Math.min(countA / 3, countN / 2));

        return maxMoves;
    }

    public static void main(String[] args) {
        // Test cases
        String S1 = "NAABXXAN";
        String S2 = "NAANAAXNABABYNNBZ";
        String S3 = "QABAAAWOBL";

        int result1 = maxBananaMoves(S1);
        int result2 = maxBananaMoves(S2);
        int result3 = maxBananaMoves(S3);

        System.out.println("Maximum moves for S1: " + result1); // Should print 1
        System.out.println("Maximum moves for S2: " + result2); // Should print 2
        System.out.println("Maximum moves for S3: " + result3); // Should print 0
    }
}
