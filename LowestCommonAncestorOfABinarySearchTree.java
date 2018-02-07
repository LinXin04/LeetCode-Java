/**
 * 题目：给定一个二叉搜索树和两个节点p和q，求这两个节点的最近的公共祖先
 * 例如：
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
 * the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2,
 * 解题思路：
 * 左<根<右
 * 1、如果这两个节点在根节点的左右子树上，那么毫无疑问，最近的节点是根节点
 * 2、如果这两个节点在同一个子树上，那么我们需要递归来求解了。
 *
 */
public class LowestCommonAncestorOfABinarySearchTree {

}
class Solution140
{
	public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q)
	{
		if(root==null || p==null || q==null) return null;
		
		//判断两个节点是不是在一个子树上
		if((p.val<=root.val && q.val>=root.val) || (p.val>=root.val && q.val<=root.val)) return root;
		//如果不是的话，则递归求解
		else if(p.val<=root.val && q.val<=root.val) return lowestCommonAncestor(root.left,p,q);
		else return lowestCommonAncestor(root.right,p,q);
	}
}