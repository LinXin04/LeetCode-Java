/**
 * 题目：给定一个数组，计算每个数字右边所有小于这个数字的个数。
 * 例如：
 * Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 * 解题思路：
 * 构造一个二分搜索树，与之前不同的是这个地方我们增加一个变量SmallCount来记录比当前节点值小的所有节点的个数。
 * 每插入一个节点，首先判断它和根节点的大小：
 * 如果新的节点值小于根节点值，则插入左子树中，同时增加SmallCount的值；并继续递归调用左子节点的insert。
 * 如果新节点的值大于根节点，则需要递归调用右子节点的insert并加上根节点的SmallCount，加1.
 */
import java.util.*;
public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String []st=s.split(" ");
		int []nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution153 sl=new Solution153();
		ArrayList<Integer> result=sl.countSmaller(nums);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
	}

}

class Solution153
{
	public ArrayList<Integer> countSmaller(int[] nums)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		Node root=null;
		for(int i=nums.length-1;i>=0;i--)
			result.set(i, insert(root,nums[i]));
		return result;
	}
	public int insert(Node root,int v)
	{
		if(root==null) 
		{
			root=new Node(v,0);
			return 0;
		}
		if(root.val>v)
		{
			return (++root.smallCount) + insert(root.left,v);
		}
		else
		{
			return root.smallCount+insert(root.right,v)+(root.val<v?1:0);
		}
	}
}
class Node
{
	int val;
	int smallCount;
	Node left;
	Node right;
	public Node(int v,int s){val=v;smallCount=s;left=null;right=null;}
}