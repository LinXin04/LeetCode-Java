/**
 * 题目：比较版本号。
 * 版本号一般用数字和小数点的形式表示，比如：2.2,1.1.1等。2.10代表2号大版本的第10个小版本，所以2.10比2.1大。
 * 如果版本号1>版本号2,可以返回1；如果版本号1<版本号2，可以返回-1;否则返回0
 * 解题思路：
 * 首先我们将两个版本号放入数组中，然后逐位两两比较只要有一位大于或者小于便返回结果
 *
 */
import java.util.Scanner;
public class CompareVersionNumber {
	public static void main(String[] args) {
		System.out.println("请输入字符串version1: ");
		Scanner sc=new Scanner(System.in);
		String version1=sc.nextLine();
		System.out.println("请输入字符串version2：");
		String version2=sc.nextLine();
		
		Solution231 sl=new Solution231();
		System.out.println("结果是："+sl.compareVersion(version1, version2));
	}
}
class Solution231
{
	public int compareVersion(String version1,String version2)
	{
		if(version1==null || version2==null) return 0;
		
		//split(" +")代表多个空格
		//split("\\.")代表一个.
		String[] temp1=version1.split("\\.");
		String[] temp2=version2.split("\\.");
		
		int len1=temp1.length;
		int len2=temp2.length;
		
		int i=0;
		//要用或，因为短的那个版本号可以用0进行补充
		while(i<len1 || i<len2)
		{
			int x1=i<len1?Integer.parseInt(temp1[i]):0;
			int x2=i<len2?Integer.parseInt(temp2[i]):0;
			
			if(x1>x2) return 1;
			else if(x1<x2) return -1;
			else i++;
		}
		return 0;
	}
}