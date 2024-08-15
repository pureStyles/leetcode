public class Solution_0815 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target && (j - i + 1) < res) {
                    res = j - i + 1;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Solution_0815 solution = new Solution_0815();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        int res = solution.minSubArrayLen(target, nums);
        System.out.print(res);
    }
}
