/**
 * 题目：给定一个链表和数字k,旋转前k个节点。
 * 例如：
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 解题思路：
 * 为了反转这个单链表，我们先让头结点的next域指向结点2，再让结点1的next域指向结点3，最后将结点2的next域指向结点1，就完成了第一次交换，顺序就变成了Header-结点2-结点1-结点3-结点4-NULL，
 * 然后进行相同的交换将结点3移动到结点2的前面，
 * 然后再将结点4移动到结点3的前面就完成了反转。
 *
 */
import java.util.Scanner;
public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		System.out.println("请输入链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] st=s.split(" ");
		ListNode07 head=new ListNode07(Integer.parseInt(st[0]));
		ListNode07 temp=head;
		for(int i=1;i<st.length;i++)	
		{
			temp.next=new ListNode07(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		
		System.out.println("请输入数字K：");
		int k=sc.nextInt();
		Solution85 sl=new Solution85();
		ListNode07 result=sl.reverseKGroup(head, k);
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
}
class ListNode07
{
	int val;
	ListNode07 next;
	public ListNode07(int x) {val=x;}
}

class Solution85
{
	public ListNode07 reverseKGroup(ListNode07 head,int k)
	{
		if(head==null || head.next==null) return head;
		
		ListNode07 result=new ListNode07(0);
		result.next=head;
		ListNode07 root=result;
		
		//首先统计该链表的长度
		ListNode07 temp=head;
		int Length=0;
		while(temp!=null)
		{
			Length++;
			temp=temp.next;
		}
		
		while(k<=Length)
		{
		for(int i=0;i<k-1;i++)
		{
			ListNode07 node=root.next;
			root.next=head.next;
			head.next=root.next.next;
			root.next.next=node;
		}
		root=head;
		head=head.next;
		Length-=k;
		}
		return result.next;
	}
}