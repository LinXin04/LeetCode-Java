/**
 * 题目：给定一个二叉树，求所有的左叶节点的和。
 * 例如：
 *   3
    / \
   9  20
     /  \
    15   7

 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * 解题思路：
 * 我们使用层次遍历，来寻找左叶节点：
 * 满足在左分支上，并且无左子女和右子女。
 */
import java.util.*;
public class SumOfLeftLeaves {

}
class Solution143
{
	public int sumOfLeftLeaves(TreeNode root)
	{
		if(root==null) return 0;
		
		int result=0;
		ArrayDeque<TreeNode> Q=new ArrayDeque<TreeNode>();
		Q.add(root);
		
		while(!Q.isEmpty())
		{
			TreeNode node=Q.pop();
			//如果node的left不为空，node的left的left为空并且node的left的right为空，则该节点为左叶节点
			if(node.left!=null && node.left.left==null && node.left.right==null) result+=node.left.val;
			if(node.left!=null) Q.add(node.left);
			if(node.right!=null) Q.add(node.right);
		}
		return result;
	}
}