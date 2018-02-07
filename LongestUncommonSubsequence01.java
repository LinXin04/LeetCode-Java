/**
 * 题目：最长的非公共子序列。如果一个字符串中的某个子序列在另一个字符串中没有，则为非公共子序列。
 * 例如：
 * Input: "aba", "cdc"
 * Output: 3
 * Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
 * because "aba" is a subsequence of "aba", 
 * but not a subsequence of any other strings in the group of two strings. 
 * 解题思路：
 * 如果两个字符串相同，则返回-1，
 * 若不同，则返回较长的那个字符串的长度
 */
import java.util.Scanner;
public class LongestUncommonSubsequence01 {
	public static void main(String[] args) {
		System.out.println("请输入字符串a:");
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		System.out.println("请输入字符串b:");
		String b=sc.nextLine();
		
		Solution235 sl=new Solution235();
		System.out.println("结果是："+sl.findUSlength(a, b));
	}
}
class Solution235
{
	public int findUSlength(String a,String b)
	{
		return a.equals(b)?-1:Math.max(a.length(), b.length());
	}
}