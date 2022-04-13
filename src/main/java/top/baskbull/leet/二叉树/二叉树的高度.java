package top.baskbull.leet.二叉树;

import top.baskbull.leet.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuzhuo
 * @date 2022/4/5 9:56 下午
 */
public class 二叉树的高度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public int maxDepth2(TreeNode root) {
        //非递归
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            result++;
        }
        return result;
    }
}
