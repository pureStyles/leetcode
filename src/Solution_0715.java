public class Solution_0715 {
    public int majorityElement(int[] nums){
        if(nums == null || nums.length == 0){
            return Integer.MAX_VALUE;
        }
        int winner = nums[0];
        int count = 1;
        int len = nums.length;
        for(int  i = 1; i < len; i++){
            if(nums[i] == winner) {
                count++;
            } else if (count == 0) {
                winner = nums[i];
                count = 1;
            } else {
                count --;
            }
        }
        return winner;
    }
}
