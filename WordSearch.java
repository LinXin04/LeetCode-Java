/**
 * 题目：给定一个二维的字符数组和一个字符串，如果这个字符串可以由数组中一串连续（包括水平和垂直）的元素组成，则返回true,否则返回false
 * 例如：
 * Given board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 解题思路：
 * 深度优先搜索：
 * 从每一个字符出发，上下左右深度搜索是否有等于Word的字符串。
 */
import java.io.*;
import java.util.ArrayList;
public class WordSearch {
	public static void main(String[] args) throws IOException {
		System.out.println("请输入二维的字符数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		ArrayList<ArrayList<Character>> temp=new ArrayList<ArrayList<Character>>();
		while(true)
		{
			String s=buf.readLine();
			if(s.equals("")) break;
			String []st=s.split(" ");
			ArrayList<Character> t=new ArrayList<Character>();
			for(int i=0;i<st.length;i++)
				t.add(st[i].charAt(0));
			temp.add(t);
		}
		char[][] board=new char[temp.size()][temp.get(0).size()];
		for(int i=0;i<temp.size();i++)
		{
			for(int j=0;j<temp.get(i).size();j++)
				board[i][j]=temp.get(i).get(j);	
		}

		System.out.println("请输入一个target：");
		String word=buf.readLine();
		Solution72 sl=new Solution72();
		boolean result=sl.exist(board, word);
		System.out.println("结果是："+result);
	}

}
class Solution72
{
	public boolean exist(char[][] board,String word)
	{
		if(board==null || board.length==0 || board[0].length==0) return false;
		if(word==null || word.length()==0) return false;
		
		int Row=board.length;
		int Column=board[0].length;
		
		//用一个used表示该数组中那些元素是已经使用过的
		boolean used[][]=new boolean[Row][Column];
		//遍历一遍所有的元素，看如果从某个元素出发可以得到word，就返回True。
		for(int i=0;i<Row;i++)
		{
			for(int j=0;j<Column;j++)
			{
				if(search(board,word,0,i,j,used))
					return true;
			}
		}
		return false;
	}
	
	public boolean search(char[][] board,String word,int index,int i,int j,boolean[][]used)
	{
		int row=board.length;
		int column=board[0].length;
		
		//index表示现如今已经匹配的字符串长度
		if(index==word.length()) return true;

		//如果出现下列情况则返回false
		if(i<0 || i>=row || j<0 || j>=column || used[i][j]==true || board[i][j]!=word.charAt(index))
			return false;
		
		//首先将used置为True
		used[i][j]=true;
		boolean result=search(board,word,index+1,i-1,j,used)
				|| search(board,word,index+1,i+1,j,used)
				|| search(board,word,index+1,i,j-1,used)
				|| search(board,word,index+1,i,j+1,used);
		//虽然单次搜索字符不能重复使用，但是每次从一个新的元素出发，字符还是重新可以用的
		used[i][j]=false;
		return result;
	}
}