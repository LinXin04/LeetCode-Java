/**
 * 题目：给定一个链表和一个值x，将它划分为所有小于x的节点出现在大于或等于x的节点之前。
 * 解题思路：
 * 遍历一遍链表，把小于x的都挂到head1后，把大于等于x的都放到head2后，最后再把大于等于的链表挂到小于链表的后面就可以了
 */
import java.util.Scanner;
public class PartitionList {
	public static void main(String[] args) {
		System.out.println("请输入链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] st=s.split(" ");
		ListNode15 head=new ListNode15(Integer.parseInt(st[0]));
		ListNode15 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode15(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		System.out.println("请输入数字：");
		int x=sc.nextInt();
		Solution96 sl=new Solution96();
		ListNode15 result=sl.partition(head, x);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
}
class ListNode15
{
	int val;
	ListNode15 next;
	ListNode15(int x){val=x;}
}
class Solution96
{
	public ListNode15 partition(ListNode15 head,int x)
	{
		if(head==null) return null;
		
		//定义两个指针：head1和head2,小于x的都放到head1后面，大于x的都放到head2后面
		ListNode15 head1=new ListNode15(0);
		ListNode15 head2=new ListNode15(0);
		ListNode15 temp1=head1;
		ListNode15 temp2=head2;
		//定义现指针指的位置
		ListNode15 cur=head;
		
		while(cur!=null)
		{
			ListNode15 cur_next=cur.next;
			if(cur.val<x)
			{
				temp1.next=cur;
				temp1=temp1.next;
				temp1.next=null;
			}else
			{
				temp2.next=cur;
				temp2=temp2.next;
				temp2.next=null;
			}
			cur=cur_next;
		}
		//将temp1和temp2连接
		temp1.next=head2.next;
		return head1.next;
	}
}