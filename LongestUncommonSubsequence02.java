/**
 * 题目：给定一个字符串数组，判断该数组中所有字符串的最长的非公共子序列的长度。
 * 例如：
 * Input: "aba", "cdc", "eae"
 * Output: 3
 * 解题思路：
 * 暴力搜索。
 * 遍历所有的字符串，对于每个遍历到的字符串，再和所有的其他的字符串比较，看是不是某一个字符串的子序列，如果都不是的话，那么当前字符串就是一个非共同子序列
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class LongestUncommonSubsequence02 {
	public static void main(String[] args) {
		System.out.println("请输入字符串数组：");
		Scanner sc=new Scanner(System.in);
		ArrayList<String> temp=new ArrayList<String>();
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals("")) break;
			temp.add(s);
		}
		String strs[]=new String[temp.size()];
		for(int i=0;i<temp.size();i++)
			strs[i]=temp.get(i);
		
		Solution236 sl=new Solution236();
		System.out.println("结果是："+sl.findUSlength(strs));
	}
}
class Solution236
{
	public int findUSlength(String[] strs)
	{
		if(strs==null ||strs.length<=0) return -1;
		int result=-1;
		int n=strs.length;
		int j=0;
		
		for(int i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==j) continue;
				if(checkSub(strs[i],strs[j])) break;
			}
			//如果i与剩下的字符串全部比较完毕
			if(j==n) result=Math.max(result, strs[i].length());
		}
		return result;
	}
	
	//检查sub是不是str的子串
	public boolean checkSub(String sub,String str)
	{
		int i=0;
		for(int j=0;j<str.length();j++)
		{
			if(str.charAt(j)==sub.charAt(i)) i++;
			if(i==sub.length()) break;
		}
		return i==sub.length();
	}
}