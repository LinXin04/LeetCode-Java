import javax.swing.tree.TreeNode;

/**
 * 题目：将给定的二叉树转化为“只有右孩子节点”的链表。（前序遍历的方式）
 * 例如：
 * Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * 解题思路：
 * 首先判断左子树是否为空，不为空就寻找到树根的左孩子节点；
 * 然后寻找该节点是否有右孩子，如果有继续寻找，直到找到属于叶子节点的右孩子；
 * 此时，该节点的右子树“指向”当前树的右子树，并将当前左子树变为树根的右孩子，将整棵树左孩子置为空。
 * 最后，根节点“指向”根节点的右孩子，继续上述操作，直到整棵树遍历完即得到结果。
 */
public class FlattenBinaryTreeToLinkedList {

}
class TreeNode25
{
	int val;
	TreeNode25 left;
	TreeNode25 right;
	TreeNode25(int x){val=x;}
}
class Solution131
{
	public void flatten(TreeNode25 root)
	{
		if(root==null) return;
		
		while(root!=null)
		{
			if(root.left!=null)
			{
				TreeNode25 cur=root.left;
				//寻找最右边的元素
				while(cur.right!=null)
				cur=cur.right;
				//将左子树插入到右子树中
				cur.right=root.right;
				root.right=root.left;
				root.left=null;
			}
			root=root.right;
		}
		
	}
}