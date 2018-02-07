/**
 * 题目：求二叉树的最大深度：最大深度定义为从根结点出发，到最远叶子结点的长度。
 * 解题思路：层次遍历，最后一层便是最大深度。
 *
 */
import java.util.ArrayList;
import java.util.ArrayDeque;
public class MaximumDepthofBinaryTree {

}

class Solution118
{
	public int maxDepth(TreeNode root)
	{
		if(root==null) return 0;
		ArrayDeque<TreeNode> Q=new ArrayDeque<TreeNode>();
		Q.add(root);
		int result=0;
		TreeNode temp;
		
		while(!Q.isEmpty())
		{
			int Size=Q.size();
			for(int i=0;i<Size;i++)
			{
				temp=Q.poll();
				if(temp.left!=null) Q.add(temp.left);
				if(temp.right!=null) Q.add(temp.right);
			}
			result++;
		}
		return result;
	}
}