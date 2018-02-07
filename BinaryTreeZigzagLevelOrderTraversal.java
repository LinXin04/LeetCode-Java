/**
 * 题目：求二叉树的Z字遍历结果。
 * 例如：
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 解题思路：
 * 与前面两题的解题思路相同，只需要在每次加入该层的结果时判断该行是否需要反转，奇数行不翻转、偶数行翻转
 *
 */
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
public class BinaryTreeZigzagLevelOrderTraversal {

}
class Solution117
{
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(root==null) return result;
		ArrayDeque<TreeNode> Q=new ArrayDeque<TreeNode>();
		Q.add(root);
		int Level=1;
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
			if(Level%2==0)
				Collections.reverse(curLevel);
			Level++;
			result.add(curLevel);
		}
		return result;
	}
}