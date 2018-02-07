/**
 * 题目：给定一个含有重复元素的有序链表，将重复元素删除，只剩下一个，返回删除重复元素后的链表
 * 例如：
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 解题思路：
 * 定义两个指针，一个是pre,一个是cur,如果两个相等，则pre.next=cur.next,否则，pre后移。
 *
 */
import java.io.*;
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		System.out.println("请输入一个链表：");
		String s=buf.readLine();
		String []st=s.split(" ");
		
		ListNode09 head=new ListNode09(Integer.parseInt(st[0]));
		ListNode09 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode09(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		
		Solution87 sl=new Solution87();
		ListNode09 result=sl.deleteDuplicates(head);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
}
class ListNode09
{
	int val;
	ListNode09 next;
	ListNode09(int x){val=x;}
}
class Solution87
{
	public ListNode09 deleteDuplicates(ListNode09 head)
	{
		if(head==null || head.next==null) return head;
		
		//定义两个指针
		ListNode09 pre=head;
		ListNode09 cur=head.next;
		while(cur!=null)
		{
			if(pre.val==cur.val)
				pre.next=cur.next;
			else
				pre=cur;
			cur=cur.next;
		}
		return head;
	}
}