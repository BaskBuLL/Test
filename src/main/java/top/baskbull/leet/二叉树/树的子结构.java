package top.baskbull.leet.二叉树;

import top.baskbull.leet.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuzhuo
 * @date 2022/4/5 4:40 下午
 */
public class 树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //先序遍历A中的每个节点n
        //判断树A中以n为根节点是否包含B树 时间复杂度 O(MN) O(M)
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 存放所有与B的根节点相同的节点
        List<TreeNode> ans = new ArrayList<>();
        // 前序遍历，中左右
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == B.val) {
                ans.add(node);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        // 判断和B相同根节点的子树是否包含B
        for (int i = 0; i < ans.size(); i++) {
            if (isSameStructure(ans.get(i), B)) {
                return true;
            }
        }
        return false;
    }

    // A、B相同根节点，判断B是否是A的子结构
    public boolean isSameStructure(TreeNode A, TreeNode B) {
        // A、B两棵树的前序遍历（中左右）辅助栈
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();
        stackA.push(A);
        stackB.push(B);
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            TreeNode nodeA = stackA.pop();
            TreeNode nodeB = stackB.pop();
            // 如果两个对应位置元素值不相同，则说明B不是A的子树，返回false
            if (nodeA.val != nodeB.val) {
                return false;
            }
            // 右节点均不为空则分别入栈；同时为空则跳过；如果B的子节点为空，但A的子节点不为空，则返回false
            if (nodeA.right != null && nodeB.right != null) {
                stackA.push(nodeA.right);
                stackB.push(nodeB.right);
            } else if (nodeB.right != null) {
                return false;
            }
            // 左节点均不为空则分别入栈；同时为空则跳过；
            if (nodeA.left != null && nodeB.left != null) {
                stackA.push(nodeA.left);
                stackB.push(nodeB.left);
            } else if (nodeB.left != null) {
                return false;
            }
        }
        return stackB.isEmpty();
    }

}
