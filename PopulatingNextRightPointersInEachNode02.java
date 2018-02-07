/*
 * 题目：给定一棵二叉树，这个不一定是满二叉树，将其每层上的节点从左到右链接起来形成链表。
 * 例如：
 * Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
 * After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 *  解题思路：
 *  同样是一层一层地遍历。
 *  定义两个变量：一个是pre，记录当前层的前一个节点；next记录当前层的起始节点。
 *    
 */
public class PopulatingNextRightPointersInEachNode02 {

}
class Solution133
{
	public void connect(TreeLinkNode root)
	{
		TreeLinkNode pre;
		TreeLinkNode next;
		
		while(root!=null)
		{
			pre=null;
			next=null;
			
			for(;root!=null;root=root.next)
			{
				//每遍历一层，上面将next置为NULL，然后再置为当前层的第一个节点
				if(next==null) next=root.left!=null?root.left:root.right;
				
				//将每一层的节点连接起来
				if(root.left!=null)
				{
					if(pre!=null) pre.next=root.left;
					pre=root.left;
				}
				if(root.right!=null)
				{
					if(pre!=null) pre.next=root.right;
					pre=root.right;
				}	
			}
			root=next;
		}
	}
}