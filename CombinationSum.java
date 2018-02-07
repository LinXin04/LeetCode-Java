/**
 * 题目：组合之和：给定一个候选数据集C，里面没有重复元素且全为正整数，和一个数字target。寻找所有的加和为T的情况，C中的元素可以重复使用。
 * 例如：
 * given candidate set [2, 3, 6, 7] and target 7
 * A solution set is: 
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * 解题思路：(NP完全问题)
 * 首先对数组进行排序，然后每次递归中把剩下的元素一一加到结果集中，并且把目标减去加入的元素，然后把剩下元素（包括当前加入的元素）放入下一层递归中解决子问题
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class CombinationSum {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] candidates=new int[st.length];
		for(int i=0;i<st.length;i++)
			candidates[i]=Integer.parseInt(st[i]);
		
		System.out.println("请输入一个target：");
		int target=sc.nextInt();
		
		Solution45 sl=new Solution45();
		ArrayList<ArrayList<Integer>> result=sl.combinationSum(candidates, target);
		
		System.out.println("结果是:");
		System.out.println("[");
		for(int i=0;i<result.size();i++)
		{
			System.out.print("[ ");
			for(int j=0;j<result.get(i).size();j++)
				System.out.print(result.get(i).get(j)+" ");
			System.out.println("]");
		}
		System.out.println("]");
	}
}

class Solution45
{
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,int target)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(candidates==null || candidates.length==0) return null;
		int Length=candidates.length;
		if(target==0) return result;
		
		//首先对数组进行排序
		Arrays.sort(candidates);
		//当前的解cur
		ArrayList<Integer> cur=new ArrayList<Integer>();
		backTracking(candidates,0,target,cur,result);
		return result;
		
	}
	public void backTracking(int[] candidates,int start,int target,ArrayList<Integer> cur,ArrayList<ArrayList<Integer>> result)
	{
		if(target==0)
		{
			result.add(new ArrayList<Integer>(cur));
		}
		else
		{
		for(int i=start;i<candidates.length && candidates[i]<=target;i++)
		{
			cur.add(candidates[i]);
			backTracking(candidates,i,target-candidates[i],cur,result);
			//最后一个元素减掉
			cur.remove(cur.size()-1);
		}
	}
	}
}