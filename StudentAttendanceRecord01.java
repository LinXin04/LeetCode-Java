/**
 * 题目：学生的出勤记录。判断学生是否会被奖励，如果学生出现两次缺勤和三次及以上的连续旷课，则不可以被奖励。
 * 例如：
 * Input: "PPALLP"
 * Output: True
 * 
 * Input: "PPALLL"
 * Output: False
 * 解题思路：
 *
 */
import java.util.Scanner;
public class StudentAttendanceRecord01 {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution237 sl=new Solution237();
		System.out.println("结果是："+sl.checkRecord(s));
	}
}
class Solution237
{
	public boolean checkRecord(String s)
	{
		if(s==null || s.length()==0) return true;
		int Acount=0;
		int Lcount=0;
		
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch=='A')
			{
				Acount++;
				if(Acount>=2) return false;
				 Lcount=0;
			}else if(ch=='L')
			{
				Lcount++;
				if(Lcount>2) return false;
			}else
			{
				Lcount=0;
			}
		}
		return true;
	}
}