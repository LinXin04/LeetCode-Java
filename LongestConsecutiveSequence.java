/**
 * 题目：求最长连续子序列。给定一个未排序的数组，寻找它的最长的连续子序列的长度
 * 复杂度要求O(N)
 * 例如：
 * Given [100, 4, 200, 1, 3, 2]
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 解题思路：
 * 将所有的数字存入HashMap
 * 依次判断数组中的每一个元素，以该元素为中心，分别向左边扩张和向右边扩张，直至不再连续，记录下最大的长度。
 *
 */
import java.io.*;
import java.util.HashMap;
public class LongestConsecutiveSequence {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String[] st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution77 sl=new Solution77();
		int result=sl.longestConsecutive(nums);
		System.out.println("结果是："+result);

	}

}

class Solution77
{
	public int longestConsecutive(int[] nums)
	{
		int result=0;
		if(nums==null || nums.length==0) return 0;
		
		//使用一个HashMap
		HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		
		//将数组中的元素放入到map中
		for(int i=0;i<nums.length;i++)
			map.put(nums[i], false);
		
		//扫描一遍数组
		for(int i=0;i<nums.length;i++)
		{
			//如果当前元素没有被算作连续的
			if(map.get(nums[i])==false)
			{
				int curr=1;
				//向左扩展
				int left=nums[i]-1;
				while(map.containsKey(left) && !map.get(left) && left>=Integer.MIN_VALUE)
				{
					map.put(left, true);
					curr++;
					left--;
				}
				//向右扩展
				int right=nums[i]+1;
				while(map.containsKey(right) && !map.get(right) && right<=Integer.MAX_VALUE)
				{
					map.put(right, true);
					curr++;
					right++;
				}
				result=Math.max(result, curr);
			}
		}
		return result;
	}
}