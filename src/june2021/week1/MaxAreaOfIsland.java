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

    public int maxAreaOfIsland(int[][] grid) {

        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[x].length; y++){
                if(grid[y][x] == 1){
                    System.out.println("X is: " + x + " and Y is: " + y);
                }

            }
        }


    }


    public int islandSize(int[][] grid, int x, int y){

        if(grid[y][x] == 0){
            return 0;
        }else{

            if(insideGrid(grid.length, grid[0].length, x, y)){


            }
        }
    }

    public boolean insideGrid(int m, int n, int x, int y){

        if(x < 0 || x > m)
            return false;
        if(y < 0 || y > n)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid =  {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        maxAreaOfIsland(grid);
    }
}
