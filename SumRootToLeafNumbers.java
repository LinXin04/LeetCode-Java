/**
 * 题目：给定一个二叉树，只包含数字0-9，返回从根节点到叶子结点所有的数字之和。
 * 例如：
 *  1
   / \
  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 解题思路：用一个递归：
 * 总的结果就是左子树+右子树。
 */
public class SumRootToLeafNumbers {
	
}

class Solution136
{
	public int sumNumbers(TreeNode root)
	{
		if(root==null) return 0;
		return helper(root,0);
	}
	public int helper(TreeNode root,int result)
	{
		if(root==null) return 0;
		if(root.left==null && root.right==null) return result*10+root.val;
		return helper(root.left,result*10+root.val)+helper(root.right,result*10+root.val);
	}
}