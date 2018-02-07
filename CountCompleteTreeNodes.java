/**
 * 题目：计算完全二叉树的节点数
 * 解题思路：
 * 递归的方法解决：
 * 如果是满二叉树，则直接调用公式2^h-1;
 * 如果不是，则将左右的节点数加和。
 */
public class CountCompleteTreeNodes {

}

class Solution138
{
	public int countNodes(TreeNode root)
	{
		if(root==null) return 0;
		int Lheight=0;
		int Rheight=0;
		
		TreeNode Lroot=root;
		TreeNode Rroot=root;
		//求左子树的高度
		while(Lroot!=null)
		{
			Lheight++;
			Lroot=Lroot.left;
		}
		//求右子树的高度
		while(Rroot!=null)
		{
			Rheight++;
			Rroot=Rroot.right;
		}
		//注意：这里不要用pow，否则会出错（数据量很大时，就超了）。
		if(Lheight==Rheight) return (2<<(Lheight-1))-1;
		else return countNodes(root.left)+countNodes(root.right)+1;
	}
}