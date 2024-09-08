package DynamicPlan;

public class Solution_0908 {
    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0) {
            return -1;
        }
        findWay(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.max(res, count);
        }
        for (int i = 0, len = coins.length; i < len; i++) {
            findWay(coins, amount - coins[i], count++);
        }
    }
}
