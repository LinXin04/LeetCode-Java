/**
 * 题目：整数拆分：给定一个正整数n,将它拆成至少两个正整数，使得所有整数的乘积最大。
 * 例如：given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4)
 * 解题思路：
 * 
 * 正整数从1开始，但是1不能拆分成两个正整数之和，所以不能当输出。
 * 2只能拆成1+1，所以乘积也为1。
 * 数字3可以拆分成2+1，乘积最大，为2。
 * 数字4拆成2+2，乘积最大，为4。
 * 数字5拆成3+2，乘积最大，为6。
 * 数字6拆成3+3，乘积最大，为9。
 * 数字7拆为3+4，乘积最大，为12。
 * 数字8拆为3+3+2，乘积最大，为18。
 * 数字9拆为3+3+3，乘积最大，为27。
 * 数字10拆为3+3+4，乘积最大，为36。
 * 
 * 由上面我们可以看出：从数字5开始，每一个都是不断的分成3,3,....,2/4.
 * 
 */
import java.util.Scanner;
public class IntegerBreak {
	public static void main(String[] args) {	
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字：");
		int n=sc.nextInt();
		Solution174 sl=new Solution174();
		System.out.println("结果是："+sl.integerBreak(n));
	}
}
class Solution174 {
    public int integerBreak(int n) {
        if(n==2 || n==3) return n-1;
        int result=1;
        
        while(n>4)
        {
        	result*=3;
        	n-=3;
        }
        if(n!=0)
        	result=result*n;
        return result;
    }
}