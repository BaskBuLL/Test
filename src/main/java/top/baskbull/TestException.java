package top.baskbull;

/**
 * @author liuzhuo
 * @date 2022/3/23 10:59 上午
 */
public class TestException {

    public static void main(String[] args) {
        int i = 0;
        for (; i < 5; i++) {
            try {
                System.out.println(i + "次");
                throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("error");
            }
        }

    }
}
