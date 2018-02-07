/**
 * 题目：给定一个有序（升序）数组，和一个target，寻找target的初始位置和结束位置。如果target不在数组中，则返回[-1,-1]。
 * 时间复杂度为O(log N)
 * 例如：
 * Given [5, 7, 7, 8, 8, 10] and target value 8
 * return [3, 4]
 * 解题思路：
 * 同样使用二分查找，先查找左边界（即当nums[mid]==target时，左移），再查找右边界（即当nums[mid]==target时，右移）。
 */
import java.util.Scanner;
public class SearchForARange {
	
	public static void main(String[] args) {
		System.out.println("请输入一个数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");	
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		System.out.println("请输入一个target：");
		int target=sc.nextInt();
		
		Solution44 sl=new Solution44();
		int result[]=sl.searchRange(nums, target);
		
		System.out.println("结果是：");
		System.out.print("["+result[0]+" "+result[1]+"]");
		
	}
}

class Solution44
{
	public int[] searchRange(int[] nums,int target)
	{
		int result[]={-1,-1};
		if(nums==null||nums.length==0) return result;
		int Length=nums.length;
		
		//先求左边的边界
		int lStart=0;
		int lEnd=Length-1;
		while(lStart<=lEnd)
		{
			int mid=(lStart+lEnd)/2;
			if(nums[mid]<target) lStart=mid+1;
			else lEnd=mid-1;
		}
		
		//再求右边的边界
		int rStart=0;
		int rEnd=Length-1;
		while(rStart<=rEnd)
		{
			int mid=(rStart+rEnd)/2;
			if(nums[mid]>target) rEnd=mid-1;
			else rStart=mid+1;
		}
		//如果符合条件
		if(lStart<=rEnd)
		{
			result[0]=lStart;
			result[1]=rEnd;
		}
		return result;
	}
}