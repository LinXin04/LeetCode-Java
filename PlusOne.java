/**
 * 
 * 题目：给定一个非空数组，该数组存储的是一个非负整数的每一位数字，最高位在数组的第0位。我们对这个数字进行+1，求返回的数组
 * 例如：
 * 给定[1 9 9 9]
 * 返回[2 0 0 0]
 * 解题思路：(扫描一次，O(N))
 * 从最低位开始，进行加一，如果有进位则继续对下一位进行加1，如果没有则返回即可。
 * 需要特别注意的是：如果最高位仍有进位的话，就需要new一个数组，然后把第一位置为1，其他位置为0
 * 
 */
import java.util.Scanner;
public class PlusOne {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String []st=s.split(" ");
		int digits[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			digits[i]=Integer.parseInt(st[i]);
		
		Solution47 sl=new Solution47();
		int []result=sl.plusOne(digits);
		System.out.println("结果是：");
		System.out.print("[");
		for(int i=0;i<digits.length;i++)
			System.out.print(digits[i]+" ");
		System.out.print("]");
	}
}
class Solution47
{
	public int[] plusOne(int[] digits)
	{
		int Length=digits.length;
		if(Length==0) return digits;
		
		//定义一个进位
		int carry=1;
		for(int i=Length-1;i>=0;i--)
		{
			int Sum=digits[i]+carry;
			digits[i]=Sum%10;
			carry=Sum/10;
			if(carry==0) return digits;
		}
		
		//如果最后一位还有进位，增大空间，第一位设为1
		int[] result=new int[Length+1];
		result[0]=1;	
		return result;
	}
}