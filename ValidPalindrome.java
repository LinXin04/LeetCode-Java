/**
 * 题目：给定一个字符串，判断该字符串是不是回文，在这里只有字母和数字有效，字母忽略大小写，空字符串也被视作有效的回文。
 * 解题思路：先分别写出将大写字母转成小写字母并判断两个字母是否相等的函数，在写出一个判断该字符是否是有效字符的函数。然后一边扫描，左右夹逼
 */
import java.util.Scanner;
public class ValidPalindrome {

	public static void main(String[] args) {
		 System.out.println("请输入一个字符串：");
		 Scanner sc=new Scanner(System.in);
		 String s=sc.nextLine();
		 
		 Solution29 sl=new Solution29();
		 boolean result=sl.isPalindrome(s);
		 System.out.println("结果是："+result);

	}

}

class Solution29
{
	public boolean isPalindrome(String s)
	{
		int Length=s.length();
		if(Length==0||Length==1||s==null) return true;
		int right=Length-1;
		int left=0;
		
		while(left<right)
		{
			//如果字符不是有效的，则前移或者后移
			if(!isValid(s.charAt(left))) {left++;continue;}
			if(!isValid(s.charAt(right))) {right--;continue;}
			//如果出现不相等，立马返回false
			if(!isSame(s.charAt(left),s.charAt(right))) {return false;}
			left++;
			right--;
		}
		return true;
	}
	//判断是否是有效字符的函数
	public boolean isValid(char t)
	{
		if(t>='a' && t<='z' || t>='A' && t<='Z' || t>='0' && t<='9') 
			return true;
		return false;
	}
	//判断两个字符是否相等的函数
	public boolean isSame(char a,char b)
	{
		//将大写转成小写
		if(a>='A' && a<='Z')
			a=(char) (a-'A'+'a');
		if(b>='A' && b<='Z')
			b=(char) (b-'A'+'a');
		return a==b;
	}
}