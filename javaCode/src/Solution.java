public class Solution {
    public static String solution(String S) {

        String result = S;
        for (int i = 0; i < S.length(); i++) {
            String current = S.substring(0, i) + S.substring(i + 1);
            if (current.compareTo(result) < 0) {
                result = current;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(solution("acb"));       // Output: "ab"
        System.out.println(solution("hot"));       // Output: "ho"
        System.out.println(solution("aaaa"));      // Output: "aaa"
    }
}
