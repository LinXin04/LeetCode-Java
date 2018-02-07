/**
 * 题目：超级次方。给定一个整数a和一个数组b，求a^b%1337.
 * 解题思路：
 * 这道题目如果按照普通思路，先求a^b,再求%1337的话，会出错，越界。
 * 以下规则可使用：
 * 1、x^y%1337=(x%1337)^y%1337
 * 2、xy%1337=((x%1337)*(y%1337))%1337
 * 3、x^678=(x^670%1337)*(x^8%1337)%1337
 */
import java.util.Scanner;
public class SuperPow {
	public static void main(String[] args) {
		System.out.println("请输入一个整数a：");
		Scanner sc=new Scanner(System.in);
		int a=Integer.parseInt(sc.nextLine());
		
		System.out.println("请输入数组b:");
		String s=sc.nextLine();
		String []st=s.split(" ");
		int[] b=new int[st.length];
		for(int i=0;i<st.length;i++)
			b[i]=Integer.parseInt(st[i]);
		
		Solution179 sl=new Solution179();
		System.out.println("结果是："+sl.superPow(a, b));
	}
}
class Solution179
{
	public int superPow(int a,int[] b)
	{
		if(b.length==0) return 0;
		int result=1;
		for(int i=0;i<b.length;i++)
			result=pow(result,10)*pow(a,b[i])%1337;
		return result;
	}
	public int pow(int x,int n)
	{
		if(n==0) return 1;
		if(n==1) return x%1337;
		return pow(x%1337,n/2)*pow(x%1337,n-n/2)%1337;
	}
}