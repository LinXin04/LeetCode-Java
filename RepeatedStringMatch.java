/**
 * 题目：重复的字符串匹配。给定两个字符串A和B，问A至少重复多少次才能满足B是A的子字符串。
 * 例如：
 * A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”)
 * 解题思路：
 * 首先若想满足B是A的子串，A的长度必须大于等于B，因此，我们先对字符串进行重复到A的长度>=B的长度，累积重复的次数(包含字符串本身)
 * 这时，利用String中的contains()函数查找是否出现B，若有，则直接返回count,
 * 否则再加上一个A，
 * 如果还是没有，则说明无法匹配。
 */
import java.util.Scanner;
public class RepeatedStringMatch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入字符串A：");
		String A=sc.nextLine();
		System.out.println("请输入字符串B:");
		String B=sc.nextLine();
		
		Solution239 sl=new Solution239();
		System.out.println("结果是："+sl.repeatedStringMatch(A, B));
	}
}

class Solution239
{
	public int repeatedStringMatch(String A,String B)
	{
		if(A==null || B==null || A.length()==0 || B.length()==0) return 0;
		if(A==B) return 1;
		
		int count=1;
		String t=A;
		
		while(t.length()<B.length())
		{
			t+=A;
			count++;
		}
		
		if(t.contains(B)) return count;
		t+=A;
		if(t.contains(B)) return count+1;
		else return -1;
	}
}