/**
 * 题目：给定一个包含n个正整数的一维数组X。从(0,0)点出发先向北移动X[0]米，然后向西移动X[1]米，向南移动X[2]米，向东移动X[3]米，以此类推。
 * 也就是说，每次移动之后都逆时针旋转一次。判断移动后，该图形是不是存在自我相交。
 * 解题思路：
 * 自我相交的情况分为三种：
 * 1、第四条边与第一条边相交的情况。条件：第一条边>=第三条边  && 第四条边>=第二条边   （同理，5与2；6与3....）
 * 2、第五条边与第一条边相交的情况。条件：第二条边=第四条边  && 第五条边+第一条边>=第三条边 （同理，6与2；7与3....）
 * 3、第六条边与第一条边相交的情况。条件：第四条边>=第二条边  && 第三条边>=第五条边 && 第五条边>=第三条边-第一条边  &&  第六条边>=第四条边-第二条边  （同理，7与2....）
 */
import java.util.Scanner;
public class SelfCrossing {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数组：");
		String st=sc.nextLine();
		String[] s=st.split(" ");
		int x[]=new int[s.length];
		for(int i=0;i<s.length;i++)
			x[i]=Integer.parseInt(s[i]);
		Solution173 sl=new Solution173();
		System.out.println("结果是："+sl.isSelfCrossing(x));
	}
}
class Solution173 {
    public boolean isSelfCrossing(int[] x) {
        if(x.length==0) return false;
        
        for(int i=3;i<x.length;i++)
        {
        	//1、第四条边与第一条边相交的情况。条件：第一条边>=第三条边  && 第四条边>=第二条边
        	if(x[i-3]>=x[i-1] && x[i]>=x[i-2]) return true;
        	//2、第五条边与第一条边相交的情况。条件：第二条边=第四条边  && 第五条边+第一条边>=第三条边
        	if(i>=4 && x[i-3]==x[i-1] && x[i]+x[i-4]>=x[i-2]) return true;
        	//3、第六条边与第一条边相交的情况。条件：第四条边>=第二条边  && 第三条边>=第五条边 && 第五条边>=第三条边-第一条边  &&  第六条边>=第四条边-第二条边
        	if(i>=5 && x[i-2]>=x[i-4] && x[i-3]>=x[i-1] && x[i-1]>=x[i-3]-x[i-5] && x[i]>=x[i-2]-x[i-4]) return true;
        }
        
        return false;
    }
}