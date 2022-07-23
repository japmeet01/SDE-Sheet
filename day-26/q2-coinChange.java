import java.util.*;
public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here			
            long dp[][]=new long[denominations.length][value+1];
                for(long row[]: dp)
                Arrays.fill(row,-1);
            return count(denominations.length-1,denominations,value,dp);
	}
    
    static long count(int idx,int denom[], int value,long[][]dp){
        if(idx==0){
            if(value%denom[0]==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[idx][value]!=-1)
        return dp[idx][value];
        
        long consider=0;
        if(denom[idx]<=value){
            consider=count(idx,denom,value-denom[idx],dp);
        }
        long notConsider=count(idx-1,denom,value,dp);
         dp[idx][value]= consider+notConsider;
        return consider+notConsider;
    }
	
}