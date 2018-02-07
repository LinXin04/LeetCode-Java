/**
 * 题目：给定一个数组，里面含有三种元素，0,1,2，分别代表3种颜色，请排序，使得00001111122222这种排列
 * 解题思路：
 * 从前向后进行遍历，一遍扫描，根据第i个数字是什么，移动0~i-1串
 */
import java.io.*;
public class SortColors {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入一个数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String[] st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution71 sl=new Solution71();
		sl.sortColors(nums);
		for(int i=0;i<st.length;i++)
			System.out.print(nums[i]+" ");
	}

}

class Solution71
{
	public void sortColors(int[] nums)
	{
		if(nums==null || nums.length==0 || nums.length==1) return;
		
		//定义三个指针
		int i=0;
		int j=0;
		int k=0;
		
		for(int m=0;m<nums.length;m++)
		{
			if(nums[m]==0)
			{
				nums[i++]=2;
				nums[j++]=1;
				nums[k++]=0;
			}
			else if(nums[m]==1)
			{
				nums[i++]=2;
				nums[j++]=1;
			}else
			{
				nums[i++]=2;
			}
		}
	}
}