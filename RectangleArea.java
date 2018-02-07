/**
 * 题目：给定两个矩形，求真正的面积（除去相交的区域）
 * 解题思路：
 * 判断两个矩形是否相交，如果不相交，则直接加和；否则减掉重复的。
 * 不相交的情况只有四种，上下左右.
 * 求交集区域的长和宽也不难，由于交集都是在中间，所以
 * 横边的左端点是两个矩形左顶点横坐标的较大值，
 * 右端点是两个矩形右顶点的较小值，
 * 竖边的下端点是两个矩形下顶点纵坐标的较大值，
 * 上端点是两个矩形上顶点纵坐标的较小值。
 *
 */
import java.util.Scanner;
public class RectangleArea {

	public static void main(String[] args) {
		System.out.println("请输入四个坐标：");
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();
		int D=sc.nextInt();
		int E=sc.nextInt();
		int F=sc.nextInt();
		int G=sc.nextInt();
		int H=sc.nextInt();
		
		Solution165 sl=new Solution165();
		System.out.println("结果是："+sl.computeArea(A, B, C, D, E, F, G, H));
	
	}

}
class Solution165
{
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
	{
		int Sum=(C-A)*(D-B)+(G-E)*(H-F);
		if(E>=C || G<=A || H<=B || D<=F) return Sum;
		else return Sum-(Math.min(C, G)-Math.max(A, E))*(Math.min(D, H)-Math.max(B, F));
	}
}