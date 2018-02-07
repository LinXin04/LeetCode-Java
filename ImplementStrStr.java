/**
 * 题目：判断一个字符串是否是另一个字符串的子串，并返回子字符串第一次出现的下标。
 * 如果不是该子字符串，则返回-1.
 * 解题思路：
 * KMP算法可以实现线性时间复杂度,但是实现起来过于复杂
 * 暴力求解O(m*n)
 *
 */
import java.util.Scanner;
public class ImplementStrStr {

	public static void main(String[] args) {
		System.out.println("请输入字符串haystack：");
		Scanner sc=new Scanner(System.in);
		String haystack=sc.nextLine();
		System.out.println("请输入子字符串needle：");
		String needle=sc.nextLine();

		Solution209 sl=new Solution209();
		System.out.println("结果是："+sl.strStr(haystack, needle));
	}
}

class Solution209
{
	public int strStr(String haystack,String needle)
	{
		if(haystack==null || needle==null) return 0;
		int hLen=haystack.length();
		int nLen=needle.length();
		
		if(nLen>hLen)
			return -1;
		else if(nLen==0 || hLen==0)
			return 0;
		
		for(int i=0;i<=hLen-nLen;i++)
		{
			if(haystack.substring(i, i+nLen).equals(needle))
				return i;
		}
		return -1;
	}
}