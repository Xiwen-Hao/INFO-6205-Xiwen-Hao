package com.springboot.tightoil.demo;


public class Assignment_8_4 {
    int num_islands = 0;
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return num_islands;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i < m;i++){
            for(int j=0;j < n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    num_islands++;
                }
            }
        }
        return num_islands;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
