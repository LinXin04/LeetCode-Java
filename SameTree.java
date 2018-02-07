/**
 * 题目：判断两个二叉树是否相等。结构以及节点的值相等，才可以认作相等。
 * 解题思路：有递归和非递归的解法。
 * 非递归中使用层次遍历
 *
 */
import java.util.ArrayDeque;
public class SameTree {
	public static void main(String[] args) {
	}
}

class Solution113
{
	public boolean isSameTree(TreeNode p,TreeNode q)
	{
		//递归法
//		if(p==null && q==null) return true;
//		else if((p==null && q!=null) || (p!=null && q==null)) return false;
//		
//		if(p.val==q.val)
//			return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
//		else
//			return false;
		//非递归法，层次遍历
		if(p==null && q==null) return true;
		else if((p==null && q!=null) || (p!=null && q==null)) return false;
		
		ArrayDeque<TreeNode> Q1=new ArrayDeque<TreeNode>();
		ArrayDeque<TreeNode> Q2=new ArrayDeque<TreeNode>();
		Q1.add(p);
		Q2.add(q);
		
		TreeNode temp1;
		TreeNode temp2;
		
		while(!Q1.isEmpty() && !Q2.isEmpty())
		{
			temp1=Q1.poll();
			temp2=Q2.poll();
			if(temp1.val!=temp2.val) return false;
			
			if(temp1.left!=null && temp2.left!=null) 
			{
				Q1.add(temp1.left);
				Q2.add(temp2.left);
			}else if((temp1.left==null && temp2.left!=null) || (temp1.left!=null && temp2.left==null))
				return false;
			if(temp1.right!=null && temp2.right!=null) 
			{
				Q1.add(temp1.right);
				Q2.add(temp2.right);
			}else if((temp1.right==null && temp2.right!=null) || (temp1.right!=null && temp2.right==null))
				return false;
		}
		return true;
	}
}