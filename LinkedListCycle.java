/**
 * 题目：判断单链表中是否存在环
 * 题目解析:
 * 快慢指针:定义两个指针slow和fast,slow每次走一步，fast每次走两步，如果两个指针相等，则有环；否则无环
 *
 */
import java.util.Scanner;
public class LinkedListCycle {

	public static void main(String[] args) {
		//注意：这里没有实现输入循环链表的功能
		System.out.println("请输入链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		ListNode13 head=new ListNode13(Integer.parseInt(st[0]));
		ListNode13 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode13(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		
		Solution94 sl=new Solution94();
		boolean result=sl.hasCycle(head);
		System.out.println("结果是："+result);

	}
}
class ListNode13
{
	int val;
	ListNode13 next;
	ListNode13(int x)
	{
		val=x;
		next=null;
	}
}
class Solution94
{
	public boolean hasCycle(ListNode13 head)
	{
		if(head==null) return false;
		//定义快慢指针
		ListNode13 slow=head;
		ListNode13 fast=head;
		
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) return true;
		}
		return false;
	}
}