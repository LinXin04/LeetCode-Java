/**
 * 题目：给定一个数组prices，其中每个元素代表石头的价格，要求可以交换k次，求取最大的利润。
 * 解题思路：
 * 使用动态规划。
 * 首先如果k>=prices.size(),此时我们应该取买卖石头的最大利润：如果price[i]-price[i-1]>0,result+=price[i]-price[i-1];
 * 否则：
 * 定义local[i][j]:代表第i天时最多可进行j次交易，并且最后一天卖出的最大利润。
 * global[i][j]:代表第i天时最多进行j次交易，不一定在最后一天卖出的最大利润。
 * local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
 * (local[i-1][j]：表示第i-1天卖了又买，不耗损交易)
 * global[i][j]=max(global[i-1][j],local[i][j])
 */
import java.util.Scanner;
public class BestTimeToBuyAndSellStock04 {
	public static void main(String[] args) {
		System.out.println("请输入k：");
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		System.out.println("请输入数组：");
		String s=sc.nextLine();
		String []st=s.split(" ");
		int[] prices=new int[st.length];
		for(int i=0;i<st.length;i++)
			prices[i]=Integer.parseInt(st[i]);
		
		Solution268 sl=new Solution268();
		System.out.println("结果是："+sl.max(k, prices));
	}
}
class Solution268
{
	public int max(int k,int[] prices)
	{
		if(prices==null || prices.length==0) return 0;
		int n=prices.length;
		if(k>=n) return maxPrice(prices);
		
		int local[][]=new int[n][k+1];
		int global[][]=new int[n][k+1];
		
		for(int i=1;i<n;i++)
		{
			int diff=prices[i]-prices[i-1];
			for(int j=k;j>=1;j--)
			{
				local[i][j]=Math.max(local[i-1][j]+diff, global[i-1][j-1]+Math.max(diff, 0));
				global[i][j]=Math.max(global[i-1][j], local[i][j]);
			}
		}
		return global[n-1][k];
	}
	
	public int maxPrice(int[] prices)
	{
		int result=0;
		for(int i=1;i<prices.length;i++)
		{
			if(prices[i]-prices[i-1]>0)
				result+=prices[i]-prices[i-1];
		}
		return result;
	}
}