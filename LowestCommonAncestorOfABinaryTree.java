/**
 * 题目：给定一个二叉树，和两个节点p和q，找寻它们最近的祖先节点
 * 例如：
 *      _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      2        0       8
         /  \
        7   4
 * the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5      
 * 解题思路：
 * 这个题目与之前的那个二叉搜索树不同，那个可以利用性质。
 * 本题目则是：现在左子树中找，再在右子树中找，如果两个相等，则返回root，否则返回不为空的那个。
 */
public class LowestCommonAncestorOfABinaryTree {

}
class Solution141{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
    	  if(root==null || p==null || q==null) return null;
          if(root!=null && (p==root || q==root)) return root;
          
          TreeNode left=lowestCommonAncestor(root.left,p,q);
          TreeNode right=lowestCommonAncestor(root.right,p,q);
          
          if(left!=null && right!=null) return root;
          else return left!=null?left:right;
      }
  }