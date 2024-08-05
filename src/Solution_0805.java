public class Solution_0805 {
    public int trap1(int[] height) {
        int sum = 0;
        int len = height.length;
        int max = max(height);
        for (int i = 1; i <= max; i++) {
            boolean start = false;
            int temp = 0;
            for (int j = 0; j < len; j++) {
                if (start && height[j] < i) {
                    temp++;
                }
                if (height[j] >= i) {
                    start = true;
                    sum += temp;
                    temp = 0;
                }
            }
        }
        return sum;
    }

    public int max(int[] height) {
        int max = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    public int trap2(int[] height) {
        int sum = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            /**
             * 找出左侧最高的柱子
             */
            int maxLeft = 0;
            for (int j = 0; j < i; j++) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            /**
             * 找出右侧最高的柱子
             */
            int maxRight = 0;
            for (int j = i + 1; j < len; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            /**
             * 找出两侧较低的那一个柱子
             */
            int less = Math.min(maxLeft, maxRight);
            if (height[i] < less) {
                sum += (less - height[i]);
            }
        }
        return sum;
    }

    public int trap(int[] height) {
        int sum = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            /**
             * 找出i左侧最大并记录在数组里
             * 可以省去许多的重复计算
             * 策略：空间换时间
             */
            int maxLeft = maxLeft2Index(height, i);
            int maxRight = maxRight2Index(height, i);
            int less = Math.min(maxLeft, maxRight);
            if (height[i] < less) {
                sum += (less - height[i]);
            }
        }
        return sum;
    }

    public int maxLeft2Index(int[] height, int index) {
        int[] dp = new int[index + 1];
        dp[0] = -1;
        for (int i = 1; i < index; i++) {
            dp[i] = Math.max(dp[i - 1], height[i - 1]);
        }
        return dp[index];
    }

    public int maxRight2Index(int[] height, int index) {
        int len = height.length;
        int[] dp = new int[len];
        dp[len - 1] = -1;
        for (int i = len - 2; i >= index; i--) {
            dp[i] = Math.max(dp[i + 1], height[i + 1]);
        }
        return dp[index];
    }
}
