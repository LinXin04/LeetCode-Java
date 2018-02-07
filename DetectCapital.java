/**
 * 题目：给定一个字符串word,检查其大写字母是否正确。
 * 正确的情况：
 * (1)所有的字母都是大写，比如“USA”
 * (2)所有的字母都是小写，比如“leetcode”
 * (3)如果有多个字符，那么只有第一个字符大写，比如“Goole”
 * 例如：
 * Input: "USA"
 * Output: True
 *
 * Input: "FlaG"
 * Output: False
 * 解题思路：
 * 统计大写字母出现的次数即可。
 */
import java.util.Scanner;
public class DetectCapital {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		
		Solution232 sl=new Solution232();
		System.out.println("结果是："+sl.detectCapitalUse(word));
	}
}
class Solution232
{
	public boolean detectCapitalUse(String word)
	{
		if(word==null || word.length()<=1) return true;
		
		int count=0;
		int n=word.length();
		for(int i=0;i<n;i++)
		{
			if(word.charAt(i)>='A' && word.charAt(i)<='Z')
				count++;
		}
		return count==0 || count==n || (count==1 && word.charAt(0)>='A' && word.charAt(0)<='Z');
	}
}
