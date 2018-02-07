/**
 * 题目：给定一个字符串，删除最多1个字符，判断是否可以成为回文。
 * 回文就是指正读、反读都一样的字符串。
 * 例如：
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 解题思路：
 * 定义两个指针，判断两个指针之间的字符串是否是回文，如果不是，那么删除一个判断是否是回文串。
 *
 */
import java.util.Scanner;
public class ValidPalindrome02 {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution240 sl=new Solution240();
		System.out.println("结果是："+sl.validPalindrome(s));
	}
}
class Solution240
{
	public boolean validPalindrome(String s)
	{
		if(s==null || s.length()==0) return true;
		int l=0,r=s.length()-1;
		
		while(l < r)
		{
			if(s.charAt(l)!=s.charAt(r)) return isPalindrome(s,l,r-1) || isPalindrome(s,l+1,r);
			l++;
			r--;	
		}
		return true;
	}
	public boolean isPalindrome(String s, int l, int r)
	{
		while(l < r)
		{
			if(s.charAt(l)!=s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
}