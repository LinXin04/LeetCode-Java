/**
 * 题目：给定两个字符串，返回他们的加和（二进制表示），加和也是字符串
 * 解题思路：
 * 1、首先，两个字符串的大小可能不同，我们则需要在较短的字符串前面加0，以使得两个字符串的长度相等。
 * 2、然后从两个字符串的末尾开始取字符，相加。
 * 结果有三种：=0：本位=0、进位=0；
 * =1：本位=1、进位=0；
 * =2：本位=0、进位=1；
 * =3：本位=1、进位=1
 *
 */
import java.util.*;
public class AddBinary {

	public static void main(String[] args) {
		System.out.println("请输入字符串a:");
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		System.out.println("请输入字符串b:");
		String b=sc.nextLine();
		
		Solution155 sl=new Solution155();
		System.out.println("结果是："+sl.addBinary(a, b));
		
	}
}
class Solution155
{
	public String addBinary(String a,String b)
	{
		String result="";
		if(a==null) return b;
		if(b==null) return a;
		
		//将短的字符串前面补0
		int Lena=a.length();
		int Lenb=b.length();
		
		if(Lena>Lenb){for(int i=0;i<Lena-Lenb;i++) b="0"+b;}
		if(Lena<Lenb){for(int i=0;i<Lenb-Lena;i++) a="0"+a;}
		
		//定义进位carry
		int Len=Math.max(Lena,Lenb);
		boolean carry=false;
		int cur=0;
		
		for(int i=Len-1;i>=0;i--)
		{
			
			if(carry)
				cur=(a.charAt(i)-'0')+(b.charAt(i)-'0')+1;
			else
				cur=(a.charAt(i)-'0')+(b.charAt(i)-'0');
			
			if(cur==0)
			{
				result="0"+result;
				carry=false;
			}
			else if(cur==1)
			{
				result="1"+result;
				carry=false;
			}
			else if(cur==2)
			{
				result="0"+result;
				carry=true;
			}
			else if(cur==3)
			{
				result="1"+result;
				carry=true;
			}
		}
		if(carry) result="1"+result;
		return result;
	}
}