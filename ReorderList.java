/**
 * 题目：给定一个链表，求它对应的重排序
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * 例如：
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 解题思路：
 * 1.将链表切成两半，也就是找到中点，然后截成两条链表；
 * 2.将后面一条链表进行reverse操作，就是反转过来；
 * 3.将两条链表按顺序依次merge起来,此处不需要比较大小，只需要左边取一个右边取一个即可。
 */
import java.io.*;
public class ReorderList {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入链表：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String st[]=s.split(" ");
		ListNode20 head=new ListNode20(Integer.parseInt(st[0]));
		ListNode20 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode20(Integer.parseInt(st[i]));
			temp=temp.next;
		}

		Solution102 sl=new Solution102();
		sl.reorderList(head);
		System.out.println("结果是：");
		while(head!=null)
		{
			System.out.print(head.val+" ");
			head=head.next;
		}
	}

}
class ListNode20
{
	int val;
	ListNode20 next;
	ListNode20(int x){val=x;}
}
class Solution102
{
	public void reorderList(ListNode20 head)
	{
		if(head==null) return;
		
		//1.将链表切成两半，也就是找到中点，然后截成两条链表；
		ListNode20 first=head;
		ListNode20 mid=head;
		
		while(mid.next!=null && mid.next.next!=null)
		{
			first=first.next;
			mid=mid.next.next;
		}
		ListNode20 head2=first.next;
		first.next=null;
		ListNode20 head1=head;
		
		//2.将后面一条链表进行reverse操作，就是反转过来；
		head2=reverse(head2);
		//3.将两条链表按顺序依次merge起来,此处不需要比较大小，只需要左边取一个右边取一个即可。
		while(head1!=null && head2!=null)
		{
			ListNode20 Next=head2.next;
			head2.next=head1.next;
			head1.next=head2;
			head1=head2.next;
			head2=Next;
		}
		
	}
	public ListNode20 reverse(ListNode20 head)
	{
		ListNode20 pre=null;
		ListNode20 cur=head;
		while(cur!=null)
		{
			ListNode20 temp=cur.next;
			cur.next=pre;
			pre=cur;
			cur=temp;
		}
		return pre;
	}
}