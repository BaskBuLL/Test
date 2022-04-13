package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/10 3:12 下午
 */
public class 旋转矩阵 {

    public void rotate(int[][] matrix) {
        //matrix[x][y] = matrix[y][n-x-1] 顺时针90度
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    public void rotate2(int[][] matrix) {
        //水平翻转 matrix[row][col] -> matrix[n-row-1][col]
        //对角线翻转 matrix[row][col] -> matrix[col][row]
        //时间复杂度O(n2)
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
