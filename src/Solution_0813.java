import java.util.Calendar;

public class Solution_0813 {
    public boolean isPalindrome(String s) {
        s = s.trim();
        if (s.length() <= 1) {
            return true;
        }
        int len = s.length();
        int p = 0, q = len - 1;
        while (p <= q) {
            while (p < q && !Character.isLetterOrDigit(s.charAt(p))) {
                p++;
            }
            while (p < q && !Character.isLetterOrDigit(s.charAt(q))) {
                q--;
            }
            if (Character.toLowerCase(s.charAt(p)) != Character.toLowerCase(s.charAt(q))) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_0813 solution = new Solution_0813();
        String s = ".,";
        boolean result = solution.isPalindrome(s);
        System.out.println(result);
    }
}
