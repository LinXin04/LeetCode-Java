/**
 * 题目：给定的一个二叉搜索树，里面有两个元素错误地调换了位置，请将这个树恢复原状。
 * 解题思路：
 * 中序遍历寻找逆序情况，调换的第一个元素，永远是第一个逆序的第一个元素，而调换的第二个元素如果只有一次逆序，则是那一次的后一个，如果有两次逆序则是第二次的后一个。
 * 例如：
 * 163452，这样我们需要找出两个逆序的地方，63和52，并交换第一个逆序的前者和第二个逆序的后者。
 */
public class RecoverBinarySearchTree {

}
class Solution129 {
	//定义存储两个数的节点
	TreeNode pre=null;
	TreeNode p=null;
	TreeNode q=null;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        helper(root);
        int temp=p.val;
        p.val=q.val;
        q.val=temp;
    }
    //中序遍历寻找逆序的情况
    public void helper(TreeNode root)
    {
    	if(root==null) return;
    	helper(root.left);
    	//找到逆序的位置
    	if(pre!=null && pre.val>root.val)
    	{
    		//如果第一个逆序还没找到
    		if(p==null)
    		{
    			p=pre;
    			q=root;
    		}else
    		{
    			//第一个已经找到，第二次找到逆序的地方就是第二个逆序元素
    			q=root;
    		}
    	}
    	pre=root;
    	helper(root.right);
    }
}