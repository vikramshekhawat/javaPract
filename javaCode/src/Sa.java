import java.util.HashMap;

public class Sa {
    public static int solution(String S) {
        int[] prefix = new int[S.length() + 1];
        int xor = 0;

        // hashmap to store the first occurrence of each xor
        int[] firstOccurrence = new int[1 << 26];
        for (int i = 0; i < firstOccurrence.length; i++) {
            firstOccurrence[i] = -1;
        }

        int maxLength = 0;

        for (int i = 0; i < S.length(); i++) {
            xor ^= (1 << (S.charAt(i) - 'a'));
            if (xor == 0) {
                maxLength = i + 1;
            } else if (firstOccurrence[xor] != -1) {
                maxLength = Math.max(maxLength, i - firstOccurrence[xor]);
            } else {
                firstOccurrence[xor] = i;
            }
        }
        return maxLength;
    }

    public static int longestEvenFrequencySubstring(String S) {
        int n = S.length();
        int maxLen = 0;
        HashMap<String, Integer> frequencyMap = new HashMap<>();


        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = S.substring(i, j+1);
                frequencyMap.clear();
                boolean isValid = true;

                for (char c : substring.toCharArray()) {
                    frequencyMap.put(String.valueOf(c), frequencyMap.getOrDefault(String.valueOf(c), 0) + 1);
                }

                for (int value : frequencyMap.values()) {
                    if (value % 2 != 0) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(longestEvenFrequencySubstring("bdaaadadb")); // Output: 6
        System.out.println(longestEvenFrequencySubstring("abacb")); // Output: 0
        System.out.println(longestEvenFrequencySubstring("zthtzh")); // Output: 6
    }
}
