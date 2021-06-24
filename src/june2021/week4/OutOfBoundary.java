package june2021.week4;

import java.util.HashMap;

public class OutOfBoundary {


    // Depth = maxMove
    // Recursive search
    // Can visit same "node" several times
    private final static int mod = ((int) Math.pow(10,9) + 7);

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        if(maxMove == 0)
            return 0;

        int foundPaths = 0;
        //Recursive search top right bot left
        // TOP
        if(startRow == 0){
            foundPaths++;
        }else{
            foundPaths += findPaths(m, n, maxMove - 1, (startRow - 1), startColumn);
        }

        // RIGHT
        if(startColumn == n-1){
            foundPaths++;
        }else{
            foundPaths += findPaths(m, n, maxMove - 1, startRow, startColumn + 1);
        }

        // BOT
        if(startRow == m-1){
            foundPaths++;
        }else{
            foundPaths += findPaths(m, n, maxMove - 1, (startRow + 1), startColumn);
        }

        // LEFT
        if(startColumn == 0){
            foundPaths++;
        }else{
            foundPaths += findPaths(m, n, maxMove - 1, startRow, startColumn - 1);
        }

        return foundPaths % mod;
    }

    public static void main(String[] args) {
        System.out.println(findPaths(1,3,3,0,1));
    }

}
