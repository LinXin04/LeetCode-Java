/**
 * 题目：给定两个字符串：num1和num2，求num1+num2的值。num1和num2前缀中都没有连续的0
 * 解题思路：
 * 一位一位的处理，遇到进位就保留，在下一位的计算中加上进位。
 */
import java.util.Scanner;
public class AddStrings {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入num1:");
		String num1=sc.nextLine();
		
		System.out.println("请输入num2:");
		String num2=sc.nextLine();
		
		Solution183 sl=new Solution183();
		System.out.println("结果是："+sl.addStrings(num1, num2));
	}
}

class Solution183
{
	public String addStrings(String num1,String num2)
	{
		if(num1.length()==0) return num2;
		if(num2.length()==0) return num1;
		
		String result="";
		
		int n=num1.length(),m=num2.length(),i=n-1,j=m-1,carry=0;
		
		while(i>=0 || j>=0)
		{
			//a为num1的最低位,b为num2的最低位
			//字符到数字-'0'
			int a=i>=0? num1.charAt(i--)-'0':0;
			int b=j>=0? num2.charAt(j--)-'0':0;
			
			int sum=a+b+carry;
			result=sum%10+result;
			carry=sum/10;
		}
		
		if(carry!=0) return String.valueOf(carry)+result;
		else return result;
	} 
}