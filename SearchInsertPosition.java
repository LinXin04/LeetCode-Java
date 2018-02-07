/**
 * 
 * 题目：给定一个排好序的数组和一个target，如果该target在该数组中，则返回该target的下标值；否则，返回target该插入的位置
 * 例如：
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 解题思路：使用二分查找，如果a[mid]=target,则返回mid,否则，返回left
 * 当循环结束时，如果没有找到目标元素，那么l一定停在恰好比目标大的index上，r一定停在恰好比目标小的index上
 */
import java.util.Scanner;
public class SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println("请输入一个排好序的数组：");
		Scanner sc=new Scanner(System.in);
		String st=sc.nextLine();
		String s[]=st.split(" ");
		int nums[]=new int[s.length];
		for(int i=0;i<s.length;i++)
			nums[i]=Integer.parseInt(s[i]);
		
		System.out.println("请输入一个target：");
		int target=sc.nextInt();

		Solution43 sl=new Solution43();
		int result=sl.searchInsert(nums, target);
		System.out.println("结果是："+result);
	}

}
class Solution43
{
	public int searchInsert(int []nums,int target)
	{
		int result;
		if(nums==null || nums.length==0) return 0;
		int Length=nums.length;

		int left=0;
		int right=Length-1;
		//进行循环找到index
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(nums[mid]==target) return mid;
			else if(nums[mid]>target) right=mid-1;
			else left=mid+1;
		}
		return left;
	}
}