/**
 * 题目：给定一个二叉树，求该二叉树的最大路径和。可以从任意节点开始到达任意节点结束。
 * 例如：
 * Given the below binary tree,

       1
      / \
     2   3
 * Return 6.
 * 解题思路：
 * 递归地求一条经过root的最大路径：
 * 1、左边某条路径+root+右边某条路径
 * 2、左边某条路径+root
 * 3、root+右边某条路径
 * 4、root
 *
 */
public class BinaryTreeMaximumPathSum {

}
class Solution134
{
	int result=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root)
	{
		if(root==null) return 0;
		helper(root);
		return result;
	}
	public int helper(TreeNode root)
	{
		if(root==null) return 0;
		
		int leftMax=helper(root.left);
		int rightMax=helper(root.right);
		
		//当前的最大值
		int curMax=root.val;
		if(leftMax>0) curMax+=leftMax;
		if(rightMax>0) curMax+=rightMax;
		result=Math.max(result, curMax);
		
		//下面返回的是当前叶子结点到root的最大路径和
		return Math.max(root.val,root.val + Math.max(leftMax, rightMax));
	}
}