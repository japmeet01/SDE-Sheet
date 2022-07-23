import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
        int dp[][]=new int[n][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,0);
        }
        for(int size=1;size<=n;size++){
            dp[0][size]=price[0]*size;
        }
        
        for(int idx=1;idx<n;idx++){
            for(int size=1;size<=n;size++){
                int cut=Integer.MIN_VALUE;
                if(idx+1<=size){
                    cut=price[idx]+dp[idx][size-(idx+1)];
                }
                int Nocut=dp[idx-1][size];
                dp[idx][size]= Math.max(cut,Nocut);
            }
        }
        
        return dp[n-1][n];
	}
}
//     static int maxProfit(int idx,int[] price,int size,int dp[][]){
        
//         if(idx==0){
//             if(size>=1){
//                 return price[0]*size;
//             }
//             return 0;
//         }
//         if(dp[idx][size]!=-1){
//             return dp[idx][size];
//         }
        
//         int cut=Integer.MIN_VALUE;
//         if(idx+1<=size){
//             cut=price[idx]+maxProfit(idx,price,size-(idx+1),dp);
//         }
//         int Nocut=maxProfit(idx-1,price,size,dp);
//         return dp[idx][size]= Math.max(cut,Nocut);
//     }
// }