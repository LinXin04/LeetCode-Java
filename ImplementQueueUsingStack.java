/**
 * 题目：使用栈实现队列的基本操作：
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 解题思路：
 * 用两个栈实现队列。
 * 进栈时，将所有元素压入一个栈；
 * 获得栈顶元素时，将所有的元素从一个栈移入另一个栈
 *
 */
import java.util.Stack;
public class ImplementQueueUsingStack {

}

class MyQueue {
	
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
    public MyQueue() {}
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if(stack2.isEmpty())
        {
        	while(!stack1.isEmpty())
        		stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    
    public int peek() {
        if(stack2.isEmpty())
        {
        	while(!stack1.isEmpty())
        		stack2.push(stack1.pop());
        }
        return stack2.peek();  
    }
    
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())
        	return true;
        else
        	return false;
    }
}