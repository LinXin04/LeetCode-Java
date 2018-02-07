/**
 * 题目：给定一个链表，和一个整数n,求删除倒数第n个元素后的链表。
 * 例如：
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 只允许扫描一次。
 * 解题思路：
 * 如果按照常规的解题思路是找到最后一个节点，再倒退到倒数第n个节点，但是这样扫描两次不符合题意。
 * 所以，我们定义两个节点，一个节点为fast，一个节点是slow,fast先比slow多移动n个位置。
 * 如果此时fast是空，则表示要删除的是头结点，直接返回head->next.如果不是空，则删除slow对应的节点即可。
 */
import java.util.*;
public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		System.out.println("请输入链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		ListNode03 head=new ListNode03(Integer.parseInt(st[0]));
		ListNode03 nextNode=new ListNode03(Integer.parseInt(st[0]));
		for(int i=1;i<st.length;i++)
		{
			nextNode.next=new ListNode03(Integer.parseInt(st[i]));
			nextNode=nextNode.next;
		}
		
		System.out.println("请输入数字n:");
		int n=sc.nextInt();
		
		Solution81 sl=new Solution81();
		System.out.println("结果是：");
		ListNode03 newHead=sl.removeNthFromEnd(head, n);
		ListNode03 pre=newHead;
		while(pre!=null)
		{
			System.out.print(pre.val+" ");
			pre=pre.next;
		}
	}

}
class ListNode03
{
	int val;
	ListNode03 next;
	ListNode03(int x) {val=x;}
}

class Solution81
{
	public ListNode03 removeNthFromEnd(ListNode03 head,int n)
	{
		if(head==null || n==0) return head;
		
		ListNode03 fast=head;
		ListNode03 slow=head;
		
		//让fast先走3个,因为我们要找到删除节点前面的节点
		for(int i=0;i<n;i++)
			fast=fast.next;
		
		//如果fast为空，说明想要删除头节点
		if(fast==null)
		{
			head=head.next;
			return head;
		}
		
		//如果不为空，则一直遍历到尾部节点
		while(fast.next!=null)
		{
			fast=fast.next;
			slow=slow.next;
		}
		
		//删除slow指向的下一个节点
		slow.next=slow.next.next;
		return head;
	}
}