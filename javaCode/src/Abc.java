public class Abc {
    public static void main(String[] args) {
        String S = "><><";
        int count = countPlayersCanMove(S);
        System.out.println("player can move: " + count);
    }

    public static int countPlayersCanMove(String moves) {
        int count = 0;
        int n = moves.length();

        for (int i = 0; i < n; i++) {
            char move = moves.charAt(i);


            if (move == '^' && (i == 0 || moves.charAt(i - 1) != 'v')) {
                count++;
            }

            if (move == 'v' && (i == n - 1 || moves.charAt(i + 1) != '^')) {
                count++;
            }
            if (move == '>' && (i == n - 1 || moves.charAt(i + 1) != '<')) {
                count++;
            }
            if (move == '<' && (i == n - 1 || moves.charAt(i + 1) != '>')) {
                count++;
            }

        }

        return count;
    }
}
