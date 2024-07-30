public class Solution_20240731 {
    public int jump(int[] nums){
        int lastPosition = nums.length;
        int steps = 0;
        while(lastPosition > 0){
            for(int i = 0; i < lastPosition; i++){
                if(i + nums[i] >= lastPosition){
                    lastPosition = i;
                    steps ++;
                    break;
                }
            }
        }
        return steps;
    }
}
