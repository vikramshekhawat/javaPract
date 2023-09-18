public class MinDeletions {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //String S = "BAAABAB";//2
        //String S = "BBABAA";//3
        String S = "AABBBB";//0

        //int result = minDeletionsToFormat(S);
        //System.out.println("Minimum number of deletions: " + result); // Output: 2
    }
    public int minDeletionsToFormat(String S) {
        int n = S.length();
        int countA = 0;
        int minDeletions = Integer.MAX_VALUE;


        for (char c : S.toCharArray()) {
            if (c == 'A') {
                countA++;
            }
        }

        int countB = 0;

        // Iterate through the string and count 'B's, updating minDeletions
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'B') {
                countB++;
            }

            // Calculate deletions needed for the current split
            int deletionsNeeded = countB + (countA - (i + 1 - countB));

            // Update minDeletions if necessary
            minDeletions = Math.min(minDeletions, deletionsNeeded);
        }

        return minDeletions;
    }




}
