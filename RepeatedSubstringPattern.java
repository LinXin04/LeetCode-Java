/**
 * 题目：重复子串模式。给定一个字符串，判断其是否由若干个重复的子串组成的。
 * 例如：
 * Input: "abab"
 * Output: True
 * 
 * Input: "abcabcabcabc"
 * Output: True
 * 
 * 解题思路：
 * 既然是子串，那么子串的长度肯定<=n/2;
 * 从长度为n/2的子串开始遍历，如果n/i==0,说明原字符串可以分成若干个子字符串，我们将这些字符串拼接起来看是否与原字符串相等即可。
 */
import java.util.Scanner;
public class RepeatedSubstringPattern {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution225 sl=new Solution225();
		System.out.println("结果是："+sl.repeatedSubstringPattern(s));

	}
}

class Solution225
{
	public boolean repeatedSubstringPattern(String s)
	{
		if(s==null ||s.length()<=1) return false;
		
		int n=s.length();
		
		//i代表子串的长度
		for(int i=n/2;i>=1;--i)
		{
			if(n%i==0)
			{
				int c=n/i;
				//这里使用String的话会出错，原因待查！
				StringBuilder t=new StringBuilder();
				for(int j=0;j<c;++j)
					t.append(s.substring(0, i));
				if(t.toString().equals(s)) return true;
			}
		}
		return false;
	}
}