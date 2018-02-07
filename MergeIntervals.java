/**
 * 题目：合并区间，区间不一定是有序的。
 * 例如：
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 解题思路：首先对区间进行排序（使用接口comparator）；然后依次读入有序的区间，如果当前读入的区间与结果集中的最后一个区间有重叠，则把结果集中最后一个元素的end设为当前元素的结束点（不需要改变起始点，因为起始点有序）
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
public class MergeIntervals {

	public static void main(String[] args) {
		
		ArrayList<Interval1> intervals=new ArrayList<Interval1>();
		System.out.println("请输入区间：");
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals("")) break;
			String st[]=s.split(",");
			Interval1 inv=new Interval1();
			inv.start=Integer.parseInt(st[0]);
			inv.end=Integer.parseInt(st[1]);
			intervals.add(inv);
		}
		
		
		Solution33 sl=new Solution33();
		ArrayList<Interval1> result=sl.merge(intervals);
		
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
		{
			System.out.print("["+result.get(i).start+","+result.get(i).end+"]");
			System.out.println();
		}
	}
}
class Interval1
{
	int start;
	int end;
	Interval1() {start=0;end=0;}
	Interval1(int s,int e){start=s;end=e;}
}
class Solution33
{
	public ArrayList<Interval1> merge(ArrayList<Interval1> intervals)
	{
		ArrayList<Interval1> result=new ArrayList<Interval1>();
		int Length=intervals.size();
		if(intervals==null || Length==0) return result;
		if(Length==1) 
			{result.add(intervals.get(0)); return result;}
		
		//1.首先对区间集进行排序
		Comparator<Interval1> comp=new Comparator<Interval1>()
		{
			//实现接口中的compare函数
			public int compare(Interval1 i1,Interval1 i2)
			{
				if(i1.start==i2.start) return i1.end-i2.end;
				else return i1.start-i2.start;
			}
		};
		Collections.sort(intervals,comp);
		
		//2.遍历有序区间，进行合并
		//首先将第一个区间加入到res中
		result.add(intervals.get(0));
		//开始进行重叠检测
		for(int i=1;i<Length;i++)
		{
			//如果当前的区间的start小于或者等于res中最后一个元素的end，说明发生了重叠
			if(intervals.get(i).start<=result.get(result.size()-1).end)
			{
				result.get(result.size()-1).end=Math.max(result.get(result.size()-1).end, intervals.get(i).end);
			}
			//否则无冲突，将当前区间直接加入res
			else
			{
				result.add(intervals.get(i));
			}
		}
		return result;
	}
}