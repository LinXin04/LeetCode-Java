/**
 * 题目：寻找第n个超级丑数。在这里，超级丑数是指满足质因子只能是给定的质因子的数。
 * 例如：
 * given primes = [2, 7, 13, 19]，[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers
 * 解题思路：
 * 本题其实就是在前面的题的基础上，增加一个难度：我们不知道primes的位置，在这里使用index数组来存储，然后从每个子链中取出一个数，找出最小值，更新index数组对应的位置。
 *
 */
import java.util.*;
public class SuperUglyNumber {

	public static void main(String[] args) {
		System.out.println("请输入一个数字：");
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		
		System.out.println("请输入一个质因子数组：");
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int primes[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			primes[i]=Integer.parseInt(st[i]);
		
		Solution149 sl=new Solution149();
		System.out.println("结果是："+sl.nthSuperUglyNumber(n, primes));
	}

}
class Solution149 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes==null) return 0;
        ArrayList<Integer> result=new ArrayList<Integer>();
        result.add(1);
        
        int[] index=new int[primes.length];
        
        while(result.size()<n)
        {
        	ArrayList<Integer> temp=new ArrayList<Integer>();
        	int Ugly=Integer.MAX_VALUE;
        	
        	//计算本轮的值
        	for(int i=0;i<primes.length;i++)
        		temp.add(result.get(index[i])*primes[i]);
        	
        	//寻找本轮的丑数
        	for(int i=0;i<primes.length;i++)
        		Ugly=Math.min(Ugly, temp.get(i));
        	
        	//更新所有的index
        	for(int i=0;i<primes.length;i++)
        	{
        		if(Ugly==temp.get(i)) ++index[i];
        	}
        	result.add(Ugly);
        }
        return result.get(n-1);
    }
}