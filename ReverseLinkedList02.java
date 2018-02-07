/**
 * 题目：给定一个单链表和两个整数m,n,让该链表在m和n中间的一段进行翻转
 * 例如：
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 解题思路：
 * 我们先找到m-n的链表，并将其进行翻转，之后插入到原链表中
 */
import java.util.Scanner;
public class ReverseLinkedList02 {

	public static void main(String[] args) {
		System.out.println("请输入链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		ListNode17 head=new ListNode17(Integer.parseInt(st[0]));
		ListNode17 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode17(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		System.out.println("请输入开始节点：");
		int m=sc.nextInt();
		System.out.println("请输入结束节点：");
		int n=sc.nextInt();
		
		Solution98 sl=new Solution98();
		ListNode17 result=sl.reverseBetween(head, m, n);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}

class ListNode17
{
	int val;
	ListNode17 next;
	ListNode17(int x) {val=x;}
}

class Solution98
{
	public ListNode17 reverseBetween(ListNode17 head,int m,int n)
	{
		if(head==null || head.next==null) return head;
		
		ListNode17 dummy=new ListNode17(-1);
		dummy.next=head;
		
		//首先找到m的前面一个的位置
		ListNode17 first=dummy;
		int i=1;
		while(first.next!=null && i<m) 
		{
			first=first.next;
			i++;
		}
		//m的位置
		ListNode17 mNode=first.next;
		ListNode17 cur=mNode.next;
		
		while(cur!=null && i<n)
		{
			ListNode17 next=cur.next;
			cur.next=first.next;
			first.next=cur;
			mNode.next=next;
			cur=next;
			i++;
		}
		return dummy.next;
	}
}