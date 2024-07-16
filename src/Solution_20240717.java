public class Solution_20240717 {
    public void rotate(int[] nums, int k){
        int len = nums.length;
        int[] tempArr = new int[len];
        for(int i = 0; i < len; i++){
            tempArr[(i + k) % len] = nums[i];
        }
        for(int i = 0; i < len; i++){
            nums[i] = tempArr[i];
        }
    }
}
