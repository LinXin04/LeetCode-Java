/**
 * 题目：翻转字符串。给定一个字符串s和整数k，将s每隔k个字符翻转k个字符，最后不足k个字符的全部翻转。
 * 例如：
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 解题思路：
 * 先用n／k算出来原字符串s能分成几个长度为k的字符串，然后开始遍历这些字符串，遇到2的倍数就翻转，翻转的时候注意考虑下是否已经到s末尾了
 */
import java.util.Scanner;
public class ReverseString02 {

	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("请输入整数k:");
		int k=sc.nextInt();
		
		Solution229 sl=new Solution229();
		System.out.println("结果是："+sl.reverseStr(s, k));
	}
}

class Solution229
{
	public String reverseStr(String s, int k)
	{
		if(s==null || s.length()<=1) return s;
		
		int n=s.length();
		StringBuilder temp=new StringBuilder(s);
		
		for(int i=0;i<n;i++)
		{
			if(i%(2*k)==0 && i+k-1<n)
				temp.replace(i, i+k, new StringBuilder(temp.substring(i, i+k)).reverse().toString());
	
			else if(i%(2*k)==0 && i+k-1>=n)
				temp.replace(i, n, new StringBuilder(temp.substring(i, n)).reverse().toString());
		}
		
		return temp.toString();
	}
}