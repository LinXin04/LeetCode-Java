/**
 * 题目：电话号码的字母组合
 * 例如：
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 解题思路：
 * 利用递归的思想去求
 */
import java.util.ArrayList;
import java.util.Scanner;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		System.out.println("请输入要转换的数字：");
		Scanner sc=new Scanner(System.in);
		String digits=sc.nextLine();
		
		Solution206 sl=new Solution206();
		ArrayList<String> result=sl.letterCombinations(digits);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
	}
}
class Solution206
{
	public ArrayList<String> letterCombinations(String digits)
	{
		if(digits==null) return null;
		ArrayList<String> result=new ArrayList<String>();
		if(digits.length()==0) return result;
		
		//定义一个存储字符的字典数组
		String dict[]={"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		helper(digits,dict,0,"",result);
		return result;
	}
	
	public void helper(String digits,String dict[],int index,String temp,ArrayList<String> result)
	{
		if(index==digits.length())
		{
			result.add(temp);
			return;
		}
		
		//取得该数字表示的所有字符组成的字符串
		String str=dict[digits.charAt(index)-'2'];
		for(int i=0;i<str.length();i++)
		{
			temp+=str.charAt(i);
			helper(digits,dict,index+1,temp,result);
			temp=temp.substring(0, temp.length()-1);
		}
	}
}