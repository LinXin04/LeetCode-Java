/**
 * 题目：给定一个字符串和一个字典，求出所有的能将该字符串拆分的情况。
 * 例如：
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * 解题思路：
 * 主要是使用DFS，但是直接搜索的话会超时，所以要使用动态规划。
 * 定义一个一维的数组possible，其中possible[i]=true表示在[i,n]区间上有界，如果某个区间之前被判定了无解，下次循环时就会跳过这个区间，从而大大减少了运行的时间。
 *
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class WordBreak02 {
	public static void main(String[] args) {
		System.out.println("请输入一个字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("请输入字典：");
		String s1=sc.nextLine();
		String [] st=s1.split(" ");
		ArrayList<String> wordDict=new ArrayList<String>();
		for(int i=0;i<st.length;i++)
			wordDict.add(st[i]);
		
		Solution267 sl=new Solution267();
		ArrayList<String> result=sl.wordBreak(s, wordDict);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");

	}
}
class Solution267
{
	public ArrayList<String> wordBreak(String s, ArrayList<String> wordDict)
	{
		ArrayList<String> result=new ArrayList<String>();
		if(s==null || wordDict==null) return result;
		
		//定义一个数组possible记录s[i,n]区间上有没有正确的可能性
		int n=s.length();
		boolean possible[]=new boolean[n+1];
		Arrays.fill(possible, true);
		
		String out="";
		//将字典转换成map
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<wordDict.size();i++)
			map.put(wordDict.get(i), 1);
		DFS(s,map,0,possible,out,result);
		
		return result;
	}
	public void DFS(String s, HashMap<String,Integer> map,int start,boolean[] possible,String out,ArrayList<String> result)
	{
		if(start==s.length())
		{
			//因为最后存在一个空格
			result.add(out.substring(0,out.length()-1));
			return;
		}
		
		//从start开始遍历所有的可能
		for(int i=start;i<s.length();i++)
		{
			String word=s.substring(start, i+1);
			if(map.containsKey(word) && possible[i+1]==true)
			{
				out=out+word+" ";
				int oldSize=result.size();
				DFS(s,map,i+1,possible,out,result);
				if(result.size()==oldSize) possible[i+1]=false;
				//将错误识别的单词减掉，同时还有一个空格
				out=out.substring(0,out.length()-word.length()-1);
			}
		}
	}
}