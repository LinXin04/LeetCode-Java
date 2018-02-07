/**
 * 题目：给定两个链表，返回他们的相交节点。如果没有，则返回null
 * 例如：
 * A: a1 → a2
                                                ↘
                     c1 → c2 → c3
                                               ↗            
 * B: b1 → b2 → b3
 * 解题思路:
 * 查找两个链表的第一个公共节点，如果两个节点的尾节点相同，肯定存在公共节点
 * 方法： 长的链表开始多走 （h1的数量 - h2的数量）步，然后和短链表同步往下走，遇到的第一个相同的节点就是最早的公共节点
 */
import java.util.Scanner;
public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		System.out.println("请输入第一个链表：");
		Scanner sc=new Scanner(System.in);
		ListNode11 headA=null;
		while(true)
		{
			String s1=sc.nextLine();
			if(s1.equals("")) break;
			String []st1=s1.split(" ");
			headA=new ListNode11(Integer.parseInt(st1[0]));
			ListNode11 temp1=headA;
			for(int i=1;i<st1.length;i++)
			{
				temp1.next=new ListNode11(Integer.parseInt(st1[i]));
				temp1=temp1.next;
			}
		}
		
		System.out.println("请输入第二个链表：");
		ListNode11 headB=null;
		while(true)
		{
			String s2=sc.nextLine();
			if(s2.equals("")) break;
			String []st2=s2.split(" ");
			headB=new ListNode11(Integer.parseInt(st2[0]));
			ListNode11 temp2=headB;
			for(int i=1;i<st2.length;i++)
			{
				temp2.next=new ListNode11(Integer.parseInt(st2[i]));
				temp2=temp2.next;
			}
		}

		Solution89 sl=new Solution89();
		ListNode11 result=sl.getIntersectionNode(headA, headB);
		System.out.println("结果是："+result.val);		
	}

}
class ListNode11
{
	int val;
	ListNode11 next;
	public ListNode11(int x){val=x;}
}
class Solution89
{
	public ListNode11 getIntersectionNode(ListNode11 headA,ListNode11 headB)
	{
		if(headA==null || headB==null) return null;
		
		//得到两个链表的长度
		int LenA=getLength(headA);
		int LenB=getLength(headB);
		
		//得到长短链表的长度差，此时headA与headB指向相同的位置
		if(LenA>LenB)
		{
			for(int i=0;i<LenA-LenB;i++)
				headA=headA.next;
		}else
		{
			for(int i=0;i<LenB-LenA;i++)
				headB=headB.next;
		}
		//如果headA不为空，headB不为空，且两个值不相等，则一直寻找
		while(headA!=null && headB!=null && headA.val!=headB.val)
		{
			headA=headA.next;
			headB=headB.next;
		}
		if(headA==null) return headA;
		else if(headB==null) return headB;
		else return headA;
		
	}
	public int getLength(ListNode11 head)
	{
		if(head==null) return 0;
		int Length=0;
		while(head!=null)
		{
			Length++;
			head=head.next;
		}
		return Length;
	}
}