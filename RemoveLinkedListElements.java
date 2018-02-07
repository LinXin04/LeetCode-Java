/**
 * 题目：给定一个链表和一个整数，删除链表中的所有该整数，并返回删除后的链表
 * 例如：
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 解题思路：
 * 遍历一遍，有重复的就删除。
 *
 */
import java.util.Scanner;
public class RemoveLinkedListElements {

	public static void main(String[] args) {
		System.out.println("请输入一个链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] st=s.split(" ");
		ListNode12 head=new ListNode12(Integer.parseInt(st[0]));
		ListNode12 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode12(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		
		System.out.println("请输入一个整数val:");
		int val=sc.nextInt();
		Solution90 sl=new Solution90();
		ListNode12 result=sl.removeElements(head, val);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
}
class ListNode12
{
	int val;
	ListNode12 next;
	public ListNode12(int x){val=x;}
}
class Solution90
{
	public ListNode12 removeElements(ListNode12 head,int val)
	{
		if(head==null) return null;
		
		//定义两个指针
		ListNode12 pre=new ListNode12(0);
		pre.next=head;
		ListNode12 result=pre;
		ListNode12 cur=head;
		
		while(cur!=null)
		{
			if(cur.val==val)
			{
				pre.next=cur.next;
				cur=cur.next;	
			}
			else
			{
				pre=pre.next;
				cur=cur.next;
			}	
		}
		return result.next;
	}
}