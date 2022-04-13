package top.baskbull.leet.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liuzhuo
 * @date 2022/3/28 9:51 上午
 */
@Data
@EqualsAndHashCode
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
