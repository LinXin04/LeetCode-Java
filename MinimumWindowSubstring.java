/**
 * 题目：给定两个字符串S,T,求T在S中的最小的窗口子串，忽略T的顺序。
 * 例如：
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 解题思路：1.首先扫描一遍T，将对应的字符以及它出现的次数存在HashMap中
 * 2.开始遍历S，遇到T中的字符，就将HashMap中的对应的value减1，直到包含了T中的所有字符，更新最小的长度为当前最小长度
 * 3.将子窗口的左边界右移，略去不出现在T中的字符，如果某个在T中的字符出现的次数大于哈希表中的value，则可以跳过该字符
 */
import java.util.HashMap;
import java.util.Scanner;
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("请输入字符串t:");
		String t=sc.nextLine();
		
		Solution34 sl=new Solution34();
		String result=sl.minWindow(s, t);
		System.out.println("结果是："+result);

	}

}

class Solution34
{
	public String minWindow(String s,String t)
	{
		String result="";
		if(s.length()==0||s==null) return "";
		if(s.length()<t.length()) return "";
		//1.首先扫描一遍T，将对应的字符以及它出现的次数存在HashMap中
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<t.length();i++)
		{
			//如果map中已有这个元素，则将该元素的value+1
			if(map.containsKey(t.charAt(i)))
				map.put(t.charAt(i),map.get(t.charAt(i))+1);
			else
				map.put(t.charAt(i), 1);
		}
		
		//2.开始遍历S，遇到T中的字符，就将HashMap中的对应的value减1，直到包含了T中的所有字符，更新最小的长度为当前最小长度
		int left=0;
		int minLen=s.length()+1;
		int count=0;
		int minstart=0;
		for(int right=0;right<s.length();right++)
		{
			//如果map中存在这个字符，则将map中的对应的value减1
			if(map.containsKey(s.charAt(right)))
			{
				
			map.put(s.charAt(right), map.get(s.charAt(right))-1);
			
			//统计当前找到的字符个数
			if(map.get(s.charAt(right))>=0) count++;
					
			//当所有的字符都找到时
			while(count==t.length())
			{
				//想更新最小长度为当前最小长度，开始节点为left
				if(right-left+1<minLen)
				{
					minLen=right-left+1;
					minstart=left;
				}
				//如果left的这个字符在map中出现了，
				if(map.containsKey(s.charAt(left)))
				{
					map.put(s.charAt(left), map.get(s.charAt(left))+1);
					if(map.get(s.charAt(left))>0) count--;	
				}
				left++;	
			}
		}
		}
		if(minLen>s.length()) return "";
		result=s.substring(minstart, minstart+minLen);
		return result;
	}
}