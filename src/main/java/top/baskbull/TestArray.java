package top.baskbull;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/2/14 4:46 下午
 */
public class TestArray {

    public static void main(String[] args) {
        String[] array = new String[]{"1", "2", "3", "4", "o5"};

        String[] strings = Arrays.copyOfRange(array, 0, 5);
        System.out.println(Arrays.toString(strings));
    }
}
