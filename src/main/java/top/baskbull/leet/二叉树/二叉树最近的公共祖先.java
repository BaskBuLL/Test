package top.baskbull.leet.二叉树;

import top.baskbull.leet.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author liuzhuo
 * @date 2022/4/5 8:34 下午
 */
public class 二叉树最近的公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        fill(root, map);

        HashSet<TreeNode> set = new HashSet<>();
        TreeNode cur = p;
        set.add(cur);
        while (map.get(cur) != null) {
            cur = map.get(cur);
            set.add(cur);
        }
        cur = q;
        while (!set.contains(cur)) {
            cur = map.get(cur);
        }
        return cur;
    }

    public void fill(TreeNode node, Map<TreeNode, TreeNode> map) {
        if (node.left != null) {
            map.put(node.left, node);
            fill(node.left, map);
        }
        if (node.right != null) {
            map.put(node.right, node);
            fill(node.right, map);
        }
    }
}
