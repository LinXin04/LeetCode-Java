/**
 * 题目：
 * 给定一个二维的数组和一个target，该数组每一行都是按照升序排列的，每一行的第一个数都比上一行的最后一个数大。求在该数组中是否有target存在
 * 例子：
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * Given target = 3, return true.
 * 解题思路：
 * 用两个二分查找，一个查找到当前的行，一个查找到target。
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class SearchA2DMatrix {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入一个二维数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
		while(true)
		{
			String s=buf.readLine();
			if(s.equals("")) break;
			String st[]=s.split(" ");
			ArrayList<Integer> t=new ArrayList<Integer>();
			for(int i=0;i<st.length;i++)
				t.add(Integer.parseInt(st[i]));
			temp.add(t);
		}
		int [][]matrix=new int[temp.size()][temp.get(0).size()];
		for(int i=0;i<temp.size();i++)
		{
			for(int j=0;j<temp.get(0).size();j++)
				matrix[i][j]=temp.get(i).get(j);
		}
		
		System.out.println("请输入target：");
		int target=Integer.parseInt(buf.readLine());
		Solution70 sl=new Solution70();
		boolean result=sl.searchMatrix(matrix, target);
		System.out.println("结果是："+result);
		
	}

}
class Solution70
{
	public boolean searchMatrix(int[][] matrix,int target)
	{
		if(matrix==null || matrix.length ==0 ||matrix[0].length==0) return false;
		int Row=matrix.length;
		int Column=matrix[0].length;
		
		//首先找到该元素所在的行
		int left=0;
		int right=Row-1;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(matrix[mid][0]==target) return true;
			else if(matrix[mid][0]<target) left=mid+1;
			else right=mid-1;
		}
		
		//现在找出了所在的行就是right
		if(right<0) return false;
		
		//寻找该元素在该行的哪个位置
		int currentRow=right;
		int rLeft=0;
		int rRight=Column-1;
		while(rLeft<=rRight)
		{
			int rMid=(rLeft+rRight)/2;
			if(matrix[currentRow][rMid]==target) return true;
			else if(matrix[currentRow][rMid]<target) rLeft=rMid+1;
			else rRight=rMid-1;
		}
		
		return false;
	}
}