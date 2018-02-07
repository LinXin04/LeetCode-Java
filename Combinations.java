/**
 * 题目：给定两个整数n和k,求k个数字的不同组合有几种，每种组合中的数字只能是[1,n].
 * 解题思路：
 * 使用递归的方法来解决。
 */
import java.util.ArrayList;
public class Combinations {
	public static void main(String[] args) {
		
	}
}

class Solution295
{
	public ArrayList<ArrayList<Integer>> combine(int n, int k)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(k>n) return result;
		
		helper(result,new ArrayList<Integer>(),1,n,k);
		
		return result;
	}
	
	public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp,int start,int n,int k)
	{
		if(k==0)
		{
			result.add(temp);
			return;
		}
		for(int i=start;i<=n;i++)
		{
			temp.add(i);
			helper(result,temp,i+1,n,k-1);
			temp.remove(temp.size()-1);
		}
	}
}