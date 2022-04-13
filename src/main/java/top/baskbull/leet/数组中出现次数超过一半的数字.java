package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/5 9:05 下午
 */
public class 数组中出现次数超过一半的数字 {

    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
