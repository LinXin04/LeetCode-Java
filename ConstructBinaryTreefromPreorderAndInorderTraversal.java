/**
 * 题目：给定一个二叉树的前序和中序遍历，求该二叉树。
 * 解题思路：
 * 前序遍历：12453687
 * 中序遍历：42516837
 * 1、由前序遍历找到根的所在，即1位根；
 * 2、根据根1，将中序遍历分为左子树和右子树：425和6837；同时前序遍历也被分为了左子树和右子树：245和3687
 * 3、左子树的中序遍历：425，前序遍历:245；右子树的中序遍历：6837，前序遍历:3687；
 * 重复上述方法，直到剩下一个元素。
 * 注意：在这里我们需要用一个HashMap将每次根对应的下标存放，以便对左右子树进行分割。
 */
import java.util.HashMap;
public class ConstructBinaryTreefromPreorderAndInorderTraversal {

}
class Solution119
{
	public TreeNode buildTree(int[] preorder,int[] inorder)
	{
		if(preorder==null || inorder==null) return null;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<inorder.length;i++)
			map.put(inorder[i], i);
		return Search(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
	}
	public TreeNode Search(int[] preorder,int preL,int preR,int[] inorder,int inL,int inR,HashMap map)
	{
		if(preL>preR || inL>inR) return null;
		//将前序遍历中的根节点（即preL位置上的）存入
		TreeNode root=new TreeNode(preorder[preL]);
		//找到根节点在inorder中的位置
		int index=(int) map.get(root.val);
		root.left=Search(preorder,preL+1,preL+index-inL,inorder,inL,index-1,map);
		root.right=Search(preorder,preL+index-inL+1,preR,inorder,index+1,inR,map);
		return root;
	}
}