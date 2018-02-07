/**
 * 题目：括号的生成。给定一个整数n，求n个左括号和n个右括号可以组成多少种有效的括号，并输出。
 * 例如：
 * [
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
 * ]
 * 解题思路：
 * 使用递归的方式
 * 定义left和right分别代表左边括号剩余的数量和右边括号剩余的数量。
 * 注意的是：left<0,right<0或者left>right时，为错误的。
 * left=right=0时是正确的。
 */
import java.util.Scanner;
import java.util.ArrayList;
public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println("请输入整数n:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		Solution210 sl=new Solution210();
		ArrayList<String> result=sl.generateParenthesis(n);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
	}

}
class Solution210
{
	public ArrayList<String> generateParenthesis(int n)
	{
		ArrayList<String> result=new ArrayList<String>();
		if(n<=0) return result;
		
		helper(n,n,"",result);
		return result;
		
	}
	public void helper(int left,int right,String temp,ArrayList<String> result)
	{
		//注意以下3种情况
		if(left<0 || right<0 || left>right) return;
		//如果left=right=0,则符合要求
		if(left==0 && right==0)
		{
			result.add(temp);
			return;
		}
		helper(left-1,right,temp+"(",result);
		helper(left,right-1,temp+")",result);
	}
}