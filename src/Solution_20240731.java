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

    public int lengthOfLastWord(String s) {
        int lastIndex = s.length() - 1;
        if (lastIndex == 0) {
            return 1;
        }
        int result = 0;
        for (int i = lastIndex; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                // 是空格字符串
                result++;
                if ((i - 1 >= 0) && s.charAt(i - 1) == ' ') {
                    break;
                }
            }
        }
        return result;
    }
}
