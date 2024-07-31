public class Solution_0801 {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        if (len2 > len1) {
            return -1;
        }
        for (int i = 0; i < len1; i++) {
            int j = 0;
            while (j < len2) {
                if ((i + j < len1) && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            if (j == len2) {
                return i;
            }
        }
        return -1;
    }
}
