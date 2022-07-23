// codestudio recursive soln

public class Solution {
    public static int minSumPath(int[][] grid) {
    	 int[][] memo = new int[grid.length][grid[0].length];
       return minSum(grid,0,0,memo);
    }
    static int minSum(int Matrix[][],int currRow,int currCol,int[][] memo){
        if(currCol>=Matrix[0].length || currCol<0 || currRow>=Matrix.length){
            return 10000007;
        }
        
        if(currRow==Matrix.length-1 && currCol==Matrix[0].length-1){
            return Matrix[Matrix.length-1][Matrix[0].length-1];
        }
        
        if(memo[currRow][currCol]!=0){
            return memo[currRow][currCol];
        }
        
        int down=Matrix[currRow][currCol]+minSum( Matrix,currRow+1,currCol,memo);
        int right=Matrix[currRow][currCol]+minSum( Matrix, currRow, currCol+1,memo);
        
        memo[currRow][currCol]=(Math.min(down,right));
        return  memo[currRow][currCol];
}
}

// leetcode tabulation soln
class Solution {
    public int minPathSum(int[][] Matrix) {
        int n=Matrix.length;
        int m=Matrix[0].length;
        int[][] memo=new int[n][m];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 &&j==m-1){
                    memo[i][j]=Matrix[i][j];
                }
                else{
                    
                    int down=Matrix[i][j];
                    if(i<n-1){
                        down+=memo[i+1][j];
                    }else{
                        down+=1000;
                    }
                    int right=Matrix[i][j];
                    if(j<m-1){
                        right+=memo[i][j+1];
                    }else{
                        right+=1000;
                    }
                    memo[i][j]=(Math.min(down,right));
                }  
            }
        }
        return memo[0][0];
    }
}

