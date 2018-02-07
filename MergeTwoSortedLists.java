/**
 * 题目：合并两个有序的链表
 * 解题思路：首先确定一个主链表，比如l1，若l1.val>l2.val,则将l2的值插入到l1当前值的前面；否则将l1的指针后移。
 *
 */
import java.util.Scanner;
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		System.out.println("请输入第一个链表：");
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine();
		String []st1=s1.split(" ");
		ListNode04 l1=new ListNode04(Integer.parseInt(st1[0]));
		ListNode04 head1=l1;
		for(int i=1;i<st1.length;i++)
		{
			head1.next=new ListNode04(Integer.parseInt(st1[i]));
			head1=head1.next;
		}
		System.out.println("请输入第二个链表：");
		String s2=sc.nextLine();
		String []st2=s2.split(" ");
		ListNode04 l2=new ListNode04(Integer.parseInt(st2[0]));
		ListNode04 head2=l2;
		for(int i=1;i<st2.length;i++)
		{
			head2.next=new ListNode04(Integer.parseInt(st2[i]));
			head2=head2.next;
		}
		
		Solution82 sl=new Solution82();
		ListNode04 result=sl.mergerTwoLists(l1, l2);
		
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}

	}

}

class ListNode04
{
	int val;
	ListNode04 next;
	ListNode04(int x) {val=x;}
}

class Solution82
{
	public ListNode04 mergerTwoLists(ListNode04 l1,ListNode04 l2)
	{
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		
		ListNode04 result=new ListNode04(0);
		ListNode04 pre=result;
		result.next=l1;
		//将l1作为主链表
		while(l1!=null && l2!=null)
		{
			if(l1.val>l2.val)
			{
				ListNode04 next=l2.next;
				l2.next=pre.next;
				pre.next=l2;
				l2=next;
			}else
			{
				l1=l1.next;
			}
			pre=pre.next;
		}
		
		if(l2!=null)
		{
			pre.next=l2;
		}
	return result.next;	
	}
}