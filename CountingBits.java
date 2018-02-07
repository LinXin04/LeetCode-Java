/**
 * 题目：给定一个数字num，求1-num中所有数字的二进制形式中1的个数，并返回数组。
 * 解题思路：
 * 经过观察，我们发现以下规律：
0    0000    0
-------------
1    0001    1
-------------
2    0010    1
3    0011    2
-------------
4    0100    1
5    0101    2
6    0110    2
7    0111    3
-------------
8    1000    1
9    1001    2
10   1010    2
11   1011    3
12   1100    2
13   1101    3
14   1110    3
15   1111    4
 * 可以看出，res[i]=res[i/2]+(i%2)
 */
public class CountingBits {
	public static void main(String[] args) {

	}
}

class Solution275
{
	public int[] countBits(int num)
	{
		int result[]=new int[num+1];
		if(num==0) return result;
		
		result[0]=0;
		for(int i=1;i<=num;i++)
			result[i]=result[i/2]+(i%2);
		
		return result;
	}
}