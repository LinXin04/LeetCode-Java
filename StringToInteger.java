/**
 * 题目：将字符串转换成整数
 * 1、首先需要丢弃字符串前面的空格；
 * 2、 然后可能有正负号（注意只取一个，如果有多个正负号，那么说这个字符串是无法转换的，返回0。比如测试用例里就有个“+-2”）；
 * 3、字符串可以包含0~9以外的字符，如果遇到非数字字符，那么只取该字符之前的部分，如“-00123a66”返回为“-123”；
 * 4、如果超出int的范围，返回边界值（2147483647或-2147483648）。
 *
 */
import java.util.*;
public class StringToInteger {

	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		
		Solution156 sl=new Solution156();
		System.out.println("结果是："+sl.myAtoi(str));
		
	}

}
class Solution156
{
	public int myAtoi(String str)
	{
		if(str==null || str.isEmpty()) return 0;
		double result=0;
		//1、丢弃字符串前面的空格；
		str=str.trim();
		
		//2、判断正负号
		boolean positive=true;
		int index=0;
		if(str.charAt(0)=='+') index++;
		if(str.charAt(0)=='-')
		{
			index++;
			positive=false;
		}
		
		//3、得到实际的数字
		for(int i=index;i<str.length();i++)
		{
			//如果是其他字符，则跳出循环
			if(str.charAt(i)<'0' || str.charAt(i)>'9') break;
			if(positive) result=10*result+(str.charAt(i)-'0');
			else result=10*result-(str.charAt(i)-'0');
			
		}
		
		if(result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if(result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		return (int) result;
	}
}