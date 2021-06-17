package june2021.week1;

import java.util.List;

public class MaxAreaOfIsland {

    public class Node{

        List<Node> children;
        int value;
        boolean visited;

        public Node(){

        }

    }

    // m x n grid, island is 1, water is 0

    public static int maxAreaOfIsland(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int highest = 0;
        for(int y = 0; y < grid.length; y++){
            for(int x = 0; x < grid[y].length; x++){
                if(grid[y][x] == 1 && !visited[y][x]){
                    int current = islandSize(visited, grid, y, x, 0);
                    if(current > highest)
                        highest = current;
                }
            }
        }
        return highest;
    }



    public static int islandSize(boolean[][] visited, int[][] grid, int y, int x, int n){
        if(!insideGrid(grid.length, grid[0].length, y, x))
            return 0;
        if(visited[y][x] || grid[y][x] == 0)
            return 0;
        else{
            n++;
        }
        visited[y][x] = true;

        // The problem is n+=, i count it twice
        //Go up first

        // brain died, added temp and temp > n and it worked
        int  temp = islandSize(visited, grid, y-1, x, n);
        if(temp > n)
            n = temp;

        // right
        temp = islandSize(visited, grid, y, x+1, n);
        if(temp > n)
            n = temp;

        // down
        temp = islandSize(visited, grid, y+1, x, n);
        if(temp > n)
            n = temp;
        // left
        temp = islandSize(visited, grid, y, x-1, n);
        if(temp > n)
            n = temp;

        return n;
    }

    public static boolean insideGrid(int m, int n, int y, int x){
        if(x < 0 || x >= n)
            return false;
        if(y < 0 || y >= m)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid =  {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int result = maxAreaOfIsland(grid);
        System.out.println(result);
    }
}
