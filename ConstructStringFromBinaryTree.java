/**
 * 题目：从字符串创建二叉树。
 * 给定一个树字符串，代表的是一颗二叉树，请用前序遍历以及括号输出该字符串。
 * 例如：
 * Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", 
 * but you need to omit all the unnecessary empty parenthesis pairs. 
 * And it will be "1(2(4))(3)".
 * 解题思路：利用递归的思路来解决
 *
 */
import java.util.Scanner;
public class ConstructStringFromBinaryTree {
	public static void main(String[] args) {
	System.out.println("请输入树：");
	}
}

class TreeNode55
{
	int val;
	TreeNode55 left;
	TreeNode55 right;
	TreeNode55(int x) {val=x;}
}

class Solution243
{
	public String tree2str(TreeNode55 t)
	{
		if(t==null) return "";
		String result=t.val+"";
		
		String l=tree2str(t.left);
		String r=tree2str(t.right);
		
		if(l=="" && r=="") return result;
		if(l=="" && r!="") return result+"()"+"("+r+")";
		//右边括号是多余的
		if(r=="" && l!="") return result+"("+l+")";
		return result+"("+l+")"+"("+r+")";
	}
}