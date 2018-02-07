/**
 * 题目：给定一个数组，代表研究人员的文章引用次数，编写函数计算该研究人员的h指数。h指数的定义：“一名科学家的h指数是指其发表的N篇论文中，有h篇论文分别被引用了至少h次，其余N-h篇的引用次数均不超过h次”。
 * 例如：
 * 给定引用次数数组 = [3, 0, 6, 1, 5]，这意味着研究人员总共有5篇论文，每篇分别获得了3, 0, 6, 1, 5次引用。由于研究人员有3篇论文分别至少获得了3次引用，且其余两篇的引用次数不超过3次，因而其h指数是3。
 * 注意：如果存在多个可能的h值，取最大值作为h指数。
 * 解题思路：
 * 
 *
 */
import java.util.Scanner;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import java.util.Arrays;
import java.util.Comparator;
public class HIndex {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数组：");
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int citations[]=new int[st.length];
		
		Solution195 sl=new Solution195();
		System.out.println("结果是："+sl.hIndex(citations));
	}
}

class Solution195
{
	public int hIndex(int[] citations)
	{
		if(citations==null || citations.length==0) return 0;
		int n=citations.length;
		
		//将数组降序排列
		Arrays.sort(citations);
		for(int i=0;i<n-1-i && n-1-i>=0 && i<n;i++)
		{
			int temp=citations[i];
			citations[i]=citations[n-1-i];
			citations[n-1-i]=temp;
		}

		for(int i=0;i<n;i++)
		{
			if(citations[i]<=i) return i;
		}
		
		return citations.length;
	}
}