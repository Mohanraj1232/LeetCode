import java.util.*;

public class Solution{

    private static final int[][] diffs = {
        {0, 1},  // right
        {1, 0},  // down
        {0, -1}, // left
        {-1, 0}  // up
    };

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        
        int R=sc.nextInt(),C=sc.nextInt();
        sc.nextLine();
        char[][] grid=new char[R][C];
        int[] st = new int[2];
        for(int i=0;i<R;i++){
            String s=sc.nextLine();
            int ct=0;
            for(int j=0;j<C;j++){
                grid[i][j]=s.charAt(ct);
                ct+=2;
                if(grid[i][j]=='S'){
                    st[0]=i;
                    st[1]=j;
                }
            }
        }
        int k=sc.nextInt();

        if(dfs(R,C,st[0],st[1],k,grid,new boolean[R][C])){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }


    private static boolean dfs(int R,int C,int row,int col,int k,char[][] grid,boolean[][] visited){

        if(grid[row][col]=='D'){
            return true;
        }
        visited[row][col] = true;

        for(int diff[]:diffs){
            int newRow=row+diff[0];
            int newCol=col+diff[1];

            if(newRow>=0 && newRow<R && newCol>=0 && newCol<C && !visited[newRow][newCol]){
                if (grid[newRow][newCol]=='1') {
                    if(k>0){
                        if(dfs(R, C, newRow, newCol, k-1, grid, visited)){
                            return true;
                        }
                    }   
                }else{
                    if(dfs(R, C, newRow, newCol, k, grid, visited)){
                        return true;
                    }
                }
            }
        }

        visited[row][col] = false;
        return false;
    }
}