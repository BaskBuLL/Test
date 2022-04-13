package top.baskbull;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuzhuo
 * @date 2022/3/31 11:10 上午
 */
public class xinyanyuan {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        if (nums.length < 3) {
            return Lists.newArrayList();
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[l], nums[r]);
                    //去重
                    if (!set.contains(temp)) {
                        result.add(temp);
                        set.add(temp);
                    }
                    l++;
                    r--;
                }
                if (sum < 0) {
                    l++;
                }
                if (sum > 0) {
                    r--;
                }
            }
        }
        return result;
    }

    public List<Object> radix(Character[] chars) {
        List<Object> result = new ArrayList<>();
        //计数
//        Map<Character, Integer> count = new LinkedHashMap<>();
//        for (Character c : chars) {
//            if (count.containsKey(c)) {
//                Integer total = count.get(c);
//                count.put(c, total + 1);
//            } else {
//                count.put(c, 1);
//            }
//        }
//
//        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
//            Character key = entry.getKey();
//            Integer value = entry.getValue();
//            result.add(key);
//            result.add(value);
//        }
        //aabbbaabbbb
        //a2b3a2b3
        Character cur = chars[0];
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            Character c = chars[i];
            if (c.equals(cur)) {
                count++;
            } else {
                //记录一下
                result.add(cur);
                result.add(count);

                cur = c;
                count = 1;
            }
        }

        //前沿的技术研究、落地数字化转型（物联网、机器人、智慧医疗、智能工厂、软件中心、智能计算研究中心）
        //实时计算、边缘计算（物联网云平台，传感器、设备接入做统一计算处理，总台驾驶舱，给企业提供决策辅助支持） 大量的简单计算
        //云EDA 电子设计自动化 云EDA 对服务器要求高 节省经费 Java、Python、Go    IOT
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};


    }
}
