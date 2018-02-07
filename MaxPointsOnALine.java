/**
 * 题目：给定n个点，寻找在一条直线上的最大的点数。（可能会有重复的元素）
 * 解题思路：n个点总共构成n*(n-1)/2条直线，然后对每条直线看看是有多少点在直线上，记录下最大的那个，最后返回结果。
 * 而判断一个点p_k在p_i, p_j构成的直线上的条件是(p_k.y-p_i.y)*(p_j.x-p_i.x)==(p_j.y-p_i.y)*(p_k.x-p_i.x)。
 * 算法总共是三层循环，时间复杂度是O(n^3),空间复杂度则是O(1),因为不需要额外空间做存储。
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class MaxPointsOnALine {

	public static void main(String[] args) {
		System.out.println("请输入若干个点：");
		Scanner sc=new Scanner(System.in);
		ArrayList<Point> po=new ArrayList<Point>();
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals("")) break;
			String st[]=s.split(",");
			Point p=new Point(Integer.parseInt(st[0]),Integer.parseInt(st[1]));
			po.add(p);
		}
		
		Point []points=new Point[po.size()];
		for(int i=0;i<po.size();i++)
		{
			points[i]=po.get(i);
		}
		Solution42 sl=new Solution42();
		int result=sl.maxPoints(points);
		System.out.println("结果是："+result);
	}
}
class Point
{
	int x;
	int y;
	Point(){x=0;y=0;}
	Point(int a,int b){x=a;y=b;}
}
class Solution42
{
	public int maxPoints(Point[] points)
	{
		int result=0;
		if(points==null) return result;
		int Length=points.length;
		if(Length<=2) return Length;
		
		//如果所有的点都相同，则区别对待
		if(AllSame(points)) return Length;
		//进入三层循环
		for(int i=0;i<Length-1;i++)
		{
			for(int j=i+1;j<Length;j++)
			{
				//如果i与j是同一个点，则跳出当前的j层循环，寻找下一个与其相对应的点
				if(points[i].x==points[j].x && points[i].y==points[j].y)
					continue;
				//否则的话当前的节点数是2个了（i和j）
				int curNum=2;
				//寻找第三个点
				for(int k=0;k<Length;k++)
				{
					//k\i\j不是一点的基础上，如果在一条直线上,即i与j组成的斜率与i与k组成的斜率相等
					//注意：这个地方必须转成long型，不然的话会出错。因为两个整型相乘可能会越界
					if(k!=i && k!=j && (long)(points[i].y-points[j].y)*(long)(points[i].x-points[k].x)==(long)(points[i].x-points[j].x)*(long)(points[i].y-points[k].y))
						curNum++;
				}
				result=Math.max(result, curNum);
			}
		}
		return result;
	}
	//一个判断所有的点是不是相同的函数
	public boolean AllSame(Point []points)
	{
		for(int i=1;i<points.length;i++)
		{
			if(points[0].x!=points[i].x || points[0].y!=points[i].y)
				return false;
		}
		return true;
	}
}