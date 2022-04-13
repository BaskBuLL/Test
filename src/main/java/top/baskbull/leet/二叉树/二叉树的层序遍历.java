package top.baskbull.leet.二叉树;

import com.google.common.collect.Lists;
import top.baskbull.leet.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liuzhuo
 * @date 2022/3/28 9:50 上午
 */
public class 二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        //遍历打印
        if (root == null) {
            return Lists.newArrayList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                temp.add(poll.getVal());
                if (poll.getLeft() != null) {
                    queue.offer(poll.getLeft());
                }
                if (poll.getRight() != null) {
                    queue.offer(poll.getRight());
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static int MaxWidthUseMap(TreeNode node) {
        //求最大宽度
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(node, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }

            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                //新层开始了 新层到来结算老层
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 0;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }
}
