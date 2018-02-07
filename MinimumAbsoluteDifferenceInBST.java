/**
 * 题目：给定一个非负的二叉搜索树，求任意两个节点的最小绝对差。
 * 例如：
 * Input:

   1
    \
     3
    /
   2

 * Output:
 * 1
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * 解题思路：
 * 因为二叉搜索树的中序遍历是递增的，所以，最小绝对差一定存在在相邻的两个节点中。
 */
import java.util.*;
public class MinimumAbsoluteDifferenceInBST {

}
class Solution152
{
	int result=Integer.MAX_VALUE;
	int pre=-1;
	public int getMinimumDifference(TreeNode root)
	{
		if(root==null) return 0;
		inOrder(root);
		return result;
		
	}
	public void inOrder(TreeNode root)
	{
		if(root==null) return;
		Stack<TreeNode> s=new Stack<TreeNode>();
		s.push(root);
		while(!s.isEmpty())
		{
			inOrder(root.left);
			if(pre!=-1)
				result=Math.min(result, Math.abs(pre-s.peek().val));
			pre=s.pop().val;
			inOrder(root.right);
		}
	}
}