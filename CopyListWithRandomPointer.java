/**
 * 题目：深拷贝一个链表，链表除了含有next指针外，还包含一个random指针，该指针指向字符串中的某个节点或者为空。
 * 解题思路：
 * 1.第一遍扫描：对每个结点进行复制，把复制出来的新结点插在原结点之后 
 * 2.第二遍扫描：根据原结点的random，给新结点的random赋值 
 * 3.第三遍扫描：把新结点从原链表中拆分出来  
 */

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		

	}

}
class RandomListNode
{
	int label;
	RandomListNode next,random;
	RandomListNode(int x) {this.label=x;}
}
class Solution99
{
	public RandomListNode copyRandomList(RandomListNode head)
	{
		if(head==null) return head;
		
		//第一遍扫描：对每个结点进行复制，把复制出来的新结点插在原结点之后
		RandomListNode cur=head;
		while(cur!=null)
		{
			RandomListNode newNode=new RandomListNode(cur.label);
			newNode.next=cur.next;
			cur.next=newNode;
			cur=newNode.next;
		}
		
		//第二遍扫描：根据原结点的random，给新结点的random赋值 
		cur=head;
		while(cur!=null)
		{
			if(cur.random!=null) cur.next.random=cur.random.next;
			cur=cur.next.next;
		}
		
		//第三遍扫描：把新结点从原链表中拆分出来
		RandomListNode newHead=head.next;
		cur=head;
		while(cur!=null)
		{
			RandomListNode newNode=cur.next;
			cur.next=newNode.next;
			if(newNode.next!=null) newNode.next=newNode.next.next;
			cur=cur.next;
		}
		return newHead;
	}
}