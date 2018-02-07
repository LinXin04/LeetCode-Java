/**
 * 题目：迷你解析器
 * 给定一个字符串，只包含字符0-9,‘,’,‘[’,']','-'，计算封装后的整数
 * 解题思路：
 * 用栈处理。
 * 1、如果遇到[，则入栈
 * 2、如果遇到],并且栈中元素个数大于1，则取出栈顶元素，再将栈顶元素加入刚取现的元素
 */
import java.util.Stack;
import java.util.ArrayList;
public class MiniParser {
	public static void main(String[] args) {
		

	}

}
class NestedInteger {
    private ArrayList<NestedInteger> list;
    private Integer integer;
    
    public NestedInteger(ArrayList<NestedInteger> list){
        this.list = list;
    }
    
    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer){
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public ArrayList<NestedInteger> getList() {
        return list;
    }
    
    public String printNi(NestedInteger thisNi, StringBuilder sb){
        if(thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");
        }
        sb.append("[");
        for(NestedInteger ni : thisNi.list){
            if(ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            }
            else {
                printNi(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution244
{
	public NestedInteger deserialize(String s)
	{
		if(s==null) return null;
		if(s.charAt(0)!='[') return new NestedInteger(Integer.parseInt(s));
		
		Stack<NestedInteger> sta=new Stack<NestedInteger>();
		int len=s.length();
		int i=0;
		
		while(i<len)
		{
			if(s.charAt(i)=='[')
			{
				sta.push(new NestedInteger());
				i++;
				continue;
			}
			if(s.charAt(i)==']')
			{
				if(sta.size()>1)
				{
					NestedInteger temp=sta.pop();
					sta.peek().add(temp);
				}
				i++;
				continue;
			}
			if(s.charAt(i)==',')
			{
				i++;
				continue;
			}
			//数字的符号
			int sign=1;
			if(s.charAt(i)=='-')
			{
				sign=-1;
				i++;
			}
			//计算数字
			int sum=0;
			while(i<len && s.charAt(i)>='0' && s.charAt(i)<='9')
			{
				sum=sum*10 + s.charAt(i)-'0';
				i++;
			}
			//将带有符号的数字加入到栈中
			sta.peek().add(new NestedInteger(sum*sign));
		}
		return sta.peek();
	}
}