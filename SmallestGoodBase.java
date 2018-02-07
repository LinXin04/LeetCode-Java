/**
 * 题目：给定一个整数n，请输出它的最小好基数k。即如果n的k进制表示全部为1，则称k为n的一个好基数。
 * 例如：
 * Input: "13"
 * Output: "3"
 * Explanation: 13 base 3 is 111.
 * 解题思路：
 * 在这道题目中：
 * n = 1 + k + k^2 + k^3 + ... + k^(m-1) m表示转换成全1数字的位数
 * m: [2,log2(n+1)]
 * k: [2,n^(1/(m-1))]\
 * 我们遍历所有可能的m值，然后利用二分查找法来确定k的值，对每一个k值，我们通过联合m值算出总和sum，然后跟n来对比即可
 * 当k=n-1时，一定能变成11，所以实在找不到更小的情况下就返回n-1。
 */
import java.util.Scanner;
public class SmallestGoodBase {
	public static void main(String[] args) {
		System.out.println("请输入数字：");
		Scanner sc=new Scanner(System.in);
		String n=sc.nextLine();
		
		Solution190 sl=new Solution190();
		System.out.println("结果是："+sl.smallestGoodBase(n));
	}
}
class Solution190
{
	public String smallestGoodBase(String n)
	{
		if(n.length()==0) return null;
		
		long num=Long.parseLong(n);
		//定义1的位数m
		for(int m=(int) (Math.log(num+1)/Math.log(2));m>=2;m--)
		{
			//定义基数k
			long left=2,right=(long) (Math.pow(num,1.0/(m-1))+1);
			while(left<right)
			{
				long mid=(long) ((right+left)/2),sum=0;
				for(int j=0;j<m;j++)
					sum=sum*mid+1;
			if(sum==num) return String.valueOf(mid);
			else if(sum<num) left=mid+1;
			else right=mid;
			}
		}
		return String.valueOf(num-1);
	}
}