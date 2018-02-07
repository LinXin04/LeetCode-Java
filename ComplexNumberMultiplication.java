/**
 * 题目：复数相乘（包含实部和虚部）。
 * 例如：
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * 解题思路：
 * 正常按照乘法规则去求解法
 */
import java.util.Scanner;
public class ComplexNumberMultiplication {
	public static void main(String[] args) {
		System.out.println("请输入字符串a:");
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		System.out.println("请输入字符串b:");
		String b=sc.nextLine();

		Solution246 sl=new Solution246();
		System.out.println("结果是："+sl.complexNumberMultiply(a, b));
	}
}
class Solution246
{
	public String complexNumberMultiply(String a,String b)
	{
		if(a==null && b==null) return null;
		String result="";
		if(a.length()<=0 && b.length()<=0) return result;
		
		int alen=a.length();
		int blen=b.length();
		//分离实部和虚部,注意转义符
		String []A=a.split("\\+");
		String []B=b.split("\\+");
		
		int A1=Integer.parseInt(A[0]);
		int A2=Integer.parseInt(A[1].replace("i",""));
		
		int B1=Integer.parseInt(B[0]);
		int B2=Integer.parseInt(B[1].replace("i", ""));
		
		int r1=A1*B1-A2*B2;
		int r2=A1*B2+A2*B1;
		
		result=String.valueOf(r1)+"+"+String.valueOf(r2)+"i";
		return result;
	}
}
