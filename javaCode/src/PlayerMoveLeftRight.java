
class PlayerMoveLeftRight {
    public static int solution(String S) {
        int sm = 0;
        int N = S.length();

        for (int i = 0; i < N; i++) {
            char move = S.charAt(i);

            switch (move) {
                case '>':
                    if (i == N - 1) {
                        sm++;
                    }
                    break;
                case '<':
                    if (i == 0 || S.charAt(i - 1) == '^' || S.charAt(i - 1) == 'v' || S.charAt(i - 1) == '<') {
                        sm++;
                    }
                    break;
                case '^':
                    sm++;
                    break;
                case 'v':
                    sm++;
                    break;
            }
        }

        return sm;
    }

    public static void main(String[] args) {
       String S =  "><><";
        System.out.println(solution(S));
    }
}


