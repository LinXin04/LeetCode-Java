/**
 * 题目：下一个更大的元素03.给定一个32位的正整数n，寻找大于n，并且所含数字与n中各位数字相等的最小32位正整数。若不存在，返回-1。
 * 解题思路：
 * 1、从后向前找到第一个不按照递增序列排序的数字x。
 * 2、从后向前找到第一个比x大的数字y
 * 3、交换两个位置的数字
 * 4、将该数字后面的数据进行排序
 * 
 *注意：为了防止结果越界要在最后判断一下，如果越界则返回-1
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class NextGreaterElement03 {
	public static void main(String[] args) {
		System.out.println("请输入数字：");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Solution248 sl=new Solution248();
		System.out.println("结果是："+sl.nextGreaterElement(n));
	}
}
class Solution248
{
	public int nextGreaterElement(int n)
	{
		if(n<=9) return -1;
		
		char[] number=(n+"").toCharArray();
		int len=number.length;
		
		//1、从后向前找到第一个不按照递增序列排序的数字x。
		int i=len-1;
		for(;i>0;i--)
		{
			if(number[i]>number[i-1])
				break;
		}
		if(i==0) return -1;
		int x=number[i-1];
		
		//2、从后向前找到第一个比x大的数字y
		int j=len-1;
		for(;j>i;j--)
		{
			if(number[j]>x)
				break;
		}
		int y=number[j];
		
		//3、交换两个位置的数字
		char temp=number[i-1];
		number[i-1]=number[j];
		number[j]=temp;
		
		//4、将该数字后面的数字进行排序
		Arrays.sort(number,i,len);
		
		//为了防止结果越界
		long val=Long.parseLong(new String(number));
		return (val>Integer.MAX_VALUE)? -1:(int) val;
	}
}