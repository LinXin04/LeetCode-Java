/**
 * 题目：给定一个整数1-3999，将该整数转换成罗马数字
 * 解题思路：用贪心算法，从大到校进行判断，如果给定的数字大于等于既定的数字，则减去，同时结果中加上对应的罗马符号
 *
 */
import java.util.*;
public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println("请输入数字：");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		
		Solution154 sl=new Solution154();
		System.out.println("结果是："+sl.intToRoman(num));

	}
}
class Solution154
{
	public String intToRoman(int num)
	{
		if(num<=0) return null;
		
		String result="";
		String roman[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int value[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
		
		for(int i=0;i<value.length;i++)
		{
			while(num>=value[i])
			{
				num-=value[i];
				result+=roman[i];
			}
		}
		return result;
	}
}