/**
 * 题目：给定一颗二叉树（满二叉树），将其每层上的节点从左到右链接起来形成链表。
 * 例如：
 * Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
 * After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * 解题思路：
 * 我们利用层次遍历的方法进行加链。
 */
public class PopulatingNextRightPointersInEachNode {

}
class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

class Solution132 {
   public void connect(TreeLinkNode root) {
       if(root==null) return;
       
       while(root!=null)
       {
    	   if(root.left==null) return;
    	   TreeLinkNode p=root;
    	   while(p!=null)
    	   {
    		   p.left.next=p.right;
    		   if(p.next!=null)
    			   p.right.next=p.next.left;
    		   p=p.next;
    	   }
    	   root=root.left;
       }
   }
}