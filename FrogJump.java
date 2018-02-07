/**
 * 题目：青蛙过河。
 * 一只青蛙正在横渡一条河。这条河分为X个单元，每一个单元可能有或者没有一块石头。青蛙只能跳到石头上而不能跳进水中。
 * 给定一个升序排列的石头的位置（单元）,判断青蛙能否通过登陆最后一块石头成功过河。
 * 初始时，青蛙在第一块石头上，并且假设第一次跳跃必须是一个单元。如果青蛙的最后一次跳跃是k个单位，那么它的下一跳必须是k-1,k,k+1个单位。青蛙只能向前跳。
 * 解题思路：
 * 我们定义一个helper(int[] stones,int i,int step,HashMap<Integer,Boolean>map)函数：青蛙在第i个石头上，目前可以跳跃step步数的情况下，是否能过河。
 * 如果不用map表示的话，会造成超时
 */
import java.util.HashMap;
public class FrogJump {
	public static void main(String[] args) {

	}
}

class Solution282
{
	public boolean canCross(int[] stones)
	{
		if(stones==null || stones.length==0) return true;
		if(stones[1]>1) return false;
		if(stones.length==2) return true;
		
		HashMap<Integer,Boolean>map=new HashMap<Integer,Boolean>();
		return helper(stones,1,1,map);
	}
	public boolean helper(int[] stones, int i, int step, HashMap<Integer,Boolean>map)
	{
		//k代表的是i和step，用step左移多位再或上i表示,这样不会产生冲突
		int key=i | step<<11;
		if(i==stones.length-1) return true;
		//如果这种情况已经出现过了，则直接返回结果
		if(map.containsKey(key)) return map.get(key);
		
		for(int j=i+1;j<stones.length;j++)
		{
			if(stones[j]<stones[i]+step-1) continue;
			if(stones[j]>stones[i]+step+1) {map.put(key,false); return false;}
			if(helper(stones, j, stones[j] - stones[i],map))
                { map.put(key, true); return true;}	
		}
		 map.put(key,false);
		 return false;
	}
}