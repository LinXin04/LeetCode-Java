/**
 * 题目：字符串压缩。将字符串进行压缩，一般形式是统计字符及字符出现的次数，如果某字符出现了一次，则不用数字表示该字符出现的次数。每个字符出现的次数超过1位数的话，用多个1位数字表示。
 * 例如：
 * ["a","a","b","b","c","c","c"]
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * 
 * ["a"]
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * 要求空间复杂度为O(1)
 * 解题思路：
 * 遍历字符数组，依次统计每一个字符出现的次数，需要注意的是：
 * 次数为1的只写字符；次数大于等于10的，注意将次数的每一位分开存储。
 *
 */
import java.util.Arrays;
import java.util.Scanner;
public class StringCompression {
	public static void main(String[] args) {
		System.out.println("请输入字符数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		char[] chars=new char[st.length];
		
		for(int i=0;i<st.length;i++)
			chars[i]=st[i].charAt(0);
		
		Solution224 sl=new Solution224();
		System.out.println("结果是："+sl.compress(chars));
	}
}

class Solution224
{
	public int compress(char[] chars)
	{
		if(chars==null ||chars.length<=0) return 0;
		
		//定义一个i:原数组中的下标，j:原数组的新下标，记录结果数组的下标。
		int len=chars.length;
		int i=0,j=0;
		
		//一次统计一个字符
		while(i<len)
		{
			//count代表此字符出现的次数。
			int count=0;
			char s=chars[i];
			
			while(i<len && s==chars[i])
			{
				i++;
				count++;
			}
			
			chars[j++]=s;
			if(count!=1)
			{
				//将count进行拆解
				for(char c:Integer.toString(count).toCharArray())
					chars[j++]=c;
			}
		}
		return j;
	}
}