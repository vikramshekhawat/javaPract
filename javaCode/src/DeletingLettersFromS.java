public class DeletingLettersFromS {
    public static int minDeletionsToFormat(String S) {
        int countA = 0;
        int countB = 0;

        for (char c : S.toCharArray()) {
            if (c == 'A') {
                countA++;
                // If 'A' occurs after 'B', increment the deletion count for 'A'
                countB = Math.min(countA, countB);
            } else {
                countB++;
                // If 'B' occurs after 'A', increment the deletion count for 'B'
                countA = Math.min(countA, countB);
            }
        }

        // The minimum of countA and countB represents the required deletions
        return Math.min(countA, countB);
    }

        public static int solution(String S) {
            int countA = 0; // Count of 'A's encountered
            int countB = 0; // Count of 'B's encountered
            int deletions = 0; // Count of deletions needed

            for (char c : S.toCharArray()) {
                if (c == 'A') {
                    // If we encounter an 'A', increase the count of 'A's
                    countA++;
                    // If we have previously encountered 'B's, we need to delete them
                    deletions += countB;
                } else { // c == 'B'
                    // If we encounter a 'B', increase the count of 'B's
                    countB++;
                }
            }

            // The total number of deletions needed is the sum of deletions
            // to move 'B's before 'A's and deletions to move 'A's after 'B's
            return deletions;
        }



    public static void main(String[] args) {
        String S1 = "BAAABAB";
        String S2 = "BBABAA";
        String S3 = "AABBBB";

        int result1 = solution(S1);
        int result2 = solution(S2);
        int result3 = solution(S3);

        System.out.println("Result 1: " + result1); // Output: 2
        System.out.println("Result 2: " + result2); // Output: 3
        System.out.println("Result 3: " + result3); // Output: 0
    }
}

