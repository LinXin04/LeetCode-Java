/**
 * 题目：二叉树路径。给定一个二叉树，请输出它的所有路径
 * 例如：
 * For example, given the following binary tree:
 *   1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * 解题思路：
 * 用深度优先搜索DFS将每条路径保存
 * 依然是递归的方法搜索左右子树。
 */
import java.util.*;
public class BinaryTreePaths {

}
class Solution142
{
	ArrayList<String> result=new ArrayList<String>();
	public ArrayList<String> binaryTreePaths(TreeNode root)
	{
		if(root==null) return result;
		DFS(root,String.valueOf(root.val));
		return result;
	}
	public void DFS(TreeNode root,String path)
	{
		if(root==null) return;
		//如果左边、右边都为空，则只需要把root加入即可
		if(root.left==null && root.right==null) result.add(path);
		//如果左边不为空，将左边的所有结果加入
		if(root.left!=null) DFS(root.left, path+"->"+String.valueOf(root.left.val));
		if(root.right!=null) DFS(root.right,path+"->"+String.valueOf(root.right.val));
	}
}