/**
 * 题目：摆动排序。在上面题目的基础上，要求：nums[0] < nums[1] > nums[2] < nums[3]....
 * 要求时间复杂度O(N),空间复杂度O(1)
 * 例如：
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 解题思路：
 * 对数组进行排序，然后将前半段倒序填入偶数的下标，将后半段倒序填入奇数的下标。
 * O(NlogN)
 */
import java.util.Arrays;
import java.util.Scanner;
public class WiggleSort02 {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution201 sl=new Solution201();
		sl.wiggleSort(nums);
		System.out.println("结果是：");
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
	}
}
class Solution201
{
	public void wiggleSort(int[] nums)
	{
		if(nums==null || nums.length<=1) return;
		
		//复制数组
		int []sorted=nums.clone();
		//先进行排序
		Arrays.sort(sorted);
		int mid=(nums.length-1)/2;
		
		for(int i=0,j=mid,k=nums.length-1;i<nums.length;i+=2,j--,k--)
		{
			nums[i]=sorted[j];
			if(i+1<nums.length) nums[i+1]=sorted[k];
		}	
	}
}