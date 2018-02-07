/**
 * 给定一个整数，输出它反转后的整数，若反转后该数越界了，则返回0
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 解题思路：简单的操作数据的题，注意细节即可
 */
import java.util.Scanner;
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println("请输入一个整数：");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		
		Solution31 sl=new Solution31();
		int result=sl.reverse(num);
		System.out.println("结果是："+result);

	}
}

class Solution31
{
	public int reverse(int x)
	{
		if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE) return 0;

		//注意，为了防止后边得到的result溢出，我们需要使用long型，不然会产生错误
		long result=0;
		while(x!=0)
		{
			result=result*10+x%10;
			x=x/10;
		}
		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) 
			return 0;
		return (int)result;
		
	}
	
}