import java.util.HashMap;
import java.util.Map;

public class Climbing_Stairs_70 {
    Map<Integer,Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        memo.put(1,1);
        memo.put(2,2);
        memo.put(3,3);
        return helper(n);
    }
    public int helper(int n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int rs= helper(n-1)+helper(n-2);
        memo.put(n,rs);
        return rs;
    }
}
