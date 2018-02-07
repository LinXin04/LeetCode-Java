/**
 * 题目：判断是否是循环链表。若是，则返回循环开始的节点；否则返回NULL
 * 题目解析：
 * 快慢指针：一个slow,一个fast,利用第一个题目的思想，找到重复的位置。
 * 这时，将slow置为head,两个指针同时前进，每次前进一步，知道再次相遇，则该位置即为循环开始的节点
 *
 */
import java.util.Scanner;
public class LinkedListCycle02 {

	public static void main(String[] args) {
		System.out.println("请输入链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String []st=s.split(" ");
		ListNode14 head=new ListNode14(Integer.parseInt(st[0]));
		ListNode14 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp=new ListNode14(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		Solution95 sl=new Solution95();
		ListNode14 result=sl.detectCycle(head);
		System.out.println("结果是："+result);
	}
}

class ListNode14
{
	int val;
	ListNode14 next;
	ListNode14(int x)
	{
		val=x;
		next=null;
	}
}

class Solution95
{
	public ListNode14 detectCycle(ListNode14 head)
	{
		if(head==null) return null;
		
		ListNode14 slow=head;
		ListNode14 fast=head;
		
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) break;
		}
		//没有环的情况
		if(fast==null || fast.next==null) return null;
		//有环的情况
		slow=head;
		while(slow!=fast)
		{
			slow=slow.next;
			fast=fast.next;
		}
		return fast;
	}
}