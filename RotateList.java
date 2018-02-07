/**
 * 题目：在倒数第k个位置，将链表反转。
 * 例如：
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 解题思路：
 * 首先将k进行求余
 * 用两个指针fast和slow，fast走到末尾时，slow的下一个位置是新的顺序的头结点，这样就可以旋转链表了
 *
 */
import java.util.Scanner;
public class RotateList {

	public static void main(String[] args) {
		System.out.println("请输入一个链表：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] st=s.split(" ");
		ListNode08 head=new ListNode08(Integer.parseInt(st[0]));
		ListNode08 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode08(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		
		System.out.println("请输入一个整数：");
		int k=sc.nextInt();
		
		Solution86 sl=new Solution86();
		ListNode08 result=sl.rotateRight(head, k);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}

class ListNode08
{
	int val;
	ListNode08 next;
	ListNode08(int x){val=x;}
}
class Solution86
{
	public ListNode08 rotateRight(ListNode08 head,int k)
	{
		if(head==null || head.next==null || k==0) return head;
		
		//求链表的长度
		ListNode08 temp=head;
		int Length=0;
		while(temp!=null)
		{
			Length++;
			temp=temp.next;
		}
		
		//处理k
		k=k%Length;
		
		//定义一个fast，一个slow
		ListNode08 fast=head;
		ListNode08 slow=head;
		for(int i=0;i<k;i++)
			fast=fast.next;
		
		//将slow和fast定位到题目中要求的位置
		while(fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next;
		}
		
		//进行反转
		fast.next=head;
		head=slow.next;
		slow.next=null;
		return head;
	}
}