/**
 * 题目：创建一个最小的栈。它具有以下功能：
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 解题思路：
 * 在这里其实可以使用Stack。其他的都好说，唯有得到最小的元素，我们可以用一个栈存储正常的入栈，一个栈用于存储小元素。
 *
 */
import java.util.Stack;
public class MinStack {
	//声明两个栈
	Stack<Integer> stack=new Stack<Integer>();
	Stack<Integer> store=new Stack<Integer>();
	
	public MinStack(){}
	public void push(int x)
	{
		stack.push(x);
		if(store.isEmpty())
			store.push(x);
		else if(!store.isEmpty() && store.peek()>=x)
			store.push(x);
	}
	public void pop()
	{
		//注意：一定要用equals，代表比较的是值
		if(store.peek().equals(stack.peek()))
			store.pop();
		stack.pop();
	}
	public int top()
	{
		return stack.peek();
	}
	public int getMin()
	{
		return store.peek();
	}
}
