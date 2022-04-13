package top.baskbull;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhuo
 * @date 2021/12/26 2:54 下午
 */
public class TestCache {

    private static Cache<Long, String> rollbackVersionCache = CacheBuilder.newBuilder().maximumSize(10000).build();


    public static void main(String[] args) {
//        rollbackVersionCache.put(123L,"test");
//        rollbackVersionCache.put(123L,"test22");
//        String ifPresent = rollbackVersionCache.getIfPresent(123L);
//        System.out.println(ifPresent);
//        rollbackVersionCache.invalidate(123L);
//        String s = rollbackVersionCache.getIfPresent(123L);
//        System.out.println(s);

        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        test.add("c");
        String data = JSON.toJSONString(test);
        System.out.println(data);
        System.out.println(JSON.parseArray(data, String.class));
    }
}
