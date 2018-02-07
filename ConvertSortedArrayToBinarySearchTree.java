/**
 * 题目：给定一个有序数组，将它转变为一个高度平衡的二叉搜索树。HB(k),k=0.
 * 解题思路：
 * 很简单，用递归的方式。
 * root为数组的中间元素。然后将左平衡子树和右平衡子树相连接。
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

}
class Solution126
{
	public TreeNode sortedArrayToBST(int[] nums)
	{
		if(nums==null) return null;
		return helper(nums,0,nums.length-1);
	}
	public TreeNode helper(int[] nums,int left,int right)
	{
		if(left>right)
			return null;
		//求中点
		int m=(left+right)/2;
		TreeNode root=new TreeNode(nums[m]);
		root.left=helper(nums,left,m-1);
		root.right=helper(nums,m+1,right);
		return root;
	}
}