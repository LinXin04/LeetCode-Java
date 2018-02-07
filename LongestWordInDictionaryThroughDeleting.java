/**
 * 题目：给定一个字符串和一个字典，判断string s1能不能通过删除一些字符形成字典中的某个字符串string s2。求能形成的最大长度的字符串
 * 例如：
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output: 
 * "apple"
 * 解题思路：
 * 我们依次遍历字符串数组中的每一个字符串，看是否可以由string1删除某些元素得到。
 * 得到字符串之后，如果该字符串的长度大于之前的结果，则更新；或者两个长度相同，但是后面这个新的字符串的结果字母顺序小于结果，则也更新。
 */
import java.util.ArrayList;
import java.util.Scanner;
public class LongestWordInDictionaryThroughDeleting {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		System.out.println("请输入字符数组：");
		String s2=sc.nextLine();
		String st[]=s2.split(" ");
		ArrayList<String> d=new ArrayList<String>();
		for(int i=0;i<st.length;i++)
			d.add(st[i]);
		
		Solution199 sl=new Solution199();
		System.out.println("结果是："+sl.findLongestWord(s, d));
	}
}
class Solution199
{
	public String findLongestWord(String s,ArrayList<String> d)
	{
		if(s==null || d==null) return null;
		
		String result="";
		
		for(String str : d)
		{
			int i=0;
			for(int j=0;j<s.length();j++)
			{
				char c=s.charAt(j);
				if(i<str.length() && c==str.charAt(i)) i++;
			}
			if(i==str.length() && (str.length()>result.length() || (str.length()==result.length() && str.compareTo(result)<0)))
				result=str;
		}
		return result;
	}
}