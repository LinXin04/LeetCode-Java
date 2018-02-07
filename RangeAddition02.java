/**
 * 题目：给定一个m*n的矩阵，初始化为0，然后执行更新操作。
 * 数组ops表示一组更新操作，每一个操作(a,b)，表示将矩阵0<=i<a并且0<=j<b的区域+1；
 * 进行若干次操作后，求矩阵中的最大值。
 * 解题思路：
 * 把这个题目转化成图形来理解，最大的值的区域就是所有operation的交集。
 * 如何找到这个区域呢，我们需要记录一个min x 和min y 来求出交集的区域 = x*y， 相当于在求面积。
 */
public class RangeAddition02 {
	public static void main(String[] args) {
		
	}
}
class Solution256
{
	public int maxCount(int m,int n,int[][] ops)
	{
		if(ops==null || ops.length==0)
			return m*n;
		
		int x=Integer.MAX_VALUE;
		int y=Integer.MAX_VALUE;
		
		//对ops一行一行的遍历
		for(int i=0;i<ops.length;i++)
		{
			if(ops[i][0]<x)
				x=ops[i][0];
			if(ops[i][1]<y)
				y=ops[i][1];
		}
		return x*y;
	}
}