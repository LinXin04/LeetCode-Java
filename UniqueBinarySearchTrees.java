/**
 * 题目：给定一个整数n，求由1-n所有整数组成的二叉搜索树有多少个。
 * 例子：
 * Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 解题思路：
 * 二叉搜索树的根可以取任意值，只要满足二叉搜索树的性质即可。
 * 这个根将结点划分为左右子树，以这个结点为根的可行二叉搜索树的个数就是左右子树可行二叉搜索树数量的成绩。
 * 这个问题就是动态规划问题，与求卡特兰数是一个思路
 *
 */
public class UniqueBinarySearchTrees {

}
class Solution124
{
	public int numTrees(int n)
	{
		if(n<=0) return 0;
		//result[i]代表节点数为i的二叉搜索树的数量
		int result[]=new int[n+1];
		result[0]=1;
		result[1]=1;
		
		//i代表节点数i，j代表左子树节点数，i-j-1代表右子树节点数
		for(int i=2;i<=n;i++)
		{
			for(int j=0;j<i;j++)
				result[i]+=result[j]*result[i-j-1];
		}
		return result[n];
	}
}