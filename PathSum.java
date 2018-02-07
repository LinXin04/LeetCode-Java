/**
 * 题目：判断从根到叶子的路径和跟给定sum是否相同。
 * 例如：
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 解题思路：
 * 递归的想法：看左子树或者右子树有没有满足条件的路径，也就是子树路径和等于当前sum减去当前节点的值。
 */
public class PathSum {

}
class Solution122 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null && root.right==null && root.val==sum)
        	return true;
        else
        	return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}