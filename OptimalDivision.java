/**
 * 题目：最优的划分。给定一个数组，请将其连接成为一个式子，需要在它不同的地方加括号，确保最终的结果最大并返回式子的字符串形式。
 * 例如：
 * Input: [1000,100,10,2]
 * Output: "1000/(100/10/2)"
 * 解题思路：
 * 按照顺序计算时，最后一个除法的被除数越大并且除数越小，最终结果越大。由于所有数都是大于2的正数，所以被除数必须不包含除法，除数包含最多的除法，此时结果最大。因此结果是形如”A/(B/C/D….)。 
 *
 */
import java.util.Scanner;
public class OptimalDivision {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);

		Solution247 sl=new Solution247();
		System.out.println("结果是："+sl.optimalDivision(nums));
	}

}
class Solution247
{
	public String optimalDivision(int[] nums)
	{
		String result="";
		if(nums==null || nums.length<=0) return result;
		int n=nums.length;
		
		if(n==1) return String.valueOf(nums[0]);
		if(n==2) return String.valueOf(nums[0])+"/"+String.valueOf(nums[1]);
		
		result+=String.valueOf(nums[0])+"/"+"(";
		for(int i=1;i<n-1;i++)
		{
			result+=String.valueOf(nums[i])+"/";
		}
		result+=String.valueOf(nums[n-1])+")";
		return result;
	}
}