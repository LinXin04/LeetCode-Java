/**
 * 题目：翻转二叉树。
 * 例如：
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 解题思路：
 * 利用递归，来交换两边的二叉树
 * 非递归的方法：利用层次遍历，在每次搜索到一个节点时，都交换它的左右节点。
 */
import java.util.*;
public class InvertBinaryTree {

}
class Solution130 {
    public TreeNode invertTree(TreeNode root) {
//    	//递归
//    	if(root==null) return null;
//    	TreeNode temp=root.left;
//    	root.left=invertTree(root.right);
//    	root.right=invertTree(temp);
//        return root;
    	//非递归
    	if(root==null) return null;
    	ArrayDeque<TreeNode> Q=new ArrayDeque<TreeNode>();
    	Q.add(root);
    	while(!Q.isEmpty())
    	{
    		TreeNode node=Q.poll();
    		TreeNode temp=node.left;
    		node.left=node.right;
    		node.right=temp;
    		if(node.left!=null) Q.add(node.left);
    		if(node.right!=null) Q.add(node.right);
    	}
    	return root;
    }
}