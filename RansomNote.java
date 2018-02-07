/**
 * 题目：勒索信。给定一个报纸，判断是否能够成勒索信。注意，勒索信中的所有字符都要用报纸中的字符来代替。
 * 例如：
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 解题思路：
 * 使用HashMap统计报纸中所有字符出现的次数。
 *
 */
import java.util.Scanner;
import java.util.HashMap;
public class RansomNote {
	public static void main(String[] args) {
		System.out.println("请输入字符串s1:");
		Scanner sc=new Scanner(System.in);
		String ransomNote=sc.nextLine();
		System.out.println("请输入字符串s2:");
		String magazine=sc.nextLine();
		
		Solution222 sl=new Solution222();
		System.out.println("结果是："+sl.canConstruct(ransomNote, magazine));
	}
}
class Solution222
{
	public boolean canConstruct(String ransomNote,String magazine)
	{
		if(magazine==null) return false;
		int m=ransomNote.length();
		int n=magazine.length();
		
		if(m>n) return false;
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		
		for(int i=0;i<n;i++)
		{
			char s=magazine.charAt(i);
			if(!map.containsKey(s)) map.put(s,1);
			else map.put(s, map.get(s)+1);
		}
		
		for(int j=0;j<m;j++)
		{
			char t=ransomNote.charAt(j);
			if(!map.containsKey(t) || map.get(t)<=0) return false;
			else 
				map.put(t, map.get(t)-1);
		}
		return true;
	}
}