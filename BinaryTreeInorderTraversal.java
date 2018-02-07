/**
 * 题目：二叉树的中序遍历
 * 解题思路：
 * 中序遍历的特点：左根右
 * 利用栈来存储root,以便于访问右子树
 */
import java.util.Stack;
import java.util.ArrayList;
public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
	}
}
class Solution111
{
	public ArrayList<Integer> inorderTraversal(TreeNode root)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(root==null) return result;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		while(true)
		{
			while(root!=null)
			{
				stack.push(root);
				root=root.left;
			}
			if(stack.isEmpty()) break;
			root=stack.pop();
			result.add(root.val);
			root=root.right;	
		}
		return result;
	}
}