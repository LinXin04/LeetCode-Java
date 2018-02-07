/**
 * 题目：给定一个表达式字符串，通过加括号得到所有可能的结果。
 * 例如：
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 解题思路：
 * 用分治的方法。
 * 遍历字符串如果遇到+-*，就将左边的表达式与右边的表达式分开计算，然后根据这个char是+-*，将结果进行合并
 *
 */
import java.util.Scanner;
import java.util.ArrayList;
public class DifferentWaysToAddParentheses {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		
		Solution258 sl=new Solution258();
		ArrayList<Integer> result=sl.diffWaysToCompute(input);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i));
	}
}
class Solution258
{
	public ArrayList<Integer> diffWaysToCompute(String input)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(input==null || input.length()==0) return result;
		
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			if(ch=='+'||ch=='-'||ch=='*')
			{
				ArrayList<Integer> left=diffWaysToCompute(input.substring(0, i));
				ArrayList<Integer> right=diffWaysToCompute(input.substring(i+1));
				
				for(int x:left)
				{
					for(int y:right)
					{
						switch (ch)
						{
							case '+':
								result.add(x+y);
								break;
							case '-':
								result.add(x-y);
								break;
							case '*':
								result.add(x*y);
								break;
							default:
								break;
						}
					}
				}
			}
		}
		//如果从没有遇到过+-*
		if(result.size()==0)
			result.add(Integer.parseInt(input));
		return result;
	}
}
