/**
 * 题目：求得直方图中的最大面积
 * 解题思路：利用栈的思想：
 * 利用一个栈存储直方图的高度。如果高度比当前的栈顶的元素大,那么就压入栈中;如果小于栈顶元素,那么就弹出元素计算矩形面积.
 *
 */
import java.util.Scanner;
import java.util.Stack;
public class LargesetRectangleinHistogram {

	public static void main(String[] args) {
		
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution27 sl=new Solution27();
		int result=sl.largestRectangleArea(nums);
		System.out.println("结果是："+result);
	}

}

class Solution27
{
	public int largestRectangleArea(int[] heights)
	{
		int result=0;
		int Length=heights.length;
		if(Length==0) return 0;
		if(Length==1) return heights[0];
		
		//定义一个栈，用于存储高度
		Stack<Integer> st=new Stack<Integer>();
		
		//循环整个数组
		for(int i=0;i<Length;i++)
		{
			//如果当前栈是空栈或者当前的高度大于栈顶的元素，那么我们毫不犹豫将当前的高度压入栈内
			if(st.isEmpty() || heights[i]>=st.peek())
			{
				st.push(heights[i]);
			}else if(heights[i]<st.peek())
			{
				//定义一个count记录出栈元素的个数
				int count=0;
				//否则的话，我们就让栈顶元素出栈，直到当前的高度大于栈顶元素或者栈为空是为止
				while(!st.isEmpty() && heights[i]<st.peek())
				{
					count++;
					//更新结果
					result=Math.max(result,st.peek()*count);
					//将栈顶元素出栈
					st.pop();
				}
				//将出栈的元素以及当前的元素用当前的高度补上
				while(count>=0)
				{
					st.push(heights[i]);
					count--;
				}
			}
		}
		//完成了栈的排序，更新最终的结果
		int wide=1;
		while(!st.isEmpty())
		{
			result=Math.max(result,st.peek()*wide);
			st.pop();
			wide++;
		}
		return result;
	}	
}