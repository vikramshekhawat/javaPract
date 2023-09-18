import java.util.LinkedList;
import java.util.List;
/*
There are two-letter strings, "AA", "AB" and BE, which appear AA, AB and BB times respectively. The task is to join some of these strings to create the longest possible string which does not contain "AAA" or "BBB*.
*/
class LongestStringAAAorBBB {
    private String ans;
    private List<Character> st;
    LongestStringAAAorBBB() {
        ans = "";
        st = new LinkedList<>();
    }

    void recur(int aa, int ab, int bb) {
        if (ans.length() < st.size()) {
            StringBuilder sb = new StringBuilder();
            for (Character c: st) {
                sb.append(c);
            }
            ans = sb.toString();
        }
        if (aa + ab + bb == 0) {
        } else {
            if (st.size() == 0) {
                if (aa > 0) {
                    st.add('A');
                    st.add('A');
                    recur(aa - 1, ab, bb);
                    st.remove(st.size() - 1);
                    st.remove(st.size() - 1);
                }
                if (ab > 0) {
                    st.add('A');
                    st.add('B');
                    recur(aa , ab - 1, bb);
                    st.remove(st.size() - 1);
                    st.remove(st.size() - 1);
                }
                if (bb > 0) {
                    st.add('B');
                    st.add('B');
                    recur(aa, ab, bb - 1);
                    st.remove(st.size() - 1);
                    st.remove(st.size() - 1);
                }
            } else {
                if (aa > 0 && st.get(st.size() - 1) != 'A') {
                    st.add('A');
                    st.add('A');
                    recur(aa - 1, ab, bb);
                    st.remove(st.size() - 1);
                    st.remove(st.size() - 1);
                }
                if (bb > 0 && st.get(st.size() - 1) != 'B') {
                    st.add('B');
                    st.add('B');
                    recur(aa, ab, bb - 1);
                    st.remove(st.size() - 1);
                    st.remove(st.size() - 1);
                }
                if (ab > 0 && (st.get(st.size() - 1) != 'A' || st.get(st.size() - 2) != 'A')) {
                    st.add('A');
                    st.add('B');
                    recur(aa, ab - 1, bb);
                    st.remove(st.size() - 1);
                    st.remove(st.size() - 1);
                }
            }
        }
    }
    public String solution(int AA, int AB, int BB) {
        recur(AA, AB, BB);
        return ans;
    }
}
