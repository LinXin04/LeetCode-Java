/**
 * 题目：最短的回文串。给定一个字符串s,在其首部加上最少的字符使其成为回文串，并返回。
 * 例如：
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 * 解题思路：
 * 由于前面缺失的字符串一定是后面的字符串
 * 定义两个指针，i=0,j=end，我们向中间扫描，
 * 如果s[i]=s[j],i++,j--;如果不相等，i=0,end--,j=end.
 * 最后将s[end+1:]的值进行翻转加在s的前面
 *
 */
import java.util.Scanner;
public class ShortestPalindrome {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution233 sl=new Solution233();
		System.out.println("结果是："+sl.shortestPalindrome(s));

	}
}
class Solution233
{
	public String shortestPalindrome(String s)
	{
		if(s==null || s.length()<=1) return s;
		int i=0,end=s.length()-1,j=end;
		char[] temp=s.toCharArray();
		
		while(i<j)
		{
			if(temp[i]==temp[j])
			{
				i++;
				j--;
			}else
			{
				i=0;
				end--;
				j=end;
			}
		}
		
		return new StringBuilder(s.substring(end+1)).reverse().toString()+s;
	}
}