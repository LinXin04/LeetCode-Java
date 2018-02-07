/**
 * 题目：最小的时间差。给定一系列24进制表示的时间，完全无序的，求最小的时间差。
 * 例如：
 * Input: ["23:59","00:00"]
 * Output: 1
 * 解题思路：
 * 先进行排序，最小的时间差肯定出现在两个相邻的字符串中。
 * 注意一条：第一个时间点与最后一个时间点进行比较时，第一个时间点需要加上24小时再做差值
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class MinimumTimeDifference {
	public static void main(String[] args) {
		System.out.println("请输入字符串数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		ArrayList<String> timepoints=new ArrayList<String>();
		for(int i=0;i<st.length;i++)
			timepoints.add(st[i]);
		
		Solution245 sl=new Solution245();
		System.out.println("结果是："+sl.findMinDifference(timepoints));
	}
}
class Solution245
{
	public int findMinDifference(ArrayList<String> timePoints)
	{
		if(timePoints==null || timePoints.size()<=0) return 0;
		int n=timePoints.size();
		int result=Integer.MAX_VALUE;
		Collections.sort(timePoints);
		int h1=0,m1=0,h2=0,m2=0,diff=0;
		
		for(int i=0;i<n;i++)
		{
			h1=(timePoints.get(i).charAt(0)-'0')*10+(timePoints.get(i).charAt(1)-'0');
			m1=(timePoints.get(i).charAt(3)-'0')*10+(timePoints.get(i).charAt(4)-'0');
			
			h2=(timePoints.get((i+1)%n).charAt(0)-'0')*10+(timePoints.get((i+1)%n).charAt(1)-'0');
			m2=(timePoints.get((i+1)%n).charAt(3)-'0')*10+(timePoints.get((i+1)%n).charAt(4)-'0');
			
			diff=(h2*60+m2)-(h1*60+m1);
			if(i==n-1) diff+=24*60;
			result=Math.min(result,diff);
		}
		return result;
	}
}