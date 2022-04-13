package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/9 8:49 下午
 */
public class 递归乘法 {

    public int multiply(int A, int B) {
        //10*4 = 10 + 10 + 10 + 10
        if (A == 0 || B == 0) {
            return 0;
        }
        if (A < B) {
            return B + multiply(A - 1, B);
        }
        return A + multiply(A, B - 1);
    }

    public int multiply2(int A, int B) {
        //B为偶数 A*B = A*B/2 + A*B/2
        //B为奇数 A*B = A*B/2 + A*B/2 + A
        if (B == 0) {
            return 0;
        }
        if (B == 1) {
            return A;
        }
        return (multiply2(A, B >> 1) << 1) + ((B & 1) == 0 ? 0 : A);
    }
}
