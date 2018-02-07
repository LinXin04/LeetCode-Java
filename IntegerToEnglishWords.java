/**
 * 题目：将整数转换成英文单词。
 * 例如：
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 解题思路：
 * 1、三个一组进行处理，最高为2^31-1，即为billion位。
 * 2、定义三个数组，分别存储20以下的数；10-90的数；千、百万、亿万的数
 */
import java.util.Scanner;
public class IntegerToEnglishWords {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字：");
		int num=sc.nextInt();
		Solution170 sl=new Solution170();
		System.out.println("结果是："+sl.numberToWords(num));
	}
}

class Solution170
{
	private final String[] Less_Than_20={"","One","Two","Three","Four","Five","Six","Seven","Eight",
			"Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventenn","Eighteen","Nineteen"};
	private final String[] Tens={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	private final String[] Thousands={"","Thousand","Million","Billion"};
	
	public String numberToWords(int num)
	{
		if(num==0) return "Zero";
		
		//先找出三位三位的组合
		int i=0;
		String result="";
		while(num>0)
		{
			if(num%1000!=0)
				result=helper(num%1000)+Thousands[i]+" "+result;
			num/=1000;
			i++;
		}
		//除掉字符串前面和后面的空格
		return result.trim();
	}
	
	//处理三位数以内的
	public String helper(int num)
	{
		if(num==0) return "";
		else if(num<20) return Less_Than_20[num]+" ";
		else if(num<100) return Tens[num/10]+" "+helper(num%10);
		else return Less_Than_20[num/100]+" Hundred "+helper(num%100);
	}
}