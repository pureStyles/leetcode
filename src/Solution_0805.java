public class Solution_0805 {
    public int trap(int[] height) {
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
}
