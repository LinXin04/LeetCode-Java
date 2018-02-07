/**
 *  题目：给定一组区间，这些区间之间没有重叠，并且这些区间都是按照开始节点递增排序的。给定一组待插的区间，用于插入到原有的区间中，然后求出合并后的区间。
 *  例如：Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *  解题思路：从前向后进行扫描，一直到newinterval要插入的位置；
 *  接下来检查newinterval与后面的区间是否冲突，一直到newinterval的end小于下一个interval的start为止，然后取newinterval的end为最大 的那个；
 *  最后将剩余的区间加入。
 */
import java.util.ArrayList;
import java.util.Scanner;

public class InsertInterval {

	public static void main(String[] args) {
		System.out.println("请输入若干个区间：");
		Scanner sc1=new Scanner(System.in);
		ArrayList<Interval> intervals=new ArrayList<Interval>();
		while(true)
		{
		String s1=sc1.nextLine();
		if(s1.equals("")) break;
		String st1[]=s1.split(",");
		Interval il=new Interval(Integer.parseInt(st1[0]),Integer.parseInt(st1[1]));
		intervals.add(il);
		}
		
		Scanner sc2=new Scanner(System.in);
		System.out.println("请输入新插入的区间:");
		String s2=sc2.nextLine();
		String st2[]=s2.split(",");
		Interval newInterval=new Interval(Integer.parseInt(st2[0]),Integer.parseInt(st2[1]));
		
		Solution32 sl=new Solution32();
		ArrayList<Interval> result=sl.insert(intervals, newInterval);
		
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
		{
			System.out.print("["+result.get(i).start+","+result.get(i).end+"]");
			System.out.println();
		}
	}

}

class Interval
{
	int start;
	int end;
	Interval(){start=0;end=0;}
	Interval(int s,int e){start=s;end=e;}
	
}
class Solution32
{
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,Interval newInterval)
	{
		int Length=intervals.size();
		//声明结果
		ArrayList<Interval> result=new ArrayList<Interval>();
		//如果被插入的区间组长度为0的话，直接插入
		if(Length==0)
		{
			result.add(newInterval);
			return result;
		}
		//1.将前面不受newInterval影响的区间加入
		int i=0;
		while(i<Length && newInterval.start>intervals.get(i).end)
		{
			result.add(intervals.get(i));
			i++;
		}
		//2.将newInterval加入
		if(i<Length)
			//更新newInterval的start
			newInterval.start=Math.min(newInterval.start, intervals.get(i).start);
		result.add(newInterval);
		
		//3.消除冲突,更新newInterval的end
		while(i<Length && newInterval.end>=intervals.get(i).start)
		{
			newInterval.end=Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		
		//4.将剩余的区间加入
		while(i<Length)
		{
			result.add(intervals.get(i));
			i++;
		}
		return result;
	}
}