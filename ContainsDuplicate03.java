/**
 * 题目：给定一个整数数组nums[]，查找是否存在两个下标i和j，满足0<|numsi−numsj|≤t 且 0<|i−j|≤k。
 * 解题思路：
 * 本题利用二叉搜索树的思想。
 * TreeSet数据结构是平衡二叉搜索树中的红黑树。里面有两个函数：
 * floor(n):返回set中小于等于给定元素的最大元素；若不存在，则返回NULL；
 * ceiling(n):返回set中大于等于给定元素的最小元素；若不存在，则返回NULL；
 * 我们遍历整个数组，如果当前的nums[i]<=t+set.floor(nums[i])或者大于set.ceiling(nums[i])-t，则返回True；
 * 将当前元素加入到set中，如果超过了下标范围，则将set中前面的元素删除。
 *
 */
import java.util.*;
public class ContainsDuplicate03 {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String []st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		System.out.println("请输入k:");
		int k=Integer.parseInt(sc.nextLine());
		System.out.println("请输入t:");
		int t=sc.nextInt();
		
		Solution151 sl=new Solution151();
		System.out.println("结果是："+sl.containsNearbyAlmostDuplicate(nums, k, t));

	}

}

class Solution151
{
	public boolean containsNearbyAlmostDuplicate(int[] nums,int k,int t)
	{
		if(nums==null || k<=0 || t<0) return false;
		TreeSet<Integer> set=new TreeSet<Integer>();
		
		for(int i=0;i<nums.length;i++)
		{
			int n=nums[i];
			if((set.floor(n)!=null && n<=t+set.floor(n)) || (set.ceiling(n)!=null && set.ceiling(n)<=t+n))
				return true;
			set.add(n);
			if(i>=k)
				set.remove(nums[i-k]);
		}
		return false;
	}
}