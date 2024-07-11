public class Solution20240310 {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 1;
        while(right < nums.length){
            if(nums[right] != nums[left]){
                // 没有重复
                nums[left + 1] = nums[right];
                left ++;
                right ++;
            } else {
                // 两项重复
                right ++;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {

        Solution20240310 solution20240310 =  new Solution20240310();
        int[] nums = new int[]{0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = solution20240310.removeDuplicates(nums);
        for(int i = 0; i < len; i++){
            System.out.println(nums[i]);
        }
    }
}
