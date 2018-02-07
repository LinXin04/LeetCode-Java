/**
 * 题目：将26进制转换成10进制
 *
 */
import java.util.*;
public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println("请输入26进制：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		Solution161 sl=new Solution161();
		System.out.println("结果是："+sl.titleToNumber(s));
	}

}
class Solution161
{
	public int titleToNumber(String s)
	{
		if(s==null || s.isEmpty()) return 0;
		int result=0;
		int temp=1;
		
		for(int i=s.length()-1;i>=0;i--)
		{
			result+=(s.charAt(i)-'A'+1)*temp;
			temp*=26;
		}
		return result;
	}
}