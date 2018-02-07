/**
 * 题目：在二叉搜索树中寻找第k小元素。
 * 解题思路：
 * 因为BST的一个重要性质是：其中序遍历的结果是一个升序，我们在这里就利用这个思想
 *
 */
import java.util.*;
public class KthSmallestElementInABST {

}
class Solution139
{
	public int kthSmallest(TreeNode root,int k)
	{
		if(root==null || k<=0) return 0;
		
		Stack<TreeNode> S=new Stack<TreeNode>();
		int cur=0;
		while(true)
		{
			while(root!=null)
			{
				S.push(root);
				root=root.left;
			}
			if(S.isEmpty()) break;
			root=S.peek();
			cur++;
			if(cur==k) return root.val;
			S.pop();
			root=root.right;
		}
		return 0;
	}
}