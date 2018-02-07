/**
 * 题目：两两交换链表中的元素。给定一个链表，每两个节点交换一下位置。
 * 例如：
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 解题思路：
 * 就是每次跳两个节点，后一个接到前面，前一个接到后一个的后面，最后现在的后一个（也就是原来的前一个）接到下下个结点（如果没有则接到下一个）。
 *
 */
import java.util.Scanner;
public class SwapNodesInPairs {

	public static void main(String[] args) {
		System.out.println("请输入链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] st=s.split(" ");
		ListNode06 head=new ListNode06(Integer.parseInt(st[0]));
		ListNode06 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode06(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		Solution84 sl=new Solution84();
		ListNode06 result=sl.swapPairs(head);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
}

class ListNode06
{
	int val;
	ListNode06 next;
	ListNode06(int x) {val=x;}
}

class Solution84
{
	public ListNode06 swapPairs(ListNode06 head)
	{
		if(head==null || head.next==null) return head;
		
		ListNode06 result=new ListNode06(0);
		result.next=head;
		ListNode06 pre=result;
		ListNode06 cur=head;
		
		while(cur!=null && cur.next!=null)
		{
			//先将第三个节点保存下来
			ListNode06 third=cur.next.next;
			cur.next.next=cur;
			pre.next=cur.next;
			
			//如果第三个第四个点存在，那么我们将cur的next指向第四个
			if(third!=null && third.next!=null)
				cur.next=third.next;
			else
				cur.next=third;
			pre=cur;
			cur=third;
		}
		return result.next;
	}
}