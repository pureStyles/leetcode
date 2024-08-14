public class Solution_0814 {
    public int maxArea1(int[] height) {
        int len = height.length;
        int volume = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (height[len - 1] >= height[i]) {
                    int temp = (len - i - 1) * height[i];
                    if (temp > volume) {
                        volume = temp;
                    }
                    break;
                }
                int curVolume = (j - i) * Math.min(height[i], height[j]);
                if (curVolume > volume) {
                    volume = curVolume;
                }
            }
        }
        return volume;
    }

    public int maxArea(int[] height) {
        int len = height.length;
        int p = 0, q = len - 1;
        int volume = 0;
        while (p < len && q > p) {
            int curVolume = (q - p) * Math.min(height[p], height[q]);
            if (curVolume > volume) {
                volume = curVolume;
            }
            if (height[p] <= height[q]) {
                p++;
            } else {
                q--;
            }
        }
        return volume;
    }

    public static void main(String[] args) {
        Solution_0814 solution = new Solution_0814();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int volume = solution.maxArea(height);
        System.out.print(volume);
    }
}
