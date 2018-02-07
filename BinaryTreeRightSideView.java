/**
 * 题目：返回二叉树的最右侧视图
 * 例如：
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 * 解题思路：利用层次遍历的方法，每次将该层的最后一个元素加入到结果集中
 *
 */
import java.util.*;
public class BinaryTreeRightSideView {

}
class Solution137
{
	public ArrayList<Integer> rightSideView(TreeNode root)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(root==null) return result;
		
		ArrayDeque<TreeNode> Q=new ArrayDeque<TreeNode>();
		Q.add(root);
		
		while(!Q.isEmpty())
		{
			//二叉树中每一行的节点个数
			int Size=Q.size();
			for(int i=0;i<Size-1;i++)
			{
				TreeNode node=Q.poll();
				if(node.left!=null) Q.add(node.left);
				if(node.right!=null) Q.add(node.right);
			}
			
			//把最后一个节点加入到队列中及结果集中
			TreeNode lastNode=Q.poll();
			result.add(lastNode.val);
			if(lastNode.left!=null) Q.add(lastNode.left);
			if(lastNode.right!=null) Q.add(lastNode.right);
		}
		return result;
	}
}