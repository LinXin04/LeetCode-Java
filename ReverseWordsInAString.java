/**
 * 题目：在一个字符串中翻转单词。只允许空间复杂度为O(1)
 * 例如：
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 解题思路：
 * 先对字符串进行整体的翻转，再对每一个单词进行翻转
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class ReverseWordsInAString {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution228 sl=new Solution228();
		System.out.println("结果是："+sl.reverseWords(s));
	}
}
class Solution228
{
	public String reverseWords(String s)
	{
//		if(s==null) return null;
//		if(s.length()<=0) return s;
//		
//		s=s.trim();
//		if(!s.isEmpty() && s.charAt(0)==' ') return "";
//		//用StringBuilder进行反转
//		StringBuilder sb=new StringBuilder(s).reverse();
//		int index=0;
//		
//
//		for(int i=0;i<sb.length();)
//		{
//			index=i;
//			while(index<sb.length() && sb.charAt(index)!=' ') index++;
//			//substring(start,end):从指定的 start 处开始，一直到索引 end - 1 处的字符。
//			StringBuilder temp=new StringBuilder(sb.substring(i, index)).reverse();
//			
//			//StringBuilder.replace(start,end):从start~end-1
//			sb.replace(i, index, temp.toString());
//			i=index+1;
//			if(i<sb.length() && sb.charAt(i)==' ')
//			{
//				while(i<sb.length() && sb.charAt(i)==' ')i++;
//				i--;
//			}
//		}
//		String re=sb.toString();
//		return re;
		String[] words=s.trim().split(" +");
		//将数组转换成list，因为collections.reverse只对list可用,words也进行翻转，整个顺序也进行翻转
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}
}