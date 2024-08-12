public class Solution_0812 {
    public String reverseWords(String s) {
        if (s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int len = s.length(), p = len - 1, q;
        while (p >= 0) {
            q = p - 1;
            sb.append(' ');
            while (q >= 0 && s.charAt(q) != ' ') {
                q--;
            }
            sb.append(s.substring(q + 1, p + 1));
            while (q >= 0 && s.charAt(q) == ' ') {
                q--;
            }
            p = q;

        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution_0812 solution = new Solution_0812();
        String s = "a good   example";
        String result = solution.reverseWords(s);
        System.out.println(result);
    }
}
