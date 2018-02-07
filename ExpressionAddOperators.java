/**
 * 题目：为表达式添加运算符。给定一个字符串代表一个数字，和一个target，求通过为字符串添加运算符(数字不一定是拆成个位)可以得到target的所有可能的表达式情况。
 * 例如：
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 * 解题思路：
 * 需要两个变量diff和curNum，一个用来记录将要变化的值，另一个是当前运算后的值，而且它们都需要用long long型的，因为字符串转为int型很容易溢出，所以我们用长整型。
 * 对于加和减，diff就是即将要加上的数和即将要减去的数的负值，
 * 对于乘来说稍有些复杂，此时的diff应该是上一次的变化的diff乘以即将要乘上的数，有点不好理解，那我们来举个例子，比如2+3*2，即将要运算到乘以2的时候，上次循环的curNum = 5, diff = 3, 而如果我们要算这个乘2的时候，新的变化值diff应为3*2=6，而我们要把之前+3操作的结果去掉，再加上新的diff，即(5-3)+6=8，即为新表达式2+3*2的值
 * 另外需要注意的是，全是0的情况下，要注意诸如“00*0”这种不符合常规的形式出现
 *
 */
import java.util.Scanner;
import java.util.ArrayList;
public class ExpressionAddOperators {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);

		String num=sc.nextLine();
		System.out.println("请输入target：");
		int target=sc.nextInt();
		
		Solution259 sl=new Solution259();
		ArrayList<String> result=sl.addOperators(num, target);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
	}
}
class Solution259
{
	public ArrayList<String> addOperators(String num,int target)
	{
		ArrayList<String> result=new ArrayList<String>();
		helper(num,target,0,0,"",result);
		return result;
	}
	public void helper(String num,int target,long diff,long curNum,String out, ArrayList<String> result)
	{
		if(num.length()==0 && curNum==target)
			result.add(out);
		
		for(int i=1;i<=num.length();i++)
		{
			String cur=num.substring(0, i);
			if(cur.length()>1 && cur.charAt(0)=='0') return;
			String next=num.substring(i);
			
			if(out.length()>0)
			{
				helper(next,target,Long.valueOf(cur),curNum+Long.valueOf(cur),out+"+"+cur,result);
				helper(next,target,-Long.valueOf(cur),curNum-Long.valueOf(cur),out+"-"+cur,result);
				helper(next,target,diff*Long.valueOf(cur),(curNum-diff)+(diff*Long.valueOf(cur)),out+"*"+cur,result);
				
			}else
				helper(next,target,Long.valueOf(cur),Long.valueOf(cur),cur,result);
		}
			
	}
}