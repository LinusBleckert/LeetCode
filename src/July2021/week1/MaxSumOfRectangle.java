package July2021.week1;

public class MaxSumOfRectangle {

    // Brute force, calculate all matrixes in the matrix
    public static int maxSumSubmatrix(int[][] matrix, int k){
        int m = matrix.length;
        int n = matrix[0].length;

        int max = -1000000;
        // First 2 loops is for looping starting position in matrix
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(i != 0 && j != 0)
                    break;
                // Loops for getting all the matrix this starting position can generate
                int sum = 0;
                for(int l = i; l < m; l++){
                    for(int p = j; p < n; p++){

                        sum = calculateMatrix(matrix, i, l, j, p);
                        if(k >= sum && sum > max){
                            max = sum;
                        }
                    }
                }

            }
        }
        return max;
    }

    public static int calculateMatrix(int[][] matrix, int startX, int endX, int startY, int endY){

        int sum = 0;

        for(int i = startX; i <= endX; i++){
            for(int j = startY; j <= endY; j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,1,1},{2,2,2},{3,3,3}};
        //System.out.println(calculateMatrix(matrix, 1 , 2, 0, 1));
        System.out.println(maxSumSubmatrix(matrix, 20));
    }
}
