/**
 * 题目：给定两个字符串s,t，验证这两个字符串是不是变形词。变形词的意思就是：两个词中所含有的字符相同且相等，允许位置不同
 * 解题思路：
 * 定义一个数组用来存储26个字母出现的个数，如果最后i为0，则返回true。
 *
 */
import java.util.Scanner;
public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("请输入字符串t:");
		String t=sc.nextLine();
		
		Solution192 sl=new Solution192();
		System.out.println("结果是："+sl.isAnagram(s, t));
	}
}
class Solution192
{
	public boolean isAnagram(String s,String t)
	{
		if(s.length()!=t.length()) return false;
		
		//存储26个字符
		int num[]=new int[26];
		
		for(int i=0;i<s.length();i++) num[s.charAt(i)-'a']++;
		for(int i=0;i<t.length();i++) num[t.charAt(i)-'a']--;
		
		for(int i=0;i<26;i++)
		{
			if(num[i]!=0) return false;
		}
		return true;	
	}
}