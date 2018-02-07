/**
 * 题目：求二叉树的最小深度。
 * 解题思路：
 * 深度搜索DFS
 * 1，树为空，则为0。 
 * 2，根节点如果只存在左子树或者只存在右子树，则返回值应为左子树或者右子树的（最小深度+1）。 
 * 3，如果根节点的左子树和右子树都存在，则返回值为（左右子树的最小深度的较小值+1）。
 *
 */
public class MinimumDepthofBinaryTree {

}
class Solution121
{
	public int minDepth(TreeNode root)
	{
		if(root==null) return 0;
		if(root.left==null && root.right==null) return 1;
		else if(root.left==null) return minDepth(root.right)+1;
		else if(root.right==null) return minDepth(root.left)+1;
		else return Math.min(minDepth(root.right), minDepth(root.left))+1;
	}
}