import java.util.ArrayList;
import java.util.List;

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

    public String convert(int rowNums, String s) {
        if (rowNums == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>(rowNums);
        int len = s.length();
        for (int i = 0; i < rowNums; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == rowNums - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution_0812 solution = new Solution_0812();
        String s = "a good   example";
        String result = solution.reverseWords(s);
        System.out.println(result);
    }
}
