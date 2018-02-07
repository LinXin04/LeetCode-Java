/**
 * 题目：将k个有序链表合并成一个
 * 解题思路：
 * 在这里使用归并排序的解题思路。
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class MergeKSortedLists {

	public static void main(String[] args) {
		System.out.println("请输入链表集：");
		Scanner sc=new Scanner(System.in);
		ArrayList<ListNode05> lists=new ArrayList<ListNode05> ();
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals("")) break;
			String[] st=s.split(" ");
			ListNode05 temp=new ListNode05(Integer.parseInt(st[0]));
			ListNode05 head=temp;
			for(int i=1;i<st.length;i++)
			{
				head.next=new ListNode05(Integer.parseInt(st[i]));
				head=head.next;
			}
			lists.add(temp);
		}
		ListNode05[] ListSet=new ListNode05[lists.size()];
		for(int i=0;i<lists.size();i++)
		{
			ListSet[i]=lists.get(i);
		}
		
		Solution83 sl=new Solution83();
		ListNode05 result=sl.mergeKLists(ListSet);
		
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
}

class ListNode05
{
	int val;
	ListNode05 next;
	public ListNode05(int x){val=x;}
}

class Solution83
{
	public ListNode05 mergeKLists(ListNode05[] lists)
	{
		if(lists.length==0 || lists==null) return null;
		else return merge(lists,0,lists.length-1);
	}
	
	//定义合并排序的函数
	public ListNode05 merge(ListNode05[] lists,int start,int end)
	{
		if(start<end)
		{
			int mid=(start+end)/2;
			return MergeTwoSortedList(merge(lists,start,mid),merge(lists,mid+1,end));	
		}
		return lists[start];
	}
	
	//合并两个链表的函数
	public ListNode05 MergeTwoSortedList(ListNode05 l1,ListNode05 l2)
	{
		ListNode05 result=new ListNode05(0);
		ListNode05 pre=result;
		result.next=l1;
		
		while(l1!=null && l2!=null)
		{
			if(l1.val>l2.val)
			{
				ListNode05 next=l2.next;
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