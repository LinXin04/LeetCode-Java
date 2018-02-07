/**
 * 题目：
 * 给定一个二叉搜索树，求其众数（即出现次数最多的数，可以有多个）,要按照大小进行排序
 * 空间复杂度为O(1)
 * 解题思路：
 * 因为不允许存在额外的空间使用，所以不可以用HashMap。
 * 利用二叉搜索树中序遍历是递增的性质，根据中序遍历的结果，对于当前节点，如果当前节点与上一节点的值相等，则tempCount++,maxCount为出现次数最大的值。
 * 一旦出现比现在次数更大的值，就将结果集清空，将现在的结果加入。
 **/
import java.util.*;
public class FindModeInBinarySearchTree {

}
class Solution145
{
	ArrayList<Integer> temp=new ArrayList<Integer>();
	int tempCount=0;
	int maxCount=0;
	int curVal=0;
	public int[] findMode(TreeNode root)
	{
		inOrder(root);
		int[] result=new int[temp.size()];
		for(int i=0;i<temp.size();i++)
			result[i]=temp.get(i);
		return result;
	}
	public void inOrder(TreeNode root)
	{
		if(root==null) return;
		inOrder(root.left);
		//更新tempCount
		tempCount++;
		//判断当前值与上一个值是否相等,如果不相等，则更新curVal和tempCount
		if(root.val!=curVal)
		{
			curVal=root.val;
			tempCount=1;
		}
		if(tempCount>maxCount)
		{
			maxCount=tempCount;
			temp.clear();
			temp.add(root.val);
		}else if(tempCount==maxCount)
			temp.add(root.val);
		inOrder(root.right);
	}
}