/**
 * 题目：翻转字符串03. 将句子中的每一个单词进行翻转
 * 例如：
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class ReverseWordsInAString03 {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution230 sl=new Solution230();
		System.out.println("结果是："+sl.reverseWords(s));
	}
}

class Solution230
{
	public String reverseWords(String s)
	{
		if(s==null || s.length()<=0) return s;
		String []temp=s.split(" +");
		for(int i=0;i<temp.length;i++)
			temp[i]=new StringBuilder(temp[i]).reverse().toString();
		return String.join(" ", temp);

	}
}