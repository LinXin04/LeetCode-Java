
/**
 * 题目：在H-Index的基础上，假设数组是升序排列的，求在O(logn)的时间内求得hindex
 * 解题思路：
 * 二分查找
 *
 */
import java.util.Scanner;

public class HIndex02 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数组：");
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int citations[]=new int[st.length];
		
		Solution196 sl=new Solution196();
		System.out.println("结果是："+sl.hIndex(citations));

	}

}
class Solution196 {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0) return 0;
        int n=citations.length,left=0,right=n-1;
        
        while(left<=right)
        {
        	int mid=(left+right)/2;
        	if(citations[mid]==n-mid) return n-mid;
        	else if(citations[mid]>n-mid) right=mid-1;
        	else left=mid+1;
        }
        return n-left;
    }
}