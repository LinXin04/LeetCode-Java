/**
 * 题目：要求在上面的基础上，返回所有的二叉搜索树。
 * 解题思路：
 * 从Unique Binary Search Trees中我们已经知道，可行的二叉查找树的数量是相应的卡特兰数，不是一个多项式时间的数量级。
 * 所以我们要求解所有的树，自然是不能多项式时间内完成的了。
 * 算法上还是用求解NP问题的方法来求解，也就是N-Queens中介绍的在循环中调用递归函数求解子问题。
 * 思路是每次一次选取一个结点为根，然后递归求解左右子树的所有结果，最后根据左右子树的返回的所有子树，依次选取然后接上
 *
 */
import java.util.ArrayList;

public class UniqueBinarySearchTrees02 {

}
class Solution125
{
	public ArrayList<TreeNode> generateTrees(int n)
	{
		if(n<=0) return new ArrayList<TreeNode>();
		return helper(1,n);
	}
	public ArrayList<TreeNode> helper(int left,int right)
	{
		ArrayList<TreeNode> result=new ArrayList<TreeNode>();
		if(left>right)
		{
			result.add(null);
			return result;
		}
		
		//将左右子树分开,i为root节点
		for(int i=left;i<=right;i++)
		{
			//计算左右子树
			ArrayList<TreeNode> leftResult=helper(left,i-1);
			ArrayList<TreeNode> rightResult=helper(i+1,right);
			
			//将左右节点连起来
			for(int m=0;m<leftResult.size();m++)
			{
				for(int n=0;n<rightResult.size();n++)
				{
					//根节点
					TreeNode root=new TreeNode(i);
					//根的左节点
					root.left=leftResult.get(m);
					root.right=rightResult.get(n);
					//构造完毕，加入到结果集中
					result.add(root);
				}
			}
		}
		return result;
	}
}