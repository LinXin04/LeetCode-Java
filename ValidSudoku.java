/**
 * 题目：有效的数独。
 * 判断已经填入的数字是否合法，那么需要判断每行每列以及每个9宫格的数字是否有重复。
 * 解题思路：
 * 很自然的联想到HashSet,因为每个Set里面的元素是不能相同的。顺着这个思路，那么我们为行、列及九宫格各设置9个Hashset元素的数组，每次进行判断即可。
 *
 */
import java.util.HashSet;

public class ValidSudoku {
	public static void main(String[] args) {
		
	}
}

class Solution293
{
	public boolean isValidSudoku(char[][] board)
	{
		if(board==null || board.length==0) return true;
		HashSet[] raw=new HashSet[9];
		HashSet[] col=new HashSet[9];
		HashSet[] cell=new HashSet[9];
		
		for(int i=0;i<9;i++)
		{
			raw[i]=new HashSet();
			col[i]=new HashSet();
			cell[i]=new HashSet();	
		}
		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(board[i][j]!='.')
				{
					if(raw[i].contains(board[i][j]) || col[j].contains(board[i][j]) || cell[3*(i/3)+j/3].contains(board[i][j]))
						return false;
					else
					{
						raw[i].add(board[i][j]);
						col[j].add(board[i][j]);
						cell[3*(i/3)+j/3].add(board[i][j]);
					}
				}
			}
		}
		return true;	
	}
}
