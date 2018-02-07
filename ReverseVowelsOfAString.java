/**
 * 题目：给定一个字符串s，只翻转其中的元音字母。
 * 例如：
 * Given s = "hello", return "holle".
 * Given s = "leetcode", return "leotcede".
 */
import java.util.Scanner;
public class ReverseVowelsOfAString {
	public static void main(String[] args) {
		System.out.println("请输入字符s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution217 sl=new Solution217();
		System.out.println("结果是："+sl.reverseVowels(s));
	}
}

class Solution217
{
	public String reverseVowels(String s)
	{
		if(s==null || s.length()<=1) return s;
		int n=s.length();
		char st[]=s.toCharArray();
		
		int left=0,right=n-1;
		
		while(left<right)
		{
			if(isVowel(st[left]) && isVowel(st[right]))
			{
				char temp=st[left];
				st[left]=st[right];
				st[right]=temp;
				left++;
				right--;
			}else if(isVowel(st[left]))
			{
				right--;
			}else
			{
				left++;
			}
		}
		return String.valueOf(st);
	}
	
	public boolean isVowel(char ch)
	{
		if(ch=='a' || ch=='e' ||ch=='i' ||ch=='o' ||ch=='u' || ch=='A' || ch=='E' ||ch=='I' ||ch=='O' ||ch=='U')
			return true;
		else
			return false;
	}
}