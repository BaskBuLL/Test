package top.baskbull.leet.common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author baskbull
 * @date 2021/9/14 20:22
 */
public class ProviderConsumer<T> {

    private int length;

    private Queue<T> queue;

    private ReentrantLock lock = new ReentrantLock();

    private Condition provideCondition = lock.newCondition();

    private Condition consumeCondition = lock.newCondition();

    public ProviderConsumer(int length) {
        this.length = length;
        this.queue = new LinkedList<>();
    }

    public void provide(T product) {
        //因为上锁，所以只能有一个进来
        lock.lock();
        try {
            while (queue.size() >= length) {
                //如果满了 等待
                provideCondition.await();
            }
            queue.add(product);
            consumeCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T consume() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                consumeCondition.await();
            }
            T product = queue.remove();
            provideCondition.signal();
            return product;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }


}
