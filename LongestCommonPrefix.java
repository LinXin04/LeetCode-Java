/**
 * 题目：给定一个字符串数组，求该数组中所有字符串的最长公共前缀
 * 解题思路：
 * 一层层遍历
 *
 */
import java.util.Scanner;
public class LongestCommonPrefix {
	public static void main(String[] args) {
		System.out.println("请输入字符串数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String strs[]=s.split(" ");
		
		Solution205 sl=new Solution205();
		System.out.println("结果是："+sl.longestCommonPrefix(strs));

	}
}
class Solution205
{
	public String longestCommonPrefix(String[] strs)
	{
		String result="";
		if(strs==null) return null;
		if(strs.length==0) return result;
		
		
		for(int i=0;i<strs[0].length();i++)
		{
			for(int j=1;j<strs.length;j++)
			{
				if(i>=strs[j].length() || strs[0].charAt(i)!=strs[j].charAt(i))
					return result;

			}
			result+=strs[0].charAt(i);
		}
		return result;
	}
}