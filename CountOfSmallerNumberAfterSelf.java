/**
 * 题目：给定一个数组num，求每一个数的右边所有小于这个数字的个数。
 * 例如：
 * Given nums = [5, 2, 6, 1]
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 * 解题思路：
 * 将原数组从最后一个元素开始，使用二分法将每个数据插入到一个新的数组中去，那么这个新的数组就是有序的。
 * 那么对于某一个数来说，比它小的所有数的个数正是它在新数组中的下标值。
 *
 */
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class CountOfSmallerNumberAfterSelf {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数组：");
		String s=sc.nextLine();
		String[] st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution260 sl=new Solution260();
		ArrayList<Integer> result=sl.countSmaller(nums);
		
		System.out.println("结果是：");
		for(int i:result)
		System.out.print(i+" ");

	}
}
class Solution260
{
	public ArrayList<Integer> countSmaller(int[] nums)
	{
//		ArrayList<Integer> result=new ArrayList<Integer>();
//		if(nums==null || nums.length==0) return result;
//		
//		//定义一个新的数组
//		int [] newArray=new int[nums.length];
//		int []temp=new int[nums.length];
//		int j=0;
//		
//		for(int i=nums.length-1;i>=0;i--)
//		{
//			//将nums[i]插入到newArray中
//			int left=0,right=j;
//			while(left<right)
//			{
//				int mid=left+(right-left)/2;
//				if(newArray[mid]>=nums[i]) right=mid;
//				else left=mid+1;
//			}
//			temp[i]=right;
//			newArray[j++]=nums[i];
//			Arrays.sort(newArray);
//		}
//		for(int m:temp)
//			result.add(m);
//		
//		return result;	
		 int[] smaller = new int[nums.length];  
	        for(int i=nums.length-2; i>=0; i--) {  
	            int left = i+1;  
	            int right = nums.length-1;  
	            while (left<=right) {  
	                int m = (left+right)/2;  
	                if (nums[i] > nums[m]) right = m - 1;  
	                else left = m + 1;  
	            }  
	            smaller[i] = nums.length - left;  
	            int temp = nums[i];  
	            for(int j=i; j<right; j++) nums[j] = nums[j+1];  
	            nums[right] = temp;  
	        }  
	        ArrayList<Integer> results = new ArrayList<>(nums.length);  
	        for(int i=0; i<smaller.length; i++) results.add(smaller[i]);  
	        return results;  
	}
}