package top.baskbull.leet.数组;

/**
 * @author liuzhuo
 * @date 2022/4/5 9:10 下午
 */
public class 数组重复至少K次且长度为M的模式 {

    public boolean containsPattern(int[] arr, int m, int k) {
        //连续出现 kk 次且长度为 mm 的子数组
        int n = arr.length;
        if (m * k > n) {
            return false;
        }
        int tmp = m;
        for (int i = m; i < arr.length; i++) {
            if (arr[i] == arr[i - m]) {
                tmp++;
            } else {
                tmp = m;
            }

            if (tmp / m == k) {
                return true;
            }
        }
        return false;

//        int n = arr.length;
//        for (int l = 0; l <= n - m * k; ++l) {
//            int offset;
//            for (offset = 0; offset < m * k; ++offset) {
//                if (arr[l + offset] != arr[l + offset % m]) {
//                    break;
//                }
//            }
//            if (offset == m * k) {
//                return true;
//            }
//        }
//        return false;
    }
}
