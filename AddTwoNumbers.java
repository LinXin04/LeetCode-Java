/**
 * 题目：给定两个链表，每个链表中存放一个整数（按照倒序排列），求两个整数相加的和，返回一个链表
 * 例如：
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 解题思路：
 * 1.如果两个中有一个为null,直接返回；
 * 2.如果两个都不为空，则对于每两位相加求余数和进位，一直到两个链表中有一个已到达表尾。
 * 3.如果一个已经到达表的尾部，则另一个继续循环一直到达自己的表尾。
 * 4.最后要判断一下最后一个进位是否还存在，若存在，则需要加结果集中
 *
 */
import java.io.*;
import java.util.ArrayList;
public class AddTwoNumbers {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		System.out.println("请输入链表1：");
		ArrayList<Integer> temp1=new ArrayList<Integer>();
		while(true)
		{
			String s=buf.readLine();
			if(s.equals("")) break;
			String []st=s.split(" ");
			for(int i=0;i<st.length;i++)
				temp1.add(Integer.parseInt(st[i]));
		}
		ListNode []nums1=new ListNode[temp1.size()];
		for(int i=0;i<temp1.size();i++)
			nums1[i]=new ListNode(temp1.get(i));
		
		ListNode l1=nums1[0];
		ListNode pre1=nums1[0];
		for(int i=1;i<temp1.size();i++)
		{
			pre1.next=nums1[i];
			pre1=nums1[i];
		}
		
		System.out.println("请输入链表2：");
		ArrayList<Integer> temp2=new ArrayList<Integer>();
		while(true)
		{
			String s=buf.readLine();
			if(s.equals("")) break;
			String []st=s.split(" ");
			for(int i=0;i<st.length;i++)
				temp2.add(Integer.parseInt(st[i]));
		}
		ListNode []nums2=new ListNode[temp2.size()];
		for(int i=0;i<temp2.size();i++)
			nums2[i]=new ListNode(temp2.get(i));
		
		ListNode l2=nums2[0];
		ListNode pre2=nums2[0];
		for(int i=1;i<temp2.size();i++)
		{
			pre2.next=nums2[i];
			pre2=nums2[i];
		}
		
		Solution80 sl=new Solution80();
		ListNode head=sl.addTwoNumbers(l1, l2);
		ListNode pre=head;
		System.out.println("结果是：");
		while(pre!=null)
		{
			System.out.print(pre.val+" ");
			pre=pre.next;
		}

	}
}

class ListNode
{
	int val;
	ListNode next;
	ListNode(int x) {val=x;}
}

class Solution80
{
	public ListNode addTwoNumbers(ListNode l1,ListNode l2)
	{
		//首先处理一个为空的情况
		if(l1==null) return l2;
		else if(l2==null) return l1;
		
		//余数
		int dig=0;
		//进位
		int carry=0;
		
		//结果表的表头
		ListNode head=null;
		//随着位数一步步移动的节点
		ListNode pre=null;
		
		while(l1!=null && l2!=null)
		{
			dig=(l1.val+l2.val+carry)%10;
			carry=(l1.val+l2.val+carry)/10;
			//创建一个新的节点
			ListNode newNode=new ListNode(dig);
			if(head==null)
				head=newNode;
			else
				pre.next=newNode;
			pre=newNode;
			l1=l1.next;
			l2=l2.next;
		}
		
		while(l1!=null)
		{
			dig=(l1.val+carry)%10;
			carry=(l1.val+carry)/10;
			ListNode newNode=new ListNode(dig);
			pre.next=newNode;
			pre=newNode;
			l1=l1.next;
		}
		while(l2!=null)
		{
			dig=(l2.val+carry)%10;
			carry=(l2.val+carry)/10;
			ListNode newNode=new ListNode(dig);
			pre.next=newNode;
			pre=newNode;
			l2=l2.next;
		}
		//最后判断是否还有进位
		if(carry>0)
		{
			ListNode newNode=new ListNode(carry);
			pre.next=newNode;
		}
		return head;
	}
}