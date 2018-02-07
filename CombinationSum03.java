/**
 * 题目：给定一个k和一个n,要求返回1-9中k个数字加起来等于n的集合
 * 例如：
 * Input: k = 3, n = 7
 * Output:[[1,2,4]]
 * 
 * Input: k = 3, n = 9
 * Output:[[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 解题思路：
 * 回溯的思想
 * 与上面两题相似
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class CombinationSum03 {

	public static void main(String[] args) {
		System.out.println("请输入一个整数k:");
		Scanner sc=new Scanner(System.in);
		int k=Integer.parseInt(sc.nextLine());
		
		System.out.println("请输入一个整数n:");
		int n=Integer.parseInt(sc.nextLine());
		
		Solution60 sl=new Solution60();
		ArrayList<ArrayList<Integer>> result=sl.combinationSum3(k, n);
		System.out.println("结果是：");
		System.out.print("[");
		for(int i=0;i<result.size();i++)
		{
			System.out.print("[ ");
			for(int j=0;j<result.get(i).size();j++)
				System.out.print(result.get(i).get(j)+" ");
			System.out.print("]");
		}
		System.out.print("]");
	}
}
class Solution60
{
	public ArrayList<ArrayList<Integer>> combinationSum3(int k,int n)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(k<=0 || n<=0) return result;
		
		backTracking(k,n,1,new ArrayList<Integer>(),result);
		return result;
	}
	public void backTracking(int k,int target,int level,ArrayList<Integer> cur,ArrayList<ArrayList<Integer>> result)
	{
		//如果目标值为0，并且数组的长度为k
		if(target==0 && cur.size()==k)
		{
			result.add(new ArrayList<Integer>(cur));
		}else
		{
			for(int i=level;i<=9;i++)
			{
				cur.add(i);
				backTracking(k,target-i,i+1,cur,result);
				cur.remove(cur.size()-1);
			}
		}
	}
}