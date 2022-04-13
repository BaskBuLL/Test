package top.baskbull.proxy;

import java.lang.reflect.Proxy;

/**
 * @author liuzhuo
 * @date 2022/3/29 1:55 下午
 */
public class ProxyTest {

    public static void main(String[] args) {
//        Subject subject = new SubjectImpl();
//        Subject proxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
//                subject.getClass().getInterfaces(),
//                new ProxyInvocationHandler(subject));
//        proxy.sayHello();
        Subject subject = (Subject) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{Subject.class},
                new ProxyInvocationHandler());
        String s = subject.sayHello();
        System.out.println();
    }
}
