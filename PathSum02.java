/**
 * 题目：寻找从根到叶子的路径。要求求出所有满足条件的路径。
 * 例如：
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 解题思路：
 * 利用递归的思想，如果搜索到的该路径满足需要，则加入结果集中;发现不是路径和时，返回上一个结点时，需要把该节点从一维vector中移除。
 */
import java.util.*;
public class PathSum02 {

}
class Solution123 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        temp.add(root.val);
        helper(root,sum-root.val,temp,result);
        return result;
    }
    public void helper(TreeNode root,int sum,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> result)
    {
    	if(root==null) return;
    	if(root.left==null && root.right==null && sum==0)
    	{
    		result.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	if(root.left!=null)
    	{
    		temp.add(root.left.val);
    		helper(root.left,sum-root.left.val,temp,result);
    		temp.remove(temp.size()-1);
    	}
    	if(root.right!=null)
    	{
    		temp.add(root.right.val);
    		helper(root.right,sum-root.right.val,temp,result);
    		temp.remove(temp.size()-1);
    	}
    }
}