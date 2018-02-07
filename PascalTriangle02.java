import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目：在上一题杨辉三角的例子中，我们输入一个数字，只需要返回当行的数据即可
 * 例子：
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 解题思路：Pascal's Triangle中因为是求出全部结果，所以我们需要上一行的数据就很自然的可以去取。
 * 而这里我们只需要一行数据，就得考虑一下是不是能只用一行的空间来存储结果而不需要额外的来存储上一行呢？
 * 这里确实是可以实现的。
 * 对于每一行我们知道如果从前往后扫，第i个元素的值等于上一行的res[i]+res[i+1]，可以看到数据是往前看的，
 * 如果我们只用一行空间，那么需要的数据就会被覆盖掉,所以这里采取的方法是从后往前扫，这样每次需要的数据就是res[i]+res[i-1]，我们需要的数据不会被覆盖，因为需要的res[i]只在当前步用，下一步就不需要了。
 */
public class PascalTriangle02 {

	public static void main(String[] args) {
		System.out.println("请输入一个数字行数：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int rowIndex=Integer.parseInt(s);
		
		Solution37 sl=new Solution37();
		ArrayList<Integer> result=sl.getRow(rowIndex);
		System.out.println("结果是：");
		System.out.print("[");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
		System.out.print("]");
		
		

	}

}
class Solution37
{
	public ArrayList<Integer> getRow(int rowIndex)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(rowIndex<0) return result;
		//首先将第一个元素加入
		result.add(1);
		for(int i=1;i<=rowIndex;i++)
		{
			//从后边向前面扫描，不然的话这一行前面的元素会被覆盖掉，从而不能实现一个空间来实现该函数
			for(int j=result.size()-1;j>0;j--)
				result.set(j,result.get(j-1)+result.get(j));
			result.add(1);
		}
		return result;
	}
}