/**
 * 题目：将罗马数字转换成整数。
 * 解题思路：
 * 在罗马数字中，主要考虑下面两个问题：
 * 1、如果后面的大于前面的，则结果为后面的减去前面的。例如：Ⅳ= 4；Ⅸ= 9；
 * 2、如果前面的大于后面的，则结果为前面的加上后面的。例如：Ⅷ = 8；Ⅻ = 12；
 *
 */
import java.util.*;
public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println("请输入罗马数字：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution150 sl=new Solution150();
		System.out.println("结果是："+sl.romanToInt(s));
	}

}
class Solution150
{
	public int romanToInt(String s)
	{
		if(s.equals(null)) return 0;
		int result=0;
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		for(int i=0;i<s.length();i++)
		{
			int val=map.get(s.charAt(i));
			if(i==s.length()-1 || map.get(s.charAt(i+1))<=map.get(s.charAt(i))) 
				result+=val;
			else
				result-=val;
		}
		return result;
	}
}