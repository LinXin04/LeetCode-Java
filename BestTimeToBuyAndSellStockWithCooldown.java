/**
 * 题目：给定一个数组，代表每天股票的价格，你可以交易任意次，但必须遵循以下规则：
    ①必须在下一次买之前先卖出去；
    ②卖出股票的第二天为冷冻期，不能接着买股票
 * 解题思路：
 * 
buy[i]表示在第i天之前最后一个操作是买，此时的最大收益。
sell[i]表示在第i天之前最后一个操作是卖，此时的最大收益。
rest[i]表示在第i天之前最后一个操作是冷冻期，此时的最大收益。
递推式：
buy[i]  = max(rest[i-1] - price, buy[i-1]) 
sell[i] = max(buy[i-1] + price, sell[i-1])
rest[i] = max(sell[i-1], buy[i-1], rest[i-1])

但是我们要提防[buy,rest,buy]的出现，因为buy[i]<=rest[i],所以rest[i]=max(sell[i-1], rest[i-1]),就会保证[buy,rest,buy]不出现。
另外，由于冷冻期的存在，所以rest[i]=sell[i-1]。因此，递推式便可以精简为：
buy[i]  = max(sell[i-2] - price, buy[i-1]) 
sell[i] = max(buy[i-1] + price, sell[i-1])
 */
public class BestTimeToBuyAndSellStockWithCooldown {
	public static void main(String[] args) {
		
	}
}
class Solution272 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=0) return 0;
        
        int b0=-prices[0], b1=b0;
        int s0=0, s1=0, s2=0;
        
        for(int i=1;i<prices.length;i++)
        {
        	b0=Math.max(s2-prices[i], b1);
        	s0=Math.max(s1, b1+prices[i]);
        	
        	b1=b0; s2=s1; s1=s0;
        }
        return s0;
    }
}