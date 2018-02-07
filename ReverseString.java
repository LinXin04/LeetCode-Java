/**
 * 题目：给定一个字符串，求它的反转字符串。
 * 例如：
 * Given s = "hello", return "olleh".
 *
 */
import java.util.Scanner;
public class ReverseString {

	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution216 sl=new Solution216();
		System.out.println("结果是："+sl.reverseString(s));
	}

}
class Solution216 {
    public String reverseString(String s) {
        if(s==null || s.length()<=1) return s;
        int n=s.length();
        int i=0;
        char[] st=s.toCharArray();
        
        while(i<=n-i-1)
        {
        	char temp=st[i];
        	st[i]=st[n-1-i];
        	st[n-1-i]=temp;
        	i++;
        }
        
        return String.valueOf(st);
    }
}