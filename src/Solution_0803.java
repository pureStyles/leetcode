public class Solution_0803 {

    // 超时
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            /**
             * 从第i个加油站出发时，邮箱里剩余的油有多少
             */
            int j = i;
            int remain = 0 + gas[j];
            while (remain - cost[j] >= 0) {
                // 能去往下一站
                remain = remain - cost[j] + gas[(j + 1) % len];
                j = (j + 1) % len;
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 超时
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int[] maxInstance = new int[len], maxRemainCost = new int[len];
        for (int i = 0; i < len; i++) {
            maxInstance[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            /**
             * 从第i个加油站出发时，邮箱里剩余的油有多少
             */
            int j = i;
            int remain = 0 + gas[j];
            while (remain - cost[j] >= 0) {
                // 到达下一个加油站时的剩余油量
                remain = remain - cost[j];
                j = (j + 1) % len;
                if (maxInstance[j] != -1) {
                    // 跳跃
                    j = maxInstance[j];
                    // 跳跃后的剩余油量
                    remain = remain + maxRemainCost[j];
                } else {
                    remain = remain + gas[j];
                }
                if (j == i) {
                    return i;
                }
            }
            maxInstance[i] = j;
            maxRemainCost[i] = remain;
        }
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            int remain = 0 + gas[i];
            while (remain - cost[j] >= 0) {
                remain = remain - cost[j] + gas[(j + 1) % len];
                j = (j + 1) % len;
                if (j == i) {
                    /**
                     * 能回到i
                     */
                    return i;
                }
            }
            if (j < i) {
                return -1;
            }
            /**
             * for循环后面还有个i++, 所以是从j+1开始
             */
            i = j;
        }
        return -1;
    }


}
