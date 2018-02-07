/**
 * 题目：给定一个二维矩阵，如果有元素为0，则把对应的行和列上面的元素都置为0。
 * 这里最大的问题是，我们遇到0的时候不能直接把矩阵的行列在当前矩阵直接置0，否则后面还没访问到的会被当成原来是0，最后会把很多不该置0的行列都置0了。
 * 解题思路：
 * 空间复杂度为O(mn)的解法：直接新建一个和matrix等大小的矩阵，然后一行一行的扫，只要有0，就将新建的矩阵的对应行全赋0，行扫完再扫列，然后把更新完的矩阵赋给matrix即可，这个算法的空间复杂度太高。
 * 将其优化到O(m+n)的方法是，用一个长度为m的一维数组记录各行中是否有0，用一个长度为n的一维数组记录各列中是否有0，最后直接更新matrix数组即可。
 * - 先扫描第一行第一列，如果有0，则将各自的flag设置为true
 * - 然后扫描除去第一行第一列的整个数组，如果有0，则将对应的第一行和第一列的数字赋0
 * - 再次遍历除去第一行第一列的整个数组，如果对应的第一行和第一列的数字有一个为0，则将当前值赋0
 * - 最后根据第一行第一列的flag来更新第一行第一列
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class SetMatrixZeroes {

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
		
		Solution69 sl=new Solution69();
		sl.setZeroes(matrix);
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
				System.out.print(matrix[i][j]+",");
			System.out.println("");
		}
	}
}

class Solution69
{
	public void setZeroes(int[][] matrix)
	{
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return;
		int Row=matrix.length;
		int Column=matrix[0].length;
		
		boolean Rflag=false;
		boolean Cflag=false;
		//如果第一行或者第一列有0，则将其记录下来
		for(int i=0;i<Row;i++)
		{
			if(matrix[i][0]==0) Cflag=true;
		}
		for(int j=0;j<Column;j++)
		{
			if(matrix[0][j]==0) Rflag=true;
		}  
		
		//扫描除去第一行和第一列的元素
		for(int i=1;i<Row;i++)
		{
			for(int j=1;j<Column;j++)
			{
				if(matrix[i][j]==0)
				{
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		//再次遍历除去第一行第一列的整个数组，如果对应的第一行和第一列的数字有一个为0，则将当前值赋0
		for(int i=1;i<Row;i++)
		{
			for(int j=1;j<Column;j++)
			{
				if(matrix[i][0]==0 || matrix[0][j]==0)
					matrix[i][j]=0;
			}
		}
		
		if(Cflag) 
		{
			for(int i=0;i<Row;i++)
				matrix[i][0]=0;
		}
		if(Rflag) 
		{
			for(int i=0;i<Column;i++)
				matrix[0][i]=0;
		}
	}
}