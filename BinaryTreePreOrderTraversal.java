/**
 * 题目：二叉树的前序遍历
 * 解题思路：
 * 前序遍历的特点：根左右
 * 利用栈来存储root,以便于访问右子树
 */
import java.util.Stack;
import java.util.ArrayList;
public class BinaryTreePreOrderTraversal {
	public static void main(String[] args) {

	}

}
class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {val=x;}
}
class Solution110
{
	public ArrayList<Integer> preorderTraversal(TreeNode root)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(root==null) return result;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		while(true)
		{
			while(root!=null)
			{
				result.add(root.val);
				stack.push(root);
				root=root.left;
			}
			if(stack.isEmpty()) break;
			root=stack.pop();
			root=root.right;
		}
		return result;
	}
}
