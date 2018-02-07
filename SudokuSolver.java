/**
 * 题目：按照规则完成数独矩阵。
 * 解题思路：
 * 使用回溯和HashSet的方法。对于每一个空白位置，试探的使用‘1’-'9’之间的数字，如果加入该数字在满足数独规则的情况下，将该字符加入该位置，向下去试探；如果试探失败，则回到当前这步，换另一个字符继续进行试探。
 *
 */
public class SudokuSolver {
	public static void main(String[] args) {
		
	}
}

class Solution294
{
	public void solveSudoku(char[][] board)
	{
		if(board==null || board.length==0) return;
		helper(board);
	}
	
	public boolean helper(char[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				if(board[i][j]=='.')
				{
					for(char c='1';c<='9';c++)
					{
						if(isValid(board,i,j,c))
						{
							board[i][j]=c;
							
							if(helper(board)) return true;
							else board[i][j]='.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	//board[raw][col]=c时，检验raw行col列是否满足数独的规则
	public boolean isValid(char[][]board,int raw,int col,char c)
	{
		for(int i=0;i<9;i++)
		{
			if(board[raw][i]!='.' &&  board[raw][i]==c) return false;
			if(board[i][col]!='.' &&  board[i][col]==c) return false;
			if(board[3*(raw/ 3)+i/3][3*(col/3)+i%3]!='.' && 
					board[3*(raw/3)+i/3][3*(col/3)+i%3]==c) return false;
		}
		return true;
	}
}