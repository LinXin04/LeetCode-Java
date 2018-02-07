/**
 * 题目：给定四个点的坐标，求解这四个点能否围成一个正方形。
 * 例如：
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * 解题思路：
 * 如果可以围成一个正方形，那么两个点之间的距离的大小只有2种。我们使用一个HashMap来存储。
 */
import java.util.HashMap;
public class ValidSquare {
	public static void main(String[] args) {
	

	}
}
class Solution255
{
	public boolean validSquare(int[] p1,int[] p2,int[] p3,int[] p4)
	{
		if(p1==null || p2==null ||p3==null ||p4==null) return false;
		
		int dis[]=new int[6];
		dis[0]=distance(p1,p2);
		dis[1]=distance(p1,p3);
		dis[2]=distance(p1,p4);
		dis[3]=distance(p2,p3);
		dis[4]=distance(p2,p4);
		dis[5]=distance(p3,p4);
	
		HashMap<Integer,Integer> result=new HashMap<Integer,Integer>(); 
		for(int i=0;i<6;i++)
		{
			if(dis[i]==0) return false;
			if(!result.containsKey(dis[i]))
				result.put(dis[i], 1);
			else
				result.put(dis[i], result.get(dis[i])+1);
		}
		
		if(result.size()==2) return true;
		else return false;
		
	}
	public int distance(int[] p1,int[] p2)
	{
		return (int) ( Math.pow(p1[0]-p2[0], 2)+Math.pow(p1[1]-p2[1], 2));
	}
}