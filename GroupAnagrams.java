/**
 * 题目：给定一个字符串数组，将其错位词组合起来。错位词是指单词中字符的种类和个数都相等，但是位置不同
 * 例如：
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 解题思路：
 * 我们对所有的单词进行重新排序，那么所有的错位词都对应相同的排序结果。我们使用一个HashMap来保存排序的单词对应的所有的错位词。
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
public class GroupAnagrams {
	public static void main(String[] args) {
		System.out.println("请输入：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String []strs=s.split(" ");
		
		Solution214 sl=new Solution214();
		ArrayList<ArrayList<String>> result=sl.groupAnagrams(strs);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
		{
			for(int j=0;j<result.get(i).size();j++)
				System.out.print(result.get(i).get(j)+" ");
			System.out.println();
		}
	}
}
class Solution214
{
	public ArrayList<ArrayList<String>> groupAnagrams(String[] strs)
	{
		if(strs==null || strs.length==0) return new ArrayList<ArrayList<String>>();
		
		HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
		
		for(String s:strs)
		{
			//将字符串转成字符数组才能使用排序函数
			char[] temp1=s.toCharArray();
			Arrays.sort(temp1);
			//String.valueOf():返回 char 数组参数的字符串表示形式。
			String key=String.valueOf(temp1);
			
			if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
			map.get(key).add(s);	
		}
		 //返回此映射所包含的值的 Collection 视图
		return new ArrayList<ArrayList<String>>(map.values());
	}
}