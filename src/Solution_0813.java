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

    public boolean isSubSequence(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 > len2) {
            return false;
        }
        if (len1 == 0) {
            return true;
        }
        int p = 0;
        for (int i = 0; i < len2; ) {
            if (s.charAt(p) == t.charAt(i)) {
                p++;
            }
            i++;
            if (p == len1) {
                return true;
            }
        }
        return false;
    }

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len; ) {
            for (int j = len - 1; j > i; ) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
                if (numbers[i] + numbers[j] > target) {
                    j--;
                }
                if (numbers[i] + numbers[j] < target) {
                    i++;
                }
            }
        }
        return new int[]{1, 2};
    }

    public static void main(String[] args) {
        Solution_0813 solution = new Solution_0813();
//        String s = ".,";
//        boolean result = solution.isPalindrome(s);
//        System.out.println(result);
        String s = "abc", t = "ahbgdc";
        boolean result = solution.isSubSequence(s, t);
        System.out.println(result);
    }
}
