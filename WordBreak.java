/**
 * 题目：给定一个字符串和一个词典，问这个字符串能不能拆分成词典中的若干个词。
 * 解题思路：
 * 动态规划。
 * dp[i]代表从0开始到i为止，是否可以满足字典找寻规则。
 * dp[i]=dp[j]  &&  字典中存在j-len的单词
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class WordBreak {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		System.out.println("请输入字典：");
		ArrayList<String> wordDict=new ArrayList<String>();
		String s1=sc.nextLine();
		String st[]=s1.split(" ");
		for(int i=0;i<st.length;i++)
			wordDict.add(st[i]);
		
		Solution266 sl=new Solution266();
		System.out.println("结果是："+sl.wordBreak(s1, wordDict));
		
	}
}
class Solution266
{
	public boolean wordBreak(String s, ArrayList<String> wordDict)
	{
		if(s==null || s.length()==0) return true;
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		for(int i=0;i<wordDict.size();i++)
			map.put(wordDict.get(i), 1);
		
		int n=s.length();
		boolean dp[]=new boolean[n+1];
		Arrays.fill(dp, false);
		dp[0]=true;
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(dp[j] && map.containsKey(s.substring(j, i)))
				{
					dp[i]=true;
					break;
				}
			}
		}
		return  dp[n];
	}
}