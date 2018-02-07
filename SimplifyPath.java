/**
 * 题目：简化Unix路径。
 * 例如：
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 解题思路：
 * 简化Unix上的绝对路径，也就是多个'/'代表一个，'..'表示返回上一级目录，'.'代表当前目录。
 * 1.如果路径名是"."，则不处理
 * 2.如果路径名是".."，则需要弹栈，如果栈为空，则不做处理；
 * 3.如果路径名为其他字符串，入栈。
 */
import java.util.Scanner;
import java.util.Stack;
public class SimplifyPath {

	public static void main(String[] args) {
		System.out.println("请输入一个字符串：");
		 Scanner sc=new Scanner(System.in);
		 String path=sc.nextLine();

		 Solution104 sl=new Solution104();
		 String result=sl.simplifyPath(path);
		 System.out.println("结果是："+result);
	}

}
class Solution104
{
	public String simplifyPath(String path)
	{
		if(path==null) return path;
		Stack<String> stack=new Stack<String>();
		int Length=path.length();
		
		for(int i=0;i<Length;)
		{
			//跳过斜线
			while(i<Length && path.charAt(i)=='/')
				i++;
			
			//记录路径名
			String curPath="";
			while(i<Length && path.charAt(i)!='/')
				curPath+=path.charAt(i++);
			
			//如果是“..”且栈不为空，则弹出
			if(curPath.equals("..") && !stack.isEmpty())
				stack.pop();
			//如果不是“.”或者“..”或者“”，则压入栈
			if(!curPath.equals("") && !curPath.equals(".") && !curPath.equals(".."))
				stack.push(curPath);
		}
		//如果最后栈为空
		if(stack.isEmpty())
			return "/";
		//如果栈不为空
		String result="";
		while(!stack.isEmpty())
		{
			result='/'+stack.pop()+result;
		}
		return result;
	}
}