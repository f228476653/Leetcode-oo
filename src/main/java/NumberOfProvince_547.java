public class NumberOfProvince_547 {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int[] visited = new int[isConnected.length];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                dfs(visited, isConnected, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[] visited, int[][] isConnected, int i){
        for(int j=0;j<isConnected.length;j++){
            int temp=isConnected[i][j];
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs( visited,isConnected, j);
            }
        }
    }
}
