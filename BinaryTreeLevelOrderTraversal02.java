/**
 * 题目：本题在上一个题目的基础上，要求输出的结果是倒序的。
 * 例如：
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
  *    /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 解题思路：
 * 与上面的题目思路一样，同样是层次遍历，只是最后的存储方式不一样而已
 *
 */
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
public class BinaryTreeLevelOrderTraversal02 {

}
class TreeNode04
{
	int val;
	TreeNode04 left;
	TreeNode04 right;
	TreeNode04(int x){val=x;}
}
class Solution116
{
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(root==null) return result;
		ArrayDeque<TreeNode> Q=new ArrayDeque<TreeNode>();
		Q.add(root);
		TreeNode temp;
		while(!Q.isEmpty())
		{
			ArrayList<Integer> curLevel=new ArrayList<Integer>();
			int Size=Q.size();
			for(int i=0;i<Size;i++)
			{
				temp=Q.peek();
				curLevel.add(temp.val);
				Q.poll();
				if(temp.left!=null) Q.add(temp.left);
				if(temp.right!=null) Q.add(temp.right);
			}
			result.add(curLevel);
		}
		Collections.reverse(result);
		return result;
	}
}