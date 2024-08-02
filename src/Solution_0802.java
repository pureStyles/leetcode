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
}
