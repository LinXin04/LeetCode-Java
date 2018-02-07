/**
 * 题目：对给定的一个链表进行插入排序
 * 题目解析：
 * 插入排序是一种O(n^2)复杂度的算法
 * 基本想法，就是每次循环找到一个元素在当前排好的结果中相对应的位置，然后插进去，经过n次迭代之后就得到排好序的结果了。
 *
 */
import java.io.*;
public class InsertionSortList {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入链表：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String st[]=s.split(" ");
		ListNode18 head=new ListNode18(Integer.parseInt(st[0]));
		ListNode18 temp=head;
		for(int i=1;i<st.length;i++)
		{
			temp.next=new ListNode18(Integer.parseInt(st[i]));
			temp=temp.next;
		}
		
		Solution100 sl=new Solution100();
		ListNode18 result=sl.insertionSortList(head);
		System.out.println("结果是：");
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
}

class ListNode18
{
	int val;
	ListNode18 next;
	ListNode18(int x) {val=x;}
}

class Solution100
{
	public ListNode18 insertionSortList(ListNode18 head)
	{
		if(head==null || head.next==null) return head;
		
		//创建一个辅助头结点
		ListNode18 helper=new ListNode18(-1);
		ListNode18 pre=helper;
		ListNode18 cur=head;
		while(cur!=null)
		{
			ListNode18 Next=cur.next;
			pre=helper;
			//在前面已排好序的字段中，寻找要插入的位置。
			while(pre.next!=null && pre.next.val<=cur.val)
				pre=pre.next;
			//在pre之后插入
			cur.next=pre.next;
			pre.next=cur;
			cur=Next;
		}
		return helper.next;
	}
}