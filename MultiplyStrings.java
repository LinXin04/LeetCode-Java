/**
 * 
 * @author LX
 * 题目：给定两个由非负整数组成的字符串，求得他们的乘积
 * 解题思路：m和n位数的乘积，最终结果为m+n-1位或是m+n位(进位时)。
 * 乘法计算中可以发现，结果中第i位，应该由第一个字符串中的第1位乘以第二个字符串中的第i位，
 * 第一个字符串中的第2位乘以第二个字符串中的第i-1位，.......
 * 第一个字符串中的第i位乘以第二个字符串中的第1位,
 * 最后累加求得，最后我们取个位上的数值，然后剩下的作为进位放到下一轮循环中
 *
 */
import java.util.Scanner;
public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println("请输入字符串1：");
		Scanner sc=new Scanner(System.in);
		String num1=sc.nextLine();
		System.out.println("请输入字符串2：");
		String num2=sc.nextLine();
		
		Solution35 sl=new Solution35();
		String result=sl.multiply(num1, num2);
		System.out.println("结果是："+result);

	}

}
class Solution35
{
	public String multiply(String num1,String num2)
	{
		//创建一个StringBuilder,它的长度是可变的，动态的
		StringBuilder result=new StringBuilder();
		if(num1==null||num2==null)
			return "";
		if(num1.charAt(0)=='0'||num2.charAt(0)=='0')
			return "0";
		int m=num1.length();
		int n=num2.length();
		
		//首先将num1和num2进行反转，下文才可以从低位开始运算
		num1=new StringBuilder(num1).reverse().toString();
		num2=new StringBuilder(num2).reverse().toString();
		
		int jinwei=0;
		//从低位开始计算，最后乘积的位数为m+n-1,如果最后一步有进位，则为m+n
		for(int i=0;i<m+n-1;i++)
		{
			int multi=jinwei;
			for(int j=0;j<=i;j++)
			{
				if(j<m && (i-j)<n)
					multi+=(int)(num1.charAt(j)-'0')*(int)(num2.charAt(i-j)-'0');
			}
			result.append(multi%10);
			jinwei=multi/10;
		}
		//考虑最后一位是否有进位
		if(jinwei!=0)
			result.append(jinwei);
		//前面是从低位向高位排列的，最后要进行一下反转
		return result.reverse().toString();
	}
}