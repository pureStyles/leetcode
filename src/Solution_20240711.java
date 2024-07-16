public class Solution_20240711 {
    public int removeDuplicates(int [] nums){
        int slow = 2, fast = 2;
        while(fast < nums.length){
            if(nums[slow-1] != nums[fast]){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        return slow;
    }
}
