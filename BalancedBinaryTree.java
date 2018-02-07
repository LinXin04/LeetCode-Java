/**
 * 题目：给定一个二叉树，判断该二叉树是不是高度平衡二叉树。高度平衡二叉树指的是：左子树和右子树的高度差不超过1，即为-1,0,1
 * 解题思路：
 * 同样使用递归的思想：
 * 1、如果root为空，返回true;
 * 2、如果root.left和root.right都为空，返回True;
 * 3、如果左子树的高度与右子树的高度差大于1，返回false；
 * 4、返回左右子树的与。
 * 深度的求法：1+max(左子树深度，右子树深度)
 * 
 */
public class BalancedBinaryTree {

}
class Solution127
{
	public boolean isBalanced(TreeNode root)
	{
		if(root==null) return true;
		if(root.left==null && root.right==null) return true;
		if(Math.abs(Depth(root.left)-Depth(root.right))>1) return false;
		return isBalanced(root.right)&&isBalanced(root.left);
	}
	public int Depth(TreeNode root)
	{
		if(root==null) return 0;
		return 1+Math.max(Depth(root.left), Depth(root.right));
	}
}