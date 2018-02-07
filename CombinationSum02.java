/**
 * 
 * 题目：组合之和：给定一个候选数据集C，里面有重复元素且全为正整数，和一个数字target。寻找所有的加和为T的情况，C中的元素不可以重复使用。
 * 例如：
 * given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8
 * A solution set is: 
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 解题思路：(NP完全问题)
 * 与上面的题目思路相似，只需要改动一点点即可，就是在递归的时候，传进去的index应该从i+1开始
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class CombinationSum02 {

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
		
		Solution46 sl=new Solution46();
		ArrayList<ArrayList<Integer>> result=sl.combinationSum2(candidates, target);
		
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
class Solution46
{
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,int target)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(candidates==null || candidates.length==0) return null;
		if(target==0) return result;
		
		//先对数组进行排序
		Arrays.sort(candidates);
		backTracking(candidates,0,target,new ArrayList<Integer>(),result);
		return result;
		
	}
	//回溯法
	public void backTracking(int [] candidates,int start,int target,ArrayList<Integer> cur,ArrayList<ArrayList<Integer>> result)
	{
		if(target==0)
		{
			result.add(new ArrayList<Integer>(cur));
		}else{
			
			for(int i=start;i<candidates.length && candidates[i]<=target;i++)
			{
				//因为数组中会有重复元素，所以为了避免输出的结果有重复的，要进行处理：
				if(i>start && candidates[i]==candidates[i-1]) continue;
				cur.add(candidates[i]);
				//注意:下面这个地方一定要改成i+1，这样就不会重复使用某元素
				backTracking(candidates,i+1,target-candidates[i],cur,result);
				cur.remove(cur.size()-1);
			}
		}
	}
}