/**
 * 题目：爬行字符串。给定两个字符串，s1和s2，问s2是不是s1的爬行字符串。
 * 爬行字符串：假如把一个字符串当做一个二叉树的根，然后它的非空子字符串是它的子节点，然后交换某个子字符串的两个子节点，重新爬行回去形成一个新的字符串，这个新字符串和原来的字符串互为爬行字符串。
 * 解题思路：
 * 递归的思想。
 * 如果s1和s2是爬行字符串的话，必须满足，s1截取为两段：s11,s12,同理s2截取为两段s21,s22,那么需要满足：
 * s11与s21互为爬行且s12与s22互为爬行。
 * 或者s11与s22互为爬行且s12与s21互为爬行。
 *
 */
import java.util.Arrays;
import java.util.Scanner;
public class ScrambleString {
	public static void main(String[] args) {
		System.out.println("请输入字符串s1:");
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine();
		System.out.println("请输入字符串s2:");
		String s2=sc.nextLine();
		
		Solution221 sl=new Solution221();
		System.out.println("结果是："+sl.isScramble(s1, s2));
	}
}
class Solution221
{
	public boolean isScramble(String s1,String s2)
	{
		if(s1.equals(s2)) return true;
		int len1=s1.length(),len2=s2.length();
		if(len1!=len2) return false;
		
		
		//进行排序，看两个字符串含有的字符是不是相同
		char[] st1=s1.toCharArray();
		char[] st2=s2.toCharArray();
		Arrays.sort(st1);
		String s=String.valueOf(st1);
		Arrays.sort(st2);
		String t=String.valueOf(st2);
		if(!s.equals(t)) return false;
		
		
		for(int i=1;i<len1;i++)
		{
			String s11=s1.substring(0, i);
			String s12=s1.substring(i);
			
			String s21=s2.substring(0, i);
			String s22=s2.substring(i);
			
			if(isScramble(s11,s21) && isScramble(s12,s22)) return true;
			
			String str21=s2.substring(0,len1-i);
			String str22=s2.substring(len1-i);
			if(isScramble(s11,str22) && isScramble(s12,str21)) return true;
		}
		return false;
	}
}