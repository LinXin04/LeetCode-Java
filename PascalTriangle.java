/**
 * 
 * 题目：给定一个数字，求该数字对应行数的杨辉三角
 * given numRows = 5,
 * Return
 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 * ]
 * 解题思路：根据杨辉三角的特点：第一行是1，第2行是1,1，第三行开始，除了两边的是1外，中间的都是上面一行相邻两个数的和。
 *
 */
import java.util.Scanner;
import java.util.ArrayList;
public class PascalTriangle {

	public static void main(String[] args) {
		System.out.println("请输入一个数字行数：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int numRow=Integer.parseInt(s);
		
		Solution36 sl=new Solution36();
		ArrayList<ArrayList<Integer>> result=sl.generate(numRow);
		System.out.println("结果是：");
		System.out.println("[");
		for(int i=0;i<result.size();i++)
		{
			System.out.print("[");
			for(int j=0;j<result.get(i).size();j++)
				System.out.print(result.get(i).get(j)+" ");
			System.out.print("]");
			System.out.println();
		}
		System.out.println("]");
	}

}
class Solution36
{
	public ArrayList<ArrayList<Integer>> generate(int numRows)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(numRows<=0) return result;
		
		ArrayList<Integer> temp=new ArrayList<Integer>();
		
		//首先将第一行的[1]加入
		temp.add(1);
		result.add(temp);
		//每一行，共numRow行
		for(int i=1;i<numRows;i++)
		{
			ArrayList<Integer> t=new ArrayList<Integer>();
			//将每一行的第一个元素加入
			t.add(1);
			//每一行的第j个元素
			for(int j=1;j<temp.size();j++)
				t.add(temp.get(j-1)+temp.get(j));
			//将每一行的最后一个元素加入
			t.add(1);
			result.add(t);
			temp=t;
		}
		return result;
	}
}