package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/5 7:12 下午
 */
public class 将字符串转换为整数 {

    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int res = 0;
        int bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            i = 0;
        }
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9') {
                break;
            }
            if (res > bndry || (res == bndry && chars[j] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //原来的值*10
            res = res * 10 + (chars[j] - '0');
        }
        return sign * res;
    }
}
