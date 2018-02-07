/**
 * 题目：地牢游戏。
 * 有mxn个格子，皇后在右下角，勇士在左上角，
 * 现在勇士要去救皇后，每步可以往下或往右走，每个格子里的数字表示勇士到该处时要消耗或增加的魔力，
 * （负数表示消耗，正数表示增加），不论何时只要勇士的魔力小于等于0，勇士立即死掉。问勇士初始至少要有多少魔力？
 * 解题思路：
 * 动态规划。
 * 定义dp[i][j]表示第i行第j列需要多少魔法值。
 * 从后向前遍历。
 * 如果当前位置魔力正且大于等于右边/下边需要的魔力，则该处不需要额外的魔力，否则，勇士到达该处时需有一定的魔力来满足该处和右边/下边需要的魔力。
 */
import java.util.ArrayList;
import java.util.Scanner;
public class DungeonGame {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals("")) break;
			String st[]=s.split(" ");
			ArrayList<Integer> t=new ArrayList<Integer>();
			for(int i=0;i<st.length;i++)
				t.add(Integer.parseInt(st[i]));
			temp.add(t);
		}
		
		int[][] dungeon=new int[temp.size()][temp.get(0).size()];
		for(int i=0;i<temp.size();i++)
		{
			for(int j=0;j<temp.get(i).size();j++)
				dungeon[i][j]=temp.get(i).get(j);
		}
		
		Solution270 sl=new Solution270();
		System.out.println("结果是："+sl.calculateMinimumHp(dungeon));
	}
}
class Solution270
{
	public int calculateMinimumHp(int[][] dungeon)
	{
		if(dungeon==null || dungeon.length==0) return 0;
		
		int m=dungeon.length;
		int n=dungeon[0].length;
		
		int dp[][]=new int[m][n];
		dp[m-1][n-1]=dungeon[m-1][n-1]>0?0:-dungeon[m-1][n-1];
		
		//最后一列
		for(int i=m-2;i>=0;i--)
			dp[i][n-1]=dungeon[i][n-1]>=dp[i+1][n-1]?0:dp[i+1][n-1]-dungeon[i][n-1];
			
		//最后一行
		for(int i=n-2;i>=0;i--)
			dp[m-1][i]=dungeon[m-1][i]>=dp[m-1][i+1]?0:dp[m-1][i+1]-dungeon[m-1][i];
			
		//从右下角到左上角遍历
		for(int i=m-2;i>=0;i--)
		{
			for(int j=n-2;j>=0;j--)
			{
				int down=dungeon[i][j]>=dp[i+1][j]?0:dp[i+1][j]-dungeon[i][j];
				int right=dungeon[i][j]>=dp[i][j+1]?0:dp[i][j+1]-dungeon[i][j];
				dp[i][j]=Math.min(down, right);
			}
		}
		//1表示保证勇士是活着的
		return dp[0][0]+1;
	}
}