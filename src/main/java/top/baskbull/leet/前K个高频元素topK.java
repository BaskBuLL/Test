package top.baskbull.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author liuzhuo
 * @date 2022/4/5 7:38 下午
 */
public class 前K个高频元素topK {

    /**
     * 堆实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素 top10 做一个小根堆 门槛在顶部
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }

        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey(), value = entry.getValue();
            values.add(new int[]{num, value});
        }
        int[] ret = new int[k];
        qSort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qSort(List<int[]> values, int start, int end, int[] result, int resultIndex, int k) {
        int base = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, start, base);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            //比pivot小的放左边，大的放右边
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        //把pivot放到应该在的位置
        Collections.swap(values, start, index);

        // 当pivot包含的多余k个时，虽然此时左边都比pivot的大，左区间仍是乱序的，对于k而言相当于没排序
        if (index - start >= k) {
            qSort(values, start, index - 1, result, resultIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                result[resultIndex] = values.get(i)[0];
                resultIndex++;
            }
            if (index - start + 1 < k) {
                qSort(values, index + 1, end, result, resultIndex, k - (index - start + 1));
            }
        }
    }
}
