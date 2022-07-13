import java.util.* ;
public class Solution {
    public static String graphColoring(int[][] graph, int m) {
        int n=graph.length;
        int[] col=new int[n];
        Arrays.fill(col,-1);
        
        if(isMColorPossible(graph,0,col,m,n)){
            return "YES";
        }
        return "NO";
    }
    
    private static boolean isMColorPossible(int graph[][],int node,int[] col,int m,int n){
        if(node==n){
            return true;
        }
        
        for(int i=1;i<=m;i++){
            if(isColorValid(graph,node,i,col)){
                
                col[node]=i;
                if(isMColorPossible(graph,node+1,col,m,n)){
                    return true;
                }
                col[node]=-1;
            }
        }
        return false;
    }
    
    private static boolean isColorValid(int graph[][],int node,int color,int[] col){
        int n=graph.length;
        
        for(int i=0;i<n;i++){
            // to check if edge exists between current node and node i.
            if(graph[node][i]==0){
                continue;
            }
            
            if(color==col[i]){
                return false;
            }
        }
        
        return true;
    }
}