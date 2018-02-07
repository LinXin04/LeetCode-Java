/**
 * 题目：给定一个按照升序排好序的数组，和一个target，寻找两数相加为target的两个数，并按升序返回它们的下标
 * 例子：
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 解题思路：
 * 左右夹逼 O(N)
 * 定义两个指针，一个指向开始start，一个指向结尾end。如果两个之和大于target，则end--;否则start++;
 */
import java.util.Scanner;
public class TwoSum02 {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int numbers[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			numbers[i]=Integer.parseInt(st[i]);
		
		System.out.println("请输入一个target：");
		int target=sc.nextInt();
		
		Solution49 sl=new Solution49();
		int []result=sl.twoSum(numbers, target);
		System.out.println("结果是：");
		System.out.print("["+result[0]+","+result[1]+"]");
	}
}
class Solution49
{
	public int[] twoSum(int[] numbers,int target)
	{
		if(numbers==null || numbers.length==0) return null;
		int[] result=new int[2];
		int Length=numbers.length;
		
		int start=0;
		int end=Length-1;
		while(start<end)
		{
			int Sum=numbers[start]+numbers[end];
			if(Sum==target) 
			{
				//题目中要求表示成1-n
				result[0]=start+1;
				result[1]=end+1;
				return result;
			}else if(Sum>target)
			{
				end--;
			}else
			{
				start++;
			}
		}
		return result;
	}
}