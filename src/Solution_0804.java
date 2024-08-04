public class Solution_0804 {
    public int minCandyNum(int[] ratings) {
        int len = ratings.length;
        int sum = 0;
        int[] L = new int[len], R = new int[len];

        for (int i = 0; i < len; i++) {
            L[i] = 1;
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                L[i] = L[i - 1] + 1;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            R[i] = 1;
            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
                R[i] = R[i + 1] + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            R[i] = Math.max(L[i], R[i]);
            sum += R[i];
        }
        return sum;
    }
}
