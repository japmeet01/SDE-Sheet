import java.util.*;

public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
        int dp[][]=new int[n][w+1];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        return max(0,n,w,values,weights,dp);
	}
    static int max(int curr,int n,int weight,ArrayList<Integer> values, ArrayList<Integer> weights,int dp[][]){
        if(curr>=n){
            return 0;
        }
        if(dp[curr][weight]!=-1)
        return dp[curr][weight];
        int loot= -1000000077;
        if(weights.get(curr)<=weight){
            loot=values.get(curr)+max(curr+1,n,weight-weights.get(curr),values,weights,dp);
        }
        int notLoot=max(curr+1,n,weight,values,weights,dp);
        return dp[curr][weight]= Math.max(loot,notLoot);
    }
}