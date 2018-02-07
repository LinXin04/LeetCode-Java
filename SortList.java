/**
 * 题目：使用常数的空间复杂度和O(nlogn)的时间复杂度对链表进行排序
 * 解题思路：
 * 前面有道题是实现合并两个有序链表的例子。所以，这里我们也使用这个方法，那么剩下的工作就是寻找每步的中点
 */
import java.io.*;
public class SortList {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入链表：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String st[]=s.split(" ");
		ListNode19 head=new ListNode19(Integer.parseInt(st[0]));
		ListNode19 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode19(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		
		Solution101 sl=new Solution101();
		ListNode19 result=sl.sortList(head);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
}

class ListNode19
{
	int val;
	ListNode19 next;
	ListNode19(int x){val=x;}
}

class Solution101
{
	public ListNode19 sortList(ListNode19 head)
	{
		if(head==null || head.next==null) return head;
		//定义两个节点，first和mid
		ListNode19 first=head;
		ListNode19 mid=head;
		
		//寻找两个节点的位置
		while(mid.next!=null && mid.next.next!=null)
		{
			first=first.next;
			mid=mid.next.next;
		}
		
		ListNode19 head2=first.next;
		first.next=null;
		ListNode19 head1=head;
		//对前后两段进行排序
		head1=sortList(head1);
		head2=sortList(head2);
		
		//合并两段
		return mergerTwoLists(head1,head2);
	}
	public ListNode19 mergerTwoLists(ListNode19 l1,ListNode19 l2)
	{
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		ListNode19 result=new ListNode19(0);
		ListNode19 temp=result;
		result.next=l1;
		
		while(l1!=null && l2!=null)
		{
			if(l1.val<=l2.val) l1=l1.next;
			else
			{
				ListNode19 Next=l2.next;
				l2.next=temp.next;
				temp.next=l2;
				l2=Next;
			}
			temp=temp.next;
		}
		if(l2!=null)
		{
			temp.next=l2;
		}
		return result.next;
	}
}