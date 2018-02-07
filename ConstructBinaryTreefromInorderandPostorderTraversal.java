/**
 * 题目：给定二叉树的中序和后序遍历，求该二叉树。
 * 解题思路：与前一题解法相同，只是注意一下细节的不同：后序遍历的根节点在最后。
 *
 */
import java.util.*;
public class ConstructBinaryTreefromInorderandPostorderTraversal {

}
class Solution120 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null) return null;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
        	map.put(inorder[i], i);
        return Search(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    
    public TreeNode Search(int[] inorder,int inL,int inR,int[] postorder,int postL,int postR,HashMap map)
    {
    	if(inL>inR || postL>postR) return null;
    	//这个地方注意是选postR的
    	TreeNode root=new TreeNode(postorder[postR]);
    	int index=(int) map.get(root.val);
    	root.left=Search(inorder,inL,index-1,postorder,postL,postL+index-inL-1,map);
    	root.right=Search(inorder,index+1,inR,postorder,postR-(inR-index),postR-1,map);
    	return root;
    }
}