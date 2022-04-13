package top.baskbull.proxy;

/**
 * @author liuzhuo
 * @date 2022/3/29 1:53 下午
 */
public class SubjectImpl implements Subject {

    @Override
    public String sayHello() {
        System.out.println("hello");
        return "success";
    }
}
