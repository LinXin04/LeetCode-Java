/**
 *题目：判断是否是子字符串。给定两个字符串s和t,判断s是否是t的子序列。
 *假设两个字符串中都只包含小写字母。t的长度可能很长，s的长度可能很短。
 *子字符串的定义：从字符串中删除若干个字符串后，剩余的字符的相对顺序保持不变得到的新字符串。
 *解题思路：
 *遍历s和t,如果对于s中的一个字符，t的当前字符与其不匹配，则t++; 否则，s++,t++.
 *如果t到了串尾，而s没有到串尾，则返回false.
 *
 */
public class IsSubsequence {
	public static void main(String[] args) {

	}
}

class Solution281
{
	public boolean isSequence(String s,String t)
	{
		if(s==null) return true;
		int m=s.length();
		int n=t.length();
		if(m>n) return false;
		
		int j=0;
		for(int i=0;i<m;)
		{
			for(;j<n;)
			{
				if(s.charAt(i)!=t.charAt(j))
					j++;
				else
				{
					i++;
					j++;
					break;
				}
			}
			if(j>=n && i<m) return false;
		}
		return true;
	}
}