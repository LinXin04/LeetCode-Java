/**
 * 题目：统计一个字符串中的字段数。字段是指一个连续的非空格字符序列，字符串中不包含任何不可打印字符。
 * 例如：
 * Input: "Hello, my name is John"
 * Output: 5
 * 解题思路：
 * 遍历字符，如果当前字符不为空并且前面的字符为空，则加1
 */
import java.util.Scanner;
public class NumberOfSegmentsInAString {

	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution223 sl=new Solution223();
		System.out.println("结果是："+sl.countSegments(s));

	}
}
class Solution223
{
	public int countSegments(String s)
	{
		if(s==null || s.length()==0) return 0;
		
		int result=0;
		s.trim();
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
				result++;
		}
		return result;
	}
}