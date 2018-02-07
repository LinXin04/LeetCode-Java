/**
 * 题目：求除自身外的其他元素的乘积。给定一个数组，返回一个数组，新的数组中的元素是元素中的元素除了自身外的其他元素的乘积
 * 例如：
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 解题思路：
 * 1.比较好的解决方法是构造两个数组相乘：
 * [1, a1, a1*a2, a1*a2*a3]
 * [a2*a3*a4, a3*a4, a4, 1]
 * 但是题目要求空间复杂度为原数组，所以我们改进一下
 * 2.先从前向后扫描一遍，存储每个元素右边的所有元素之积；然后从后向前扫描一遍，存储每个元素左边的所有元素之积。
 *
 */
import java.io.*;
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution79 sl=new Solution79();
		int[] result=sl.productExceptSelf(nums);
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");

	}

}

class Solution79
{
	public int[] productExceptSelf(int[] nums)
	{
		if(nums==null) return null;
		int[] result=new int[nums.length];
		if(nums.length <=1) return nums;
		
		result[0]=1;
		//从前到后进行扫描
		for(int i=1;i<nums.length;i++)
		{
			result[i]=result[i-1]*nums[i-1];
		}
		int curr=1;
		//从后向前进行扫描
		for(int i=nums.length-2;i>=0;i--)
		{
			curr=curr*nums[i+1];
			result[i]*=curr;	
		}
		return result;
	}
}