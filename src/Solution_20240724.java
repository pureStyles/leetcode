public class Solution_20240724 {
    public boolean canJump(int[] nums){
        // 最远能到达的位置index，从0开始
        int maxPosition = 0;
        for(int i = 0; i <= maxPosition; i++){
            int toPosition = i + nums[i];
            if(toPosition >= nums.length - 1){
                return true;
            }
            if(toPosition > maxPosition){
                // 更新能到达的最远位置
                maxPosition = toPosition;
            }
        }
        return false;
    }
}
