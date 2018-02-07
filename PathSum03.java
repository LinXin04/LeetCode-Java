/**
 * 题目：
 * 给定一个二叉树，以及一个整数。求路径和等于该整数的所有路径。
 * 例如：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *      10
 *     /  \
 *    5   -3
 *   / \    \
 *  3   2   11
 * / \   \
 *3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * 解题思路：
 * 我们在这里使用深度优先搜索的策略。
 * 结果就是从根节点出发的路径+左子树的结果+右子树的结果。
 */
import java.util.*;
public class PathSum03 {

}
class Solution144{
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        //返回从节点root出发的满足条件的路径+左子树上的结果+右子树的结果
        return dfs(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
       
    }
    public int dfs(TreeNode root,int sum)
    {
    	int result=0;
    	if(root==null) return 0;
    	if(sum==root.val) result++;
    	result+=dfs(root.left,sum-root.val);
    	result+=dfs(root.right,sum-root.val);
    	return result;
    }
}