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
       solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}