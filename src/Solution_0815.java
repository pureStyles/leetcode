public class Solution_0815 {
    public int minSubArrayLen1(int target, int[] nums) {
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

    public int minSubArrayLen2(int target, int[] nums) {
        // 使用滑动窗口解决
        int res = Integer.MAX_VALUE;
        int len = nums.length;
        int start = 0, end = 0, sum = 0;
        sum += nums[start];
        while (start <= end && start < len) {
            while (sum < target) {
                end++;
                sum += nums[end >= len ? len - 1 : end];
            }
            if (end - start + 1 < res) {
                res = end - start + 1;
            }
            sum = sum - nums[start];
            start++;

        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int start = 0, end = 0, sum = 0;
        int result = Integer.MAX_VALUE;
        while (end < len) {
            sum += nums[end];
            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        Solution_0815 solution = new Solution_0815();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        int res = solution.minSubArrayLen(target, nums);
        System.out.print(res);
    }
}
