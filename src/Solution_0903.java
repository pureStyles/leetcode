public class Solution_0903 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // nums[mid] > target
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 第一次二分查找先找到在哪一行
         */
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        /**
         * 第二次二分查找对此行进行二分查找
         */
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                //matrix[mid][0] > target
                right = mid - 1;
            }
        }
        // left是插入的位置，所在行索引应该-1
        return left - 1;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                // row[mid] > target
                right = mid - 1;
            }
        }
        return false;
    }
}
