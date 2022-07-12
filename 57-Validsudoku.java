import java.util.* ;
public class Solution {

    public static boolean isItSudoku(int board[][]) {
        return sudokuSolver(board, 0, 0);
    }
    
    private static boolean sudokuSolver(int[][] board, int currentRow, int currentCol){
        if(currentRow == 9){
            return true;
        }
        
        int nextRowPos;
        int nextColPos;
        
        if(currentCol == 8){
            nextRowPos = currentRow + 1;
            nextColPos = 0;
        }
        else{
            nextRowPos = currentRow;
            nextColPos = currentCol + 1;
        }
        
        if(board[currentRow][currentCol] !=0){
            return sudokuSolver(board, nextRowPos, nextColPos);
        }
        
        for(int currentVal = 1; currentVal <= 9; currentVal++){
            if(isValidCell(board, currentRow, currentCol, currentVal)){
                board[currentRow][currentCol] = currentVal;
                
                if(sudokuSolver(board, nextRowPos, nextColPos)){
                    return true;
                }
                
                board[currentRow][currentCol] = 0;
                
            }
        }
        
        return false;
        
    }
    
    private static boolean isValidCell(int[][] board, int currentRow, int currentCol, int currentVal){
        return isRowValid(board, currentRow, currentVal) && isColValid(board, currentCol, currentVal) && isSubGridValid(board, currentRow, currentCol, currentVal);
    }
    
    private static boolean isRowValid(int[][] board, int currentRow, int currentVal){
        
        for(int currentCol = 0; currentCol < 9; currentCol++){
            if(board[currentRow][currentCol] == currentVal){
                return false;
            }
        }
        
        return true;
        
    }
    
    private static boolean isColValid(int[][] board, int currentCol, int currentVal){
        
        for(int currentRow = 0; currentRow < 9; currentRow++){
            if(board[currentRow][currentCol] == currentVal){
                return false;
            }
        }
        
        return true;
        
    }
    
    private static boolean isSubGridValid(int[][] board, int currentRow, int currentCol, int currentVal){
        
        int x = 3 * (currentRow/3);
        int y = 3 * (currentCol/3);
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[x+i][y+j] == currentVal){
                    return false;
                }
            }
        }
        
        return true;
        
    }
    
}
