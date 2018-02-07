/**
 * 题目：给定一个字符串，求其中第一个无重复字符出现的下标并返回
 * 例如：
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * 解题思路：
 * 用一个26大小的数组存储，先遍历一遍进行存储，然后遍历一遍寻找最小的下标
 */
import java.util.Scanner;
public class FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution251 sl=new Solution251();
		System.out.println("结果是："+sl.firstUniqueChar(s));

	}
}
class Solution251
{
	public int firstUniqueChar(String s)
	{
		if(s==null || s.length()==0) return -1;
		int []chars=new int[26];
		
		for(int i=0;i<s.length();i++)
		{
			chars[s.charAt(i)-'a']++;
		}
		
		for(int i=0;i<s.length();i++)
		{
			if(chars[s.charAt(i)-'a']==1) return i;
		}
		return-1;
	}
}