public class Solution_0808 {
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int len = strs.length;
        for (int i = 1; i < len; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public String longestCommonPrefix(String[] strs) {
        // 随便选取一个长度
        int len = strs[0].length();
        int count = strs.length;
        String c = strs[0];
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c.charAt(i)) {
                    return c.substring(0, i);
                }
            }
        }
        return c;
    }

    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        boolean isStart = false;
        for (int i = len - 1; i >= 0; i--) {
            if (isStart) {
                sb.append(s.charAt(i));
            }
            if (i > 0 && s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                isStart = true;
            }
            if (i > 0 && s.charAt(i) != ' ' && s.charAt(i - 1) == ' ') {
                isStart = false;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_0808 solution = new Solution_0808();
        String s = "the sky is blue";
        String res = solution.reverseWords(s);
        System.out.println(res);

    }
}
