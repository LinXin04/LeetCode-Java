/**
 * 题目：二叉树的后序遍历
 * 解题思路：
 * 后序遍历的特点：左右根
 * 前序遍历是根左右、将其转化成根右左，然后再reverse一下
 */
import java.util.Stack;
import java.util.Collections;

import java.util.ArrayList;
public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {

	}
}
class Solution112
{
	public ArrayList<Integer> postorderTraversal(TreeNode root)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(root==null) return result;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		//实现根右左
		while(true)
		{
			while(root!=null)
			{
				result.add(root.val);
				stack.push(root);
				root=root.right;
			}
			if(stack.isEmpty()) break;
			root=stack.pop();
			root=root.left;
		}
		Collections.reverse(result);
		return result;
	}
}