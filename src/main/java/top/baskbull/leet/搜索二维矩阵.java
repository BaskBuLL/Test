package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/11 10:38 下午
 */
public class 搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 每行中的整数从左到右按升序排列。
         * 每行的第一个整数大于前一行的最后一个整数。
         *
         * 若将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，我们可以在该数组上二分找到目标元素。
         * 代码实现时，可以二分升序数组的下标，将其映射到原矩阵的行和列上。
         */
        int m = matrix.length, n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        /**
         * 每行的元素从左到右升序排列。
         * 每列的元素从上到下升序排列。
         *
         * z字形查找
         */
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }


}
