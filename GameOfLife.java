/**
 * 题目：康威生命游戏：
 * 每个细胞的状态由该细胞及周围八个细胞上一次的状态所决定
 * 1代表活；0代表死
 * 1.如果该细胞当前的状态为1，其8个邻居中的活细胞个数少于2个，那么它就会死亡；
 * 2.如果该细胞当前的状态为1，其8个邻居中的活细胞个数等于2个或者3个，那么它就会生存；
 * 3.如果该细胞当前的状态为1，其8个邻居中的活细胞个数多于3个，那么它就会死亡；
 * 4.如果该细胞当前的状态为0，其8个邻居中的活细胞个数等于3个，那么它就会生存；
 */
import java.util.ArrayList;
import java.util.Scanner;
public class GameOfLife {
	public static void main(String[] args) {
		System.out.println("请输入一个数组：");
		ArrayList<ArrayList<Integer>> nums=new ArrayList<ArrayList<Integer>>();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals(""))break;
			String st[]=s.split(" ");
			ArrayList<Integer> emp=new ArrayList<Integer>();
			for(int i=0;i<st.length;i++)
				emp.add(Integer.parseInt(st[i]));
			nums.add(emp);
		}

		int[][] board=new int[nums.size()][nums.get(0).size()];
		for(int i=0;i<nums.size();i++)
		{
			for(int j=0;j<nums.get(0).size();j++)
				board[i][j]=nums.get(i).get(j);	
		}
		Solution92 sl=new Solution92();
		sl.gameOfLife(board);
		System.out.println("结果是：");
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}

}

class Solution92
{
	public void gameOfLife(int[][] board)
	{
		if(board==null || board.length==0 || board[0].length==0) return;
		int m=board.length;
		int n=board[0].length;
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				int count=getLive(board,i,j);
				//死细胞->活细胞，设为3
				if(board[i][j]==0 && count==3)
					board[i][j]=3;
				else if(board[i][j]==1 && (count<2 || count>3))
					//活细胞->死细胞，设为2
					board[i][j]=2;
				//其他情况下，board[i][j]是不变的
			}
		}
		
		//上述变换后，为1，为2的都是开始为1的细胞，为3的是开始为0的细胞
		//将变换后，活的细胞设为1，死的细胞设为0
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				board[i][j]%=2;
		}
		
	}
	
	//得到board[i][j]旁边的活细胞个数
	public int getLive(int[][] board,int i,int j)
	{
		int m=board.length;
		int n=board[0].length;
		
		int count=0;
		for(int x=-1;x<2;x++)
		{
			for(int y=-1;y<2;y++)
			{
				int newX=i+x;
				int newY=j+y;
				//如果是本细胞，则直接跳出
				if(newX==i && newY==j) continue;
				if(newX>=0 && newY>=0 && newX<m && newY<n)
				{
					//这个地方注意不可忘记等于2的情况
					if(board[newX][newY]==1 || board[newX][newY]==2) count++;
				}
			}
		}
		return count;
	}
}