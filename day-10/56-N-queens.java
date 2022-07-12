import java.util.* ;
public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        
       int[][] grid = new int[n][n];
        
        for(int currentRow = 0; currentRow < n; currentRow++){
            for(int currentCol = 0; currentCol < n; currentCol++){
                grid[currentRow][currentCol] = 0;
            }
        }
        
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        
        nQueens(grid, 0, n, answer);
        
        return answer; // return answer.size() for N Queens 2
        
    }
    
    private static void nQueens(int[][] grid, int currentRow, int n, ArrayList<ArrayList<Integer>> answer){
        if(currentRow >= n){
            ArrayList<Integer> tempAns = popluateAns(grid, n);
            answer.add(tempAns);
            return;
        }
        
        for(int currentCol = 0; currentCol < n; currentCol++){
            if(isValid(grid, currentRow, currentCol, n)){
                grid[currentRow][currentCol] = 1;
                nQueens(grid, currentRow + 1, n, answer);
                grid[currentRow][currentCol] = 0;
            }
        }
        
    }
    
    private static ArrayList<Integer> popluateAns(int[][] grid, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans.add(grid[i][j]);
            } 
        }
        
        return ans;
        
    }
    
    private static boolean isValid(int[][] grid, int currentRow, int currentCol, int n){
        return isRowValid(grid, currentRow, n) && isColValid(grid, currentCol, n) && areDiagonalsValid(grid, currentRow, currentCol, n);
    }
    
    private static boolean isRowValid(int[][] grid, int currentRow, int n){
        
        for(int j=0; j < n; j++){
            if(grid[currentRow][j] == 1){
                return false;
            }
        }
        
        return true;
        
    }
    
    private static boolean isColValid(int[][] grid, int currentCol, int n){
        
        for(int i=0; i < n; i++){
            if(grid[i][currentCol] == 1){
                return false;
            }
        }
        
        return true;
        
    }
    
    private static boolean areDiagonalsValid(int[][] grid, int currentRow, int currentCol, int n){
        
        int i = currentRow;
        int j = currentCol;
        
        while(i >= 0 && j >= 0){
            if(grid[i][j] == 1){
                return false;
            }
            i -= 1;
            j -= 1;
        }
        
        
        i = currentRow;
        j = currentCol;
        
        while(i >= 0 && j < n){
            if(grid[i][j] == 1){
                return false;
            }
            i -= 1;
            j += 1;
        }
        
        i = currentRow;
        j = currentCol;
        
        while(i < n && j < n){
            if(grid[i][j] == 1){
                return false;
            }
            i += 1;
            j += 1;
        }
        
        i = currentRow;
        j = currentCol;
        
        while(i < n && j >= 0){
            if(grid[i][j] == 1){
                return false;
            }
            i += 1;
            j -= 1;
        }
        
        return true;
        
    } 
}
