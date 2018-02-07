/**
 * 题目：链表的翻转
 * 解题思路：将第2个指向第1个，将第3个指向第2个.....
 *
 */
import java.util.Scanner;
public class ReverseLinkedList {

	public static void main(String[] args) {
		System.out.println("请输入链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		ListNode16 head=new ListNode16(Integer.parseInt(st[0]));
		ListNode16 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode16(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		Solution97 sl=new Solution97();
		ListNode16 result=sl.reverseList(head);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}

	}

}

class ListNode16
{
	int val;
	ListNode16 next;
	ListNode16(int x){val=x;}
}
class Solution97
{
	public ListNode16 reverseList(ListNode16 head)
	{
		if(head==null || head.next==null) return head;
		
		//创建一个虚拟的头结点
		ListNode16 dummy=new ListNode16(-1);
		dummy.next=head;
		ListNode16 cur=head;
		while(cur.next!=null)
		{
			ListNode16 Next=cur.next;
			cur.next=Next.next;
			Next.next=dummy.next;
			dummy.next=Next;
		}
		return dummy.next;
	}
}