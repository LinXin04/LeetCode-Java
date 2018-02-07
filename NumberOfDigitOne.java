/**
 * 题目：给定一个整数n,求在小于等于n的非负整数中一共出现过几次1.
 * 例如：
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 解題思路：
 * 1的个数                                    含1的数字                                                                                                                                                                                                   数字范围
 * 
 * 1                   1                                                                                    [1, 9]
 * 11                  10  11  12  13  14  15  16  17  18  19                                               [10, 19]
 * 1                   21                                                                                   [20, 29]
 * 1                   31                                                                                   [30, 39]
 * 1                   41                                                                                   [40, 49]
 * 1                   51                                                                                   [50, 59]
 * 1                   61                                                                                   [60, 69]
 * 1                   71                                                                                   [70, 79]
 * 1                   81                                                                                   [80, 89]
 * 1                   91                                                                                   [90, 99]
 * 11                  100  101  102  103  104  105  106  107  108  109                                      [100, 109]
 * 21                  110  111  112  113  114  115  116  117  118  119                                      [110, 119]
 * 11                  120  121  122  123  124  125  126  127  128  129                                      [120, 129]
 * 
 * 有上面可以看出，兩位數中，除了[10,19]之間其他都是1個1,[10-19]之間是11个1.
 * 三位数中，除了[100,109]之间其他都是2个1，[100,109]之间是21个1.
 * 那么我们在对任意一个两位数，十位数上的数字(加1)就代表1出现的个数，这时候我们再把多出的10个加上即可。
 * 如何知道是否要加上多出的10个呢，我们就要看十位上的数字是否大于等于2，是的话就要加上多余的10个'1'。那么我们就可以用(x+8)/10来判断一个数是否大于等于2。
 */
import java.util.*;
public class NumberOfDigitOne {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入整数n：");
		int n=sc.nextInt();
		Solution167 sl=new Solution167();
		System.out.println("结果是："+sl.countDigitOne(n));
	}
}
class Solution167
{
	public int countDigitOne(int n)
	{
		if(n<1) return 0;
		int result=0;
		for(long m=1;m<=n;m=m*10)
		{
			long a=n/m, b=n%m;
			result+=(a+8)/10*m;
			if(a%10==1)  result+=b+1;
		}
		return result;
	}
}