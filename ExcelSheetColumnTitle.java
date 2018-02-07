/**
 * 题目：将10进制转换成26进制。
 * 例如：
 * 1->A
 * 2->B
 * 3->C
 * ....
 * 26->Z
 * 27->AA
 * 28->AB
 * 解题思路：
 * 按照10进制转换成26进制的方法。注意：这里不是从0开始，所以下标要减1
 */
import java.util.*;
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println("请输入十进制数：");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		Solution160 sl=new Solution160();
		System.out.println("结果是："+sl.converToTitle(n));
	}
}
class Solution160
{
	public String converToTitle(int n)
	{
		String result="";
		if(n==0) return result;
		while(n!=0)
		{
			result=(char)((n-1)%26+'A')+result;
			n=(n-1)/26;
		}
		return result;
	}
}