/**
 * 题目：串联所有单词的子串。
 * 给定一个长字符串s和一个字符串数组，该数组中所有字符串的长度相等。找出s中所有的子串，要求这些子串是字符串数组中的所有字符串拼接的结果，字符串拼接的时候顺序可以随意。最终返回所有的这种子串开始的位置。
 * 例如：
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * 解题思路：
 * 首先定义一个Hashmap_map1,用于存储words中的所有单词出现的个数。
 * 对s进行遍历，停止条件是剩余的字符个数小于单词数组里所有字符的总长度。
 * 定义另一个HashMap——map2,每次查找s中给定单词长度的子串，看是否在map1中，如果没有，则break；否则加入map2，如果map2中的个数大于map1中的个数，则break.
 * 如果j==n，则将i加入结果集中。
 *
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		System.out.println("请输入字符串s：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("请输入字符串数组：");
		String sw=sc.nextLine();
		String words[]=sw.split(" ");
		
		Solution211 sl=new Solution211();
		ArrayList<Integer> result=sl.findSubstring(s, words);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
	}
}
class Solution211
{
	public ArrayList<Integer> findSubstring(String s,String[] words)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(s==null || words==null || words.length==0) return result;
		
		int n=words.length, m=words[0].length();
		int l=s.length();
		
		//定义map1存储words
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		for(String word:words)
		{
			if(!map1.containsKey(word)) map1.put(word, 1);
			else map1.put(word, map1.get(word)+1);
		}
		
		//遍历s
		for(int i=0;i<=l-n*m;i++)
		{
			HashMap<String,Integer> map2=new HashMap<String,Integer>();
			//对于words中的每一个单词
			int j=0;
			for(;j<n;j++)
			{
				//取s中的长度为m的字符串
				String t=s.substring(i+j*m, i+j*m+m);
				//如果map1中没有t,则跳出
				if(!map1.containsKey(t)) break;
				//否则的话，将t加入到map2中
				if(!map2.containsKey(t)) map2.put(t, 1);
				else map2.put(t, map2.get(t)+1);
				//如果map2中的t的个数大于map1中的个数，则跳出
				if(map2.get(t)>map1.get(t)) break;
			} 
			if(j==n) result.add(i);
		}
		return result;
	}		
}