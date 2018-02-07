/**
 * 题目：二叉搜索树迭代器。完成两个功能：判断是否存在下一个最小的数值、返回下一个更小的数值。要求空间复杂度为O(logn)
 * 解题思路：
 * 二叉搜索树的最大特点：中序遍历的结果为升序的。
 * 对于第一个问题，我们可以借助一个栈来存储所有的可能最小的点。
 * 对于第二个问题，我们需要考虑如果第一次弹出最小的元素的话，我们可以成功。
 * 如：
 *       6
       /   \
      5     8
     /     / \
    1     7   9
     \      
      3  
     / \
    2   4
 *  首先s=6,5,1,第一次1弹出，如果不对栈进行维护的话，再调用一次next的时候就会弹出5，这是不对的。
 *  这时应该弹出2， 所以我们应该将元素1的右子树的部分节点加入到栈中，但是我们不需要加入所有的节点，而是将根到左下角的点加入即可，即3,2
 *  
 */
import java.util.Stack;
public class BinarySearchTreeIterator {

}
class BSTIterator
{
	Stack<TreeNode> s=new Stack<TreeNode>();
	public BSTIterator(TreeNode root)
	{
		while(root!=null) 
		{
			s.push(root);
			root=root.left;
		}
	}
	
	//判断是否存在下一个最小的数值并返回
	public boolean hasNext()
	{
		return !s.empty();
	}
	
	//返回下一个最小的数值
	public int next()
	{
		//首先将最小元素取出来
		TreeNode resNode=s.pop();
		int result=resNode.val;
		
		//维护栈。判断这个resNode的右子树是否为空。
		if(resNode.right!=null)
		{
			resNode=resNode.right;
			while(resNode!=null)
			{
				s.push(resNode);
				resNode=resNode.left;
			}
		}
		return result;
	}
}