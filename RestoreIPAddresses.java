/**
 * 题目：给定一个数字字符串，返回其可能的所有的IP地址的种类。
 * 例如：
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"].
 * 有效的IP地址：总共有四段，每一段可能有一位，两位或者三位，范围是[0, 255]
 * 解题思路：
 * 一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP，二是只要遇到需要求出所有可能情况首先考虑用递归。
 * 递归。
 * 对于每一段的数字要考虑有效性，即[0,255]
 */
import java.util.Scanner;
import java.util.ArrayList;
public class RestoreIPAddresses {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution220 sl=new Solution220();
		ArrayList<String> result=sl.restoreIpAddresses(s);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
		{
			System.out.print(result.get(i)+" ");
		}
	}
}
class Solution220
{
	public ArrayList<String> restoreIpAddresses(String s)
	{
		ArrayList<String> result=new ArrayList<String>();
		if(s==null || s.length()<3 || s.length()>12) return result;
		
		helper(s,4,"",result);
		return result;
	}
	public void helper(String s,int k, String temp,ArrayList<String> result)
	{
		//k=0表示4个字段都匹配完毕，注意此时还要求s为空
		if(k==0 && s.length()==0)
			result.add(temp);
		else
		{
			//截取一段1-3个字符
			for(int i=1;i<=3;i++)
			{
				//如果数字是有效的
				if(s.length()>=i && isValid(s.substring(0, i)))
				{
					//最后一段没有.
					if(k==1) helper(s.substring(i),k-1,temp+s.substring(0,i),result);
					else helper(s.substring(i),k-1,temp+s.substring(0,i)+".",result);
				}
			}
		}
			
	}
	public boolean isValid(String s)
	{
		if(s==null || s.length()==0 || s.length()>3 || (s.length()>1 && s.charAt(0)=='0')) return false;
		int temp=Integer.parseInt(s);
		if(temp>=0 && temp<=255) return true;
		else return false;
	}
}