/**
 * 题目：利用队列实现栈的基本操作：
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 注意：队列是先进先出的操作
 * 解题思路：
 * 定义两个队列：
 * 先将1插入队a中 ，现在要将2入栈，则将2插入b总然后将a中的1出列入到b中，b中的元素变为 2 ，1
 * a为空，现在要压入3 则将3插入a中 ，依次将b中的2 ，1 出列并加入倒a中 ，a中的元素变为 3，2，1 b为空
 */
import java.util.ArrayDeque;
import java.util.Queue;
public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		MyStack stack=new MyStack();
		stack.push(-1);
		stack.push(0);
		stack.push(1);
		stack.push(2);
	}
}
class MyStack
{
	//注意：Queue实现的是接口，ArrayDeque实现的是类
	Queue<Integer> que1=new ArrayDeque<Integer>();
	Queue<Integer> que2=new ArrayDeque<Integer>();
	
	public MyStack(){}
	public void push(int x)
	{
		if(que1.isEmpty())
		{
			que1.add(x);
			while(!que2.isEmpty())
			{
				int cur=que2.poll();
				que1.add(cur);
			}
		}else
		{
			que2.add(x);
			while(!que1.isEmpty())
			{
				int cur=que1.poll();
				que2.add(cur);
			}
		}
	}
	public int pop()
	{
		if(que1.isEmpty())
			return que2.poll();
		else
			return que1.poll();
	}
	public int top()
	{
		if(que1.isEmpty())
			return que2.peek();
		else
			return que1.peek();
	}
	public boolean empty()
	{
		if(que1.isEmpty() && que2.isEmpty())
			return true;
		else
			return false;
	}
}