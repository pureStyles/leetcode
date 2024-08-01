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

    public int hIndex(int[] citations) {
        int len = citations.length;
        for (int i = len; i > 0; i--) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                if (i == len && citations[j] < i) {
                    break;
                }
                if (citations[j] >= i) {
                    sum++;
                }
            }
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution_0801 solution = new Solution_0801();
        int[] nums = new int[]{1, 3, 1};
        int hIndex = solution.hIndex(nums);
        System.out.println(hIndex);
    }
}
