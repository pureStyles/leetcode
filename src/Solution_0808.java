public class Solution_0808 {
    public String longestCommonPrefix(String[] strs) {
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

    public static void main(String[] args) {
        Solution_0808 solution = new Solution_0808();
        String[] strs = {"flower", "flow", "flight"};
        String prefix = solution.longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
