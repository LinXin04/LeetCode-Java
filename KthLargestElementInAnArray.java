/**
 * 题目：在一个无序数组中寻找第K大元素。
 * 例如：
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 解题思路：
 * 利用堆（即优先队列）的思想,注意：优先级队列在排序中，默认队头是最小元素，即最小堆。
 * 所以，在这里，我们可以将堆维持在大小为k，这样最后堆头元素即为第k大元素。
 * O(Nlogk)
 */
import java.util.*;
public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] st=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
		{
			nums[i]=Integer.parseInt(st[i]);
		}
		System.out.println("请输入k:");
		int k=sc.nextInt();
		Solution146 sl=new Solution146();
		int result=sl.findKthLargest(nums, k);
		System.out.println("结果是："+result);
	}
}
class Solution146
{
	public int findKthLargest(int[] nums,int k)
	{
		if(nums==null || k<=0) return 0;
		PriorityQueue<Integer> P=new PriorityQueue<Integer>();
		
		for(int i=0;i<nums.length;i++)
		{
			P.add(nums[i]);
			if(P.size()>k) P.poll();
		}
		
		return P.poll();
	}
}