package top.baskbull.leet;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liuzhuo
 * @date 2022/3/27 3:39 下午
 */
public class LRU缓存 extends LinkedHashMap {

    private int capacity;

    public LRU缓存(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return (int) super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

}
