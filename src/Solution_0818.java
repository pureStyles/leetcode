import java.util.HashSet;

public class Solution_0818 {
    public int lengthOfLongestSubString1(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int start = 0, end = 0, res = 0;
        while (end < len) {
            end++;
            while (end < len && s.charAt(end) == s.charAt(start)) {
                res = Math.max(end - start, res);
                start++;
                end = start;
            }
            if (res == len) {
                return res;
            }
        }
        return res;
    }

    public int lengthOfLongestSubString(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        HashSet<Character> set = new HashSet<>();
        int start = 0, end = 0, res = 0;
        while (end < len) {
            while (end < len && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                res = Math.max(res, end - start);
            }
            set.remove(s.charAt(start));
            start++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_0818 solution = new Solution_0818();
        String s = "pwwkew";
        int result = solution.lengthOfLongestSubString(s);
        System.out.println(result);
    }
}
