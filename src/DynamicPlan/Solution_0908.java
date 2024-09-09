package DynamicPlan;

import java.util.Arrays;

public class Solution_0908 {
    int res = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
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

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0, len = coins.length; j < len; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
