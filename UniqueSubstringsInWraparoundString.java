/**
 * 题目：封装字符串中的独特子字符串。
 * 假设有一个无限长的封装字符串：...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....，该字符串是由26个字符顺序无限循环组成的。
 * 给定一个字符串p,问我们p有多少个非空字符串在封装字符串中。
 * 解题思路：
 * 比如abcd,以d结尾的子字符串有abcd, bcd, cd, d，那么我们可以发现bcd或者cd这些以d结尾的字符串的子字符串都包含在abcd中
 * 那么，我们可以发现以某个字符串结尾的最大字符串包含其他一该字符串结尾的所有子字符串。
 * 所以题目就转变成求以每个字符为结束符的最长连续字符串就行了。
 *
 */
public class UniqueSubstringsInWraparoundString {

	public static void main(String[] args) {
	
	}

}
class Solution290
{
	public int findSubstringInWraproundString(String p)
	{
		if(p==null || p.length()==0) return 0;
		int []count=new int[26];
		int res=0,len=0;
		
		for(int i=0;i<p.length();i++)
		{
			int cur=p.charAt(i)-'a';
			
			//比较现在的字母和前一个字母,如果不满足连续，则len=0
			if(i>0 && p.charAt(i-1)!=(cur+25)%26+'a')
				len=0;
			//++表示每个字母至少为长度为1的子串的最后一个字母
			if(++len>count[cur])
			{
				res+=len-count[cur];
				count[cur]=len;
			}
		}
		return res;
	}
}