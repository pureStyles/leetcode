package DynamicPlan;

public class Solution_0909 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s){
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < len; i ++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(s.charAt(i) != s.charAt(j)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
