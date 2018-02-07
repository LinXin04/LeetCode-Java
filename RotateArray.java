/**
 * 题目：旋转数组：给定一个数组和平移的步数k，求得平移k步后的数组。
 * 例如：
 * with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 解题思路：
 * 1.reverse原来的数组
 * 2.reverse 0~k-1
 * 3.reverse k~n-1
 * 注意，为了避免重复reverse，k需要处理一下：k=k%n
 */
import java.util.Scanner;
public class RotateArray {

	public static void main(String[] args) {
		System.out.println("请输入一个数组:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		System.out.println("请输入一个整数K:");
		int k=sc.nextInt();
		
		
		Solution51 sl=new Solution51();
		sl.rotate(nums, k);
		System.out.println("结果是：");
		System.out.print("[ ");
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
		System.out.print("]");
	}
}
class Solution51
{
	public void rotate(int[] nums,int k)
	{
		if(nums==null || nums.length==0) return;
		int Length=nums.length;
		
		//先对k进行处理
		k=k%Length;
		//1.reverse原来的数组
		rotateSub(nums,0,Length-1);
		//2.reverse 0~k-1
		rotateSub(nums,0,k-1);
		//3.reverse k~n-1
		rotateSub(nums,k,Length-1);
	}
	public void rotateSub(int[] nums,int start,int end)
	{
		while(start<end)
		{
			int temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}
}