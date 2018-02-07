/*
 * 题目：给定一个字符串，该字符串是由若干个表示数字(0-9)的英文单词组成的，但是顺序已经被打乱。求里面包含的数字。
 * 例如：
 * Input: "owoztneoer"
 * Output: "012"
 * 解题思路：
 * 经统计，我们可以发现如下规律：
 *  zero one two three four five six seven eight nine ten
 *   z 0
 *   e 0 1 3 3 5 7 7 8 9
 *   r 0 3 4
 *   o 0 1 2 4
 *   n 1 7 9 9
 *   t 2 3 8
 *   w 2
 *   h 3 8
 *   f 4 5
 *   u 4
 *   i 5 6 8 9
 *   v 5 7
 *   s 6 7
 *   x 6
 *   g 8
 */
import java.util.Scanner;
public class ReconstructOriginalDigitsFromEnglish {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入字符串s:");
		String s=sc.nextLine();
		
		Solution185 sl=new Solution185();
		System.out.println("结果是："+sl.originalDigits(s));
	}
}
class Solution185
{
	public String originalDigits(String s)
	{
		if(s.length()==0) return null;
		String result="";
		
		int count[]=new int[10];
		//遍历s，将所有的数字存储在数组的相应位置。
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch=='z') count[0]++;
			if(ch=='w') count[2]++;
			if(ch=='u') count[4]++;
			if(ch=='x') count[6]++;
			if(ch=='g') count[8]++;
			if(ch=='h') count[3]++;//3,8
			if(ch=='f') count[5]++;//4,5
			if(ch=='s') count[7]++;//6,7
			if(ch=='o') count[1]++;//0,1,2,4
			if(ch=='i') count[9]++;//5,6,8,9
		}
		
		count[3]-=count[8];
		count[5]-=count[4];
		count[7]-=count[6];
		count[1]-=count[0]+count[2]+count[4];
		count[9]-=count[5]+count[6]+count[8];
		
		//10个数从0开始记录
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<count[i];j++)
				result+=i;
		}
		return result;
	}
}