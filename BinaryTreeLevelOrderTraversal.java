/**
 * 题目：二叉树的层次遍历
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *    return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 解题思路：
 * 就是在层次遍历的基础上加了个输出限制，每次输出该层的节点。
 */
import java.util.ArrayList;

import javax.swing.tree.TreeNode;

import java.util.ArrayDeque;
public class BinaryTreeLevelOrderTraversal {

}
class TreeNode03
{
	int val;
	TreeNode03 left;
	TreeNode03 right;
	TreeNode03(int x){val=x;}
}
class Solution115
{
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode03 root)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(root==null) return result;
		ArrayDeque<TreeNode03> Q=new ArrayDeque<TreeNode03>();
		Q.add(root);
		TreeNode03 temp;
		
		while(!Q.isEmpty())
		{
			ArrayList<Integer> curLevel=new ArrayList<Integer>();
			int Size=Q.size();
			for(int i=0;i<Size;i++)
			{
				temp=Q.peek();
				curLevel.add(temp.val);
				Q.poll();
				if(temp.left!=null)
					Q.add(temp.left);
				if(temp.right!=null)
					Q.add(temp.right);
			}
			result.add(curLevel);
		}
		return result;
	}
}