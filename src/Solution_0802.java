import java.util.HashMap;
import java.util.Random;

public class Solution_0802 {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    Random random = new Random();
    int idx = -1;
    static int[] nums = new int[200010];

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            // 不存在;
            return false;
        }
        int loc = map.remove(val);
        if (loc != idx) {
            map.put(nums[idx], loc);
        }
        nums[loc] = nums[idx--];
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len], R = new int[len], answer = new int[len];
        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            answer[i] = R[i] * L[i];
        }
        return answer;
    }
}
