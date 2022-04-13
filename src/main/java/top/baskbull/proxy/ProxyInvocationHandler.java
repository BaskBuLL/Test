package top.baskbull.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liuzhuo
 * @date 2022/3/29 1:53 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProxyInvocationHandler implements InvocationHandler {
    private Object object;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理调用 invoke");
//        return method.invoke(object, args);
        return "success";
    }
}
