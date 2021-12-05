import java.util.*;

public class NumberOfIslands_200 {
    static int landNum = 0;
    public static int numIslands(char[][] grid) {
        char land ='0';
        if(grid.length ==0 ||grid[0].length==0){
            return 0;
        }
        for(int i = 0; i<grid.length; i++){
            for(int j =0;j< grid[0].length; j++){
                land = grid[i][j];
                if (land == '1'){
                    landNum++;
                    dfs(i,j,grid);
                }
            }

        }
        return landNum;
    }
    public static int dfs(int x, int y, char[][]grid){
       if(x<0 || y< 0 || x>= grid.length || y>=grid[0].length){
           return 0;
        }
        if( grid[x][y] =='0'){
            return 0;
        }
        grid[x][y]='0';
        dfs(x+1 ,y, grid);
        dfs(x ,y+1, grid);
        dfs(x-1 ,y, grid);
        dfs(x ,y-1, grid);
        return 1;
    }
    public static void main(String[] args){
        char init[][] ={
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '1'}
        };
        int a =numIslands(init);
        System.out.println(a);
    }
}
