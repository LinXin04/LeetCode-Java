/**
 * 题目：最大的数：给定一组非负整数，将它们排列连接起来，以得到最大的数字。
 * 例如：
 * given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 解题思路：
 * 首先将数组中的所有整数都转成字符串。
 * 核心在于判断s1+s2与s2+s1谁更大，谁更大就让谁在前面
 *
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class LargestNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数组：");
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution193 sl=new Solution193();
		System.out.println("结果是："+sl.largestNumber(nums));
	}
}
class Solution193
{
	public String largestNumber(int[] nums)
	{
		String result="";
		if(nums==null || nums.length==0) return result;
		
		//将数组中的所有元素都转换成String型
		String []s_num=new String[nums.length];
		for(int i=0;i<nums.length;i++)
			s_num[i]=String.valueOf(nums[i]);
		
		//比较决定两个字符串哪个在前面
		Comparator<String> com=new Comparator<String>()
				{
					public int compare(String s1,String s2)
					{
						String st1=s1+s2;
						String st2=s2+s1;
						//降序
						return st2.compareTo(st1);
					}
				};
		
		//对字符串数组中的元素进行排序
		Arrays.sort(s_num,com);
		//如果第一个元素的第一个字符是0，则返回0
		if(s_num[0].charAt(0)=='0')
			return "0";
		
		//将s_nums中的所有元素连接起来构成结果
		for(int i=0;i<s_num.length;i++)
			result=result+s_num[i];
		
		return result;
	}
}