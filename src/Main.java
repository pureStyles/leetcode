class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = nums1.length, len2 = nums2.length;
        for(int i = len1 > len2 ? len1 - len2 : len2-len1, j = 0; i < m + n; i++, j++){
            nums1[i] = nums2[j];
        }
        for(int k = 0; k < m + n; k++){
            int min = nums1[k], pos = k;
            for(int j = k + 1; j < m + n; j ++){
                if(min > nums1[j]){
                    min = nums1[j];
                    pos = j;
                }
            }
            if(k != pos){
                nums1[pos] = nums1[k];
                nums1[k] = min;
            }
        }
        for(int i = 0; i < m + n; i++){
            System.out.println(nums1[i]);
        }
    }
    public static void main(String[] args){
       Solution solution = new Solution();
       solution.mergeOptimize(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    /** 寻找更优的解法 */
    public void mergeOptimize(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n-1;
        while(p1 >= 0 && p2 >= 0){
            if(nums2[p2] >= nums1[p1]){
                // 把大的排在最后面
                nums1[p1 + p2 + 1] = nums2[p2];
                p2--;
            } else {
                nums1[p1 + p2 + 1] = nums1[p1];
                p1--;
            }
        }
        if(p2 >= 0){
            // nums1的长度小于nums2的长度,这个时候nums1已经排完，直接把剩余的nums2移过来即可
            for(int i = 0; i <= p2; i++){
                nums1[i] = nums2[i];
            }
        }
        for(int i = 0; i < m + n; i++){
            System.out.println(nums1[i]);
        }
    }
}