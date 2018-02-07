/**
 * 题目：将分数转换为循环小数。
 * 给定一个分数的分子和分母，以字符串的格式返回它的循环小数形式。如果小数部分是重复的，则用括号括起来。
 * 例如：
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 解题思路：
 * 1、首先注意的是正负号；并将分子和分母全都转换成正数；
 * 2、如果可以整除，直接返回；
 * 3、如果不可以整除，判断是否有循环体，循环体可以用一个HashMap来保存，其中，关键字是循环的数字，另一个是对应结果的下标。
 */
import java.util.*;
public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		System.out.println("请输入分子：");
		Scanner sc=new Scanner(System.in);
		int numerator=Integer.parseInt(sc.nextLine());
		System.out.println("请输入分母：");
		int denominator=sc.nextInt();
		
		Solution159 sl=new Solution159();
		System.out.println("结果是："+sl.fractionToDecimal(numerator, denominator));

	}
}
class Solution159
{
	public String fractionToDecimal(int numerator,int  denominator)
	{
		String result="";
		if(numerator==0) return "0";
		if(denominator==0) return result;
		
		//检查正负号
		if((numerator<0) ^ (denominator<0)) result+="-";
		
		//一下都要使用long型，防止越界
		//将分子与分母都转换成正数
		//一定要先把 int 转为 long，然后再取绝对值。
		//如果写成 long num = Math.abs(numerator) 就会有问题，因为这句代码在 numerator=Integer.MIN_VALUE 时相当于 long num = Math.abs(-2147483648)，这样得到的 num还是 -2147483648。
		long num=numerator;
		num=Math.abs(num);
		long den=denominator;
		den=Math.abs(den);
		
		//计算整数部分
		long integer=num/den;
		result+=String.valueOf(integer);
		
		//计算小数部分
		long decimal=(num%den)*10;
		if(decimal==0) return result;
		else result+=".";
		
		//定义一个Map来存储小数可能的循环体
		HashMap<Long, Integer> map=new HashMap<Long, Integer>();
		while(decimal!=0)
		{
			//如果循环体存在
			if(map.containsKey(decimal))
			{
				//得到循环体开始的位置
				int begin=map.get(decimal);
				String part1=result.substring(0,begin);
				String part2=result.substring(begin,result.length());
				result=part1+"("+part2+")";
				return result;
			}
			//如果循环不存在，则一步步找出循环
			map.put(decimal, result.length());
			integer=decimal/den;
			result+=String.valueOf(integer);
			decimal=(decimal%den)*10;
		}
		return result;
	}
}