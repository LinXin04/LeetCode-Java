/**
 * 题目：给定一个字符串，求该字符串中，由相同个数的0和1，以及0与1都是连续出现的子串的个数。子串可以重复。
 * 例如：
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * 解题思路：
 * 定义两个整数，pre和cur,pre用来记录之前连续出现的字符的个数，cur用来存储当前字符连续出现的个数。
 */
import java.util.Scanner;
public class CountBinarySubstrings {
	public static void main(String[] args) {
		System.out.println("请输入字符串s：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution238 sl=new Solution238();
		System.out.println("结果是："+sl.countBinarySubstrings(s));
	}
}

class Solution238
{
	public int countBinarySubstrings(String s)
	{
		if(s==null || s.length()==0) return 0;
		int result=0;
		
		int pre=0;
		int cur=1;
		for(int i=1;i<s.length();i++)
		{
			if(s.charAt(i)==s.charAt(i-1))
			{
				cur++;
			}else
			{
				pre=cur;
				cur=1;
			}
			if(pre>=cur) result++;
		}
		return result;
	}
}