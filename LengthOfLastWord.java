/**
 * 题目：给定一个字符串（由若干个单词和中间的空格组成），求最后一个单词的长度。
 * 例如：
 * Input: "Hello World"
 * Output: 5
 * 解题思路：
 * 遍历字符串，利用一个计数器进行计数，新词开始（遇到空格）将计数器清0
 *
 */
import java.util.Scanner;
public class LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();

		Solution213 sl=new Solution213();
		System.out.println("结果是："+sl.lengthOfLasrWord(s));
	}
}

class Solution213
{
	public int lengthOfLasrWord(String s)
	{
		if(s.length()==0 || s==null) return 0;
		int count=0;
		//忽略前导和尾部空白
		s=s.trim();
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ') count=0;
			else count++;
		}
		return count;
	}
}