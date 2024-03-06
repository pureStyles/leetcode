public class Solution_20240305 {
    public int removeElement(int[] nums, int val){
        int left = 0;
        for(int right = 0; right < nums.length; right ++){
            if(nums[right] != val){
                if(left != right){
                    nums[left] = nums[right];
                }
                left ++;
            }
        }
        return left;
    }
    public int removeElementOptimize(int[] nums, int val){
        int right = nums.length, left = 0;
        while(left < right){
            if(nums[left] != val){
                left ++;
            } else {
                nums[left] = nums[right - 1];
                right --;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int[] nums = { 0, 1, 2, 2, 3, 0, 4 };
        Solution_20240305 solution20240305 = new Solution_20240305();
//        int len = solution20240305.removeElement(nums, 2);
        int len = solution20240305.removeElementOptimize(nums, 2);
        for(int i = 0; i < len; i++){
            System.out.println(nums[i]);
        }
    }
}
