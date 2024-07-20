public class Solution_20240720 {
    public int maxPoint(int[] prices){
        int maxMoney = 0;
        int slow = 0, fast = 1;
        int priceLen = prices.length;
        while(fast < priceLen){
            int money = prices[fast] - prices[slow];
            if(money > maxMoney){
                maxMoney = money;
            }
            if(money < 0){
                /**
                 * 表明在后面有更小的，那么需要看如果以这个更低的价格买入的话，后面的利润是不是比现在的更大；
                 */
                slow = fast;
            }
            fast ++;
        }
        return maxMoney;
    }
}
