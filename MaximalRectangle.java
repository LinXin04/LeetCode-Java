/**
 * 题目：给定一个二维数组，数组中的元素为0或者1，求该数组中由1围成的最大的矩阵的面积。
 * 例如：
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 返回6
 * 解题思路：这个题目可以参考Largest Rectangle in Histogram
 * 我们可以这样思考：将这个矩阵横着切，那么自底面向上的矩阵就可以看作一个直方图，直方图的高度就是最底面向上的1的数量。
 * 而每一行一列的高度，我们可以根据上一行的高度来计算得到。如果本行的元素是0，则高度变为0；如果本行的元素是1，则高度+1
 */ 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class MaximalRectangle {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		//声明一个存储char的二维List
		ArrayList<ArrayList<Character>> nums1=new ArrayList<ArrayList<Character>>();
		
		int row=0;
		while(true)
		{
		String s =sc.nextLine();
		if(s.equals("")) break;
		String st[]=s.split(" ");
		
		ArrayList<Character> emp=new ArrayList<Character>();
		for(int i=0;i<st.length;i++)
			emp.add(st[i].charAt(0));
		nums1.add(emp);
		}
		char nums[][]=new char[nums1.size()][nums1.get(0).size()];
		for(int i=0;i<nums1.size();i++)
		{
			for(int j=0;j<nums1.get(i).size();j++)
				nums[i][j]=nums1.get(i).get(j);
		}
		Solution28 sl=new Solution28();
		int result=sl.maximalRectangle(nums);
		System.out.println("结果是："+result);

}
}

class Solution28 {
    public int maximalRectangle(char[][] matrix) {
        
		int result=0;
		//行数
		int Row=matrix.length;
		if(matrix==null||Row==0||matrix[0].length==0) return 0;
		//定义存储直方图高度的数组
		int heights[]=new int[matrix[0].length];
		//遍历每一行
		for(int i=0;i<Row;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				//定义第i行第j列的高度
				heights[j]=matrix[i][j]=='0'? 0:heights[j]+1;
			}
			result=Math.max(result, largestRectangleArea(heights));
		}
		return result;
	}
	//寻找直方图最大面积的函数
	public int largestRectangleArea(int []nums)
	{
		int result=0;
		int Length=nums.length;
		if(Length==0) return result;
		if(Length==1) return nums[0];
		
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<Length;i++)
		{
			if(st.isEmpty()||nums[i]>=st.peek())
			{
				st.push(nums[i]);
			}else if(nums[i]<st.peek())
			{
				int count=0;
				while(!st.isEmpty() && nums[i]<st.peek())
				{
					count++;
					result=Math.max(result,st.peek()*count);
					st.pop();
				}
				while(count>=0)
				{
					st.push(nums[i]);
					count--;
				}
			}
        }
			int wide=1;
			while(!st.isEmpty())
			{
				result=Math.max(result,st.peek()*wide);
				wide++;
				st.pop();
			}
		return result;
	}
}