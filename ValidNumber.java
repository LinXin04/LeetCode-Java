/**
 * 题目：给定一个字符串s,判断该字符串是不是有效数字。
 * 在s中可能出现的特殊字符有：符号位“+”/"-";小数点位“.”;科学计数法位“E”/“e”;数字位“0-9”。其他字符都是非法字符。
 * 我们需要考虑的情况：
 * 1、对于符号位：
 * (1)符号位只能出现在第一位或者E/e的后一位
 * (2)符号位后边必须是数字(或者是小数点)
 * 2、对于小数点位：
 * (1)小数点前面不可以有小数点以及e/E
 * (2)小数点前一位必须是数字(第一位除外)，后一位也必须是数字（最后一位除外）
 * 3、对于科学计数位
 * (1)前面不能有e/E出现过
 * (2)不可以是第一位或者最后一位
 *
 */
import java.util.*;
public class ValidNumber {

	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		Solution157 sl=new Solution157();
		System.out.println("结果是："+sl.isNumber(s));
	}

}
class Solution157
{
	public boolean isNumber(String s)
	{ 
	if(s==null || s.isEmpty() ) return false;
	
	//除掉空白
	s=s.trim();
	if(s.length()==0) return false;
	int Len=s.length();
	
	//定义小数点和科学计数法位
	boolean dotFlag=false;
	boolean eFlag=false;
	
	for(int i=0;i<s.length();i++)
	{
		switch(s.charAt(i))
		{
			case '.':
				if(dotFlag || eFlag || 
						(
								(i==0 || !(s.charAt(i-1)>='0'&& s.charAt(i-1)<='9')) 
								&& (i==Len-1 || !(s.charAt(i+1)>='0'&& s.charAt(i+1)<='9'))
						)
					)
					return false;
				dotFlag=true;
				break;
			case '+':
			case '-':
				if((i>0 && (s.charAt(i-1)!='E' && s.charAt(i-1)!='e'))
				|| i==Len-1 || !(s.charAt(i+1)>='0'&& s.charAt(i+1)<='9' || s.charAt(i+1)=='.'))
					return false;
				break;
			case 'E':
			case 'e':
				if(eFlag || i==Len-1 || i==0)
					return false;
				eFlag=true;
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				break;
			default:
				return false;
		}
	}
	return true;	
}
}