/**
 * 题目：给定一个数组，里面含有若干个0，要求移除这些0到数组的结尾，并保持其他数的顺序不变
 * 例如：
 * given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]
 * 解题思路：
 * 
 */
import java.util.Scanner;
public class MoveZeros {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		System.out.println("结果是：");
		Solution55 sl=new Solution55();
		sl.moveZeros(nums);
		
		System.out.print("[ ");
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
		System.out.print("]");
	}
}

class Solution55
{
	public void moveZeros(int[] nums)
	{
		if(nums==null || nums.length==0) return;
		int Length=nums.length;
		
		int count=0;
		//扫描一遍，将元素按照前面出现0的次数前移
		for(int i=0;i<Length;i++)
		{
			nums[i-count]=nums[i];
			if(nums[i]==0)
				count++;		
		}
		//最后count个元素赋值为0
		for(int i=Length-1;i>=Length-count;i--)
			nums[i]=0;
	}
}