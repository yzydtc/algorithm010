import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
     List<Integer> res = new ArrayList<>();
     recursion(root, res);
     return res;
    }

    //使用递归
    public void recursion(TreeNode root,List<Integer> res) {
     if ( root != null) {
        if ( root.left != null) {
            recursion(root.left,res);
        }
        res.add(root.val);
        if ( root.right != null ) {
            recursion(root.right,res);
        }
    }
    }
}
// @lc code=end

