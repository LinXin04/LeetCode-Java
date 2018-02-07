/**
 * 题目：给定一个有序链表，删除所有有重复的元素，返回新的链表。
 * 例如：
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 解题思路：
 * 定义两个指针，pre和cur,pre指向没有重复元素的最后一个节点，cur为重复元素的最后一个节点
 */
import java.io.*;
public class RemoveDuplicatesFromSortedList02 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		System.out.println("请输入一个链表：");
		String s=buf.readLine();
		String []st=s.split(" ");
		
		ListNode10 head=new ListNode10(Integer.parseInt(st[0]));
		ListNode10 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode10(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		
		Solution88 sl=new Solution88();
		ListNode10 result=sl.deleteDuplicates(head);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}

	}
}

class ListNode10
{
	int val;
	ListNode10 next;
	ListNode10(int x) {val=x;}
}

class Solution88
{
	public ListNode10 deleteDuplicates(ListNode10 head)
	{
		if(head==null || head.next==null) return head;
		
		//定义两个指针
		//pre指向没有重复元素的最后一个
		ListNode10 pre=new ListNode10(0);
		pre.next=head;
		ListNode10 result=pre;
		ListNode10 cur=head;
		
		while(cur!=null)
		{
			//cur指向重复元素的最后一个
			while(cur.next!=null && cur.next.val==pre.next.val)
				cur=cur.next;
			//如果中间没有重复元素
			if(pre.next==cur)
				pre=pre.next;
			else
				pre.next=cur.next;
			cur=cur.next;
		}
		return result.next;
	}
}