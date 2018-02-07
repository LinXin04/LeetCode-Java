/**
 * 题目：给定一个字符串和一个整数，该字符串是按照整数为行数做的ZigZag变化，求原本的字符串。
 * 例如：
 * 给定字符串：PAYPALISHIRING和3，则其形式如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 返回原本的字符串：return PAHNAPLSIIGYIR
 * 解题思路：
 * 1.每个ZigZig的循环周期是2*m-2个字符（m是行数），即P与A之间相隔2*m-2个字符；
 * 2.如果不是第一行或者最后一行的话，还需要再添加一个字符，该字符距离起始字符2*m-2-2*i个字符
 *
 */
import java.util.Scanner;
public class ZigZagConversion {

	public static void main(String[] args) {
		System.out.println("请输入字符：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		System.out.println("请输入一个整数：");
		int numRows=sc.nextInt();
		
		Solution40 sl=new Solution40();
		String result=sl.Convert(s, numRows);
		System.out.println("结果是：");
		System.out.println(result);

	}
}
class Solution40
{
	public String Convert(String s,int numRows)
	{
		if(s==null) return null;
		int Length=s.length();
		if(Length<2||numRows<2) return s;
		
		//计算ZigZag的循环周期
		int cycle=2*numRows-2;
		String result="";
		//对于每一行来说
		for(int i=0;i<numRows;i++)
		{
			//每两个字符之间相差cycle个元素,j表示一个周期内的开始字符
			for(int j=i;j<Length;j+=cycle)
			{
				result+=s.charAt(j);
				//如果不是首行或者尾行的话，应该多加一个元素
				if(i>0 && i<numRows-1)
				{
					int t=j+cycle-2*i;
					//注意这里需要判断一下是否超过了既定的长度
					if(t<Length)
						result+=s.charAt(t);
				}
			}
		}
		return result;
	}
}