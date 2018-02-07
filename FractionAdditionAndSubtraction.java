/**
 * 题目：给定一个字符串，是一个分数的加减法形式，求分数加减的结果，并用字符串的形式表示出来。
 * 例如：
 * Input:"-1/2+1/2" Output: "0/1"
 * 解题思路：
 * Scanner.useDelimiter(String pattern):使用pattern做分割
 */
import java.util.Scanner;
public class FractionAdditionAndSubtraction {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String expression=sc.nextLine();
		
		Solution254 sl=new Solution254();
		System.out.println("结果是："+sl.fractionAddition(expression));

	}
}
class Solution254
{
	public String fractionAddition(String expression)
	{
		Scanner sc1=new Scanner(expression).useDelimiter("/|(?=[-+])");
		//A代表分子，B代表分母
		int A=0,B=1;
		while(sc1.hasNext())
		{
			//一个分数一个分数的加
			int a=sc1.nextInt();
			int b=sc1.nextInt();
			//A/B+a/b=(Ab+Ba)/Bb
			A=A*b+B*a;
			B=B*b;
			int g=gcd(A,B);
			A/=g;
			B/=g;
		}
		return A+"/"+B;
	}
	//求最大公约数
	public int gcd(int a,int b)
	{
		//小的在前面
		return a==0? Math.abs(b):gcd(b%a,a);
	}
}