/**
 * 题目：判断二叉树是否对称
 * 解题思路：
 * 递归或者非递归。
 * 非递归中使用层次遍历。
 *
 */
import java.util.ArrayDeque;

import javax.swing.tree.TreeNode;
public class SymmetricTree {

}
class TreeNode02
{
	int val;
	TreeNode02 left;
	TreeNode02 right;
	TreeNode02(int x){val=x;}
}
class Solution114
{
	public boolean isSymmetric(TreeNode02 root)
	{
//		//递归的方法
//		if(root==null) return true;
//		return helper(root.left,root.right);
//	}
//	public boolean helper(TreeNode r1,TreeNode r2)
//	{
//		if(r1==null && r2==null) return true;
//		else if((r1==null && r2!=null) || (r2==null && r1!=null))
//			return false;
//		if(r1.val==r2.val)
//			//注意这里是左和右相等
//			return helper(r1.left,r2.right) && helper(r1.right,r2.left);
//		else
//			return false;
		//非递归的方法
		if(root==null) return true;
		ArrayDeque<TreeNode02> Q1=new ArrayDeque<TreeNode02>();
		ArrayDeque<TreeNode02> Q2=new ArrayDeque<TreeNode02>();
		
		if(root.left!=null && root.right!=null)
		{
			Q1.add(root.left);
			Q2.add(root.right);
		}else if(root.left==null && root.right==null)
			return true;
		else if((root.left!=null && root.right==null) || (root.left==null && root.right!=null))
			return false;
		
		TreeNode02 temp1;
		TreeNode02 temp2;
		while(!Q1.isEmpty() && !Q2.isEmpty())
		{
			temp1=Q1.poll();
			temp2=Q2.poll();
			
			if(temp1.val!=temp2.val) return false;
			if(temp1.left!=null && temp2.right!=null)
			{
				Q1.add(temp1.left);
				Q2.add(temp2.right);
			}else if((temp1.left==null && temp2.right!=null) || (temp1.left!=null && temp2.right==null))
				return false;
			if(temp1.right!=null && temp2.left!=null)
			{
				Q1.add(temp1.right);
				Q2.add(temp2.left);
			}else if((temp1.right==null && temp2.left!=null) || (temp1.right!=null && temp2.left==null))
				return false;	
		}
		return true;
	}
}
