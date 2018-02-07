/**
 * 题目：给定一个字符串，包含U(up)、Down(D)、Left(L)、Right(R)。问走完整个字符串后，是否能回到原来的位置
 * 解题思路：
 * 定义x：表示横着走，L:x--,R:x++
 * y:表示纵着走，U：y++,D:y--
 * 最后判断 x==0 && y==0
 */
import java.util.Scanner;
public class JudgeRouteCircle {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String moves=sc.nextLine();

		Solution241 sl=new Solution241();
		System.out.println("结果是："+sl.judgeCircle(moves));
	}
}
class Solution241
{
	public boolean judgeCircle(String moves)
	{
		if(moves==null || moves.length()==0) return false;
		
		int x=0,y=0;
		for(int i=0;i<moves.length();i++)
		{
			char ch=moves.charAt(i);
			if(ch=='L') x--;
			else if(ch=='R') x++;
			else if(ch=='U') y++;
			else y--;
		}
		return x==0 && y==0;
	}
}