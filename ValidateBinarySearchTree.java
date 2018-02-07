/**
 * 题目：给定一个二叉树，验证其是否为二叉搜索树。
 * 二叉搜索树的特点：
 * 1、左节点的值小于根节点的值；
 * 2、右节点的值大于根节点的值；
 * 3、左右子树都是二叉搜索树，满足相同的概念。
 * 解题思路：
 * 一开始想到递归，但是有一个问题需要注意：递归只能保证每个根节点比其左孩子大比其右孩子小，而无法保证左边的节点值都小于根节点，右边的都大于根节点
 * 所以，在这里我们想到：二叉搜索树有一个重要的性质：其中序遍历的结果是递增的。
 *
 */
import java.util.ArrayList;
public class ValidateBinarySearchTree {

}
class Solution128
{
	//定义一个存储结果的集合
	ArrayList<Integer> result=new ArrayList<Integer>();
	public boolean isValidBST(TreeNode root)
	{
		if(root==null) return true;
		if(root.left==null && root.right==null) return true;
		inOrderTraversal(root);
		for(int i=0;i<result.size()-1;i++)
		{
			if(result.get(i)>=result.get(i+1)) return false;
		}
		return true;
	}
	public void inOrderTraversal(TreeNode root)
	{
		if(root==null) return;
		inOrderTraversal(root.left);
		result.add(root.val);
		inOrderTraversal(root.right);
	}
}