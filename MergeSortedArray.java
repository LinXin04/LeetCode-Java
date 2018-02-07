/**
 * 题目：合并两个有序数组，使得合并之后的数组任然是有序的。（这里的合并是指将nums2合并到nums1）
 * 解题思路：
 * 维护3个index，分别是数组A,数组B,结果数组。
 * 为了将结果放在A中，我们选择从后向前扫描，这样就不会有被覆盖的危险。
 * 每次迭代中A和B指向的元素大的放在结果数组中，下标减1，另一个下标不动。
 *
 */
import java.util.Scanner; 
public class MergeSortedArray {

	public static void main(String[] args) {
		System.out.println("请输入第一个数组的长度：");
		Scanner sc=new Scanner(System.in);
		int m=Integer.parseInt(sc.nextLine());
		System.out.println("请输入第二个数组的长度：");
		int n=Integer.parseInt(sc.nextLine());
		
		System.out.println("请输入第一个数组：");
		String s1=sc.nextLine();
		String st1[]=s1.split(" ");
		int nums1[]=new int[m+n];
		for(int i=0;i<st1.length;i++)
			nums1[i]=Integer.parseInt(st1[i]);
		
		System.out.println("请输入第二个数组：");
		String s2=sc.nextLine();
		String st2[]=s2.split(" ");
		int nums2[]=new int[n];
		for(int i=0;i<st2.length;i++)
			nums2[i]=Integer.parseInt(st2[i]);
		
		Solution48 sl=new Solution48();
		sl.merge(nums1, m, nums2, n);
		System.out.println("结果是：");
		System.out.print("[ ");
		for(int i=0;i<m+n;i++)
			System.out.print(nums1[i]+" ");
		System.out.print("]");
	}
}
class Solution48
{
	public void merge(int[] nums1,int m,int[] nums2,int n)
	{
		if(nums1==null || nums2==null) return;
		
		//定义三个指针
		int index1=m-1;
		int index2=n-1;
		int len=m+n-1;
		
		//从后向前进行判断
		while(index1>=0 && index2>=0)
		{
			if(nums2[index2]>nums1[index1]) 
			{
				nums1[len]=nums2[index2];
				index2--;
				len--;
			}else
			{
				nums1[len]=nums1[index1];
				index1--;
				len--;
			}
		}
		//存在这种情况，nums1中的元素已经比较完，nums2中的元素还有，则直接将nums2中剩余的元素加入到nums1中
		while(index2>=0)
		{
			nums1[len]=nums2[index2];
			len--;
			index2--;
		}
	}
}