package top.baskbull;

import com.youzan.platform.service_chain.concurrent.FrameworkThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzhuo
 * @date 2021/11/23 1:16 上午
 */
public class ThreadPoolConfig {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAXIMUM_POOL_SIZE = 10;
    private static final int WORK_QUEUE_CAPACITY = 100;

    public static final ThreadPoolExecutor SQL_CACHE_POOL =
            new FrameworkThreadPoolExecutor(
                    CORE_POOL_SIZE,
                    MAXIMUM_POOL_SIZE,
                    5,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(WORK_QUEUE_CAPACITY)
            );

    private ThreadPoolConfig() {
        throw new UnsupportedOperationException("不允许实例化");
    }
}
