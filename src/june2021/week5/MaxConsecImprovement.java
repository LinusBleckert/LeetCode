package june2021.week5;

import java.util.Arrays;

public class MaxConsecImprovement {

    public static int longestOnes(int[] nums, int k){

        int swap = nums[0];
        int swaps = 1;
        for(int i=1; i < nums.length; i++){
            if(swap != nums[i]){
                swaps++;
                swap = nums[i];
            }
        }

        int[][] summary = new int[swaps][2];



        return swaps;

    }

    public static int longOnes(int[] nums){

        int result = 0;
        int currentLength = 0;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 1){
                currentLength++;
            }else{
                if(currentLength > result){
                    result = currentLength;
                }
                currentLength = 0;
            }
        }

        if(currentLength > result)
            return currentLength;
        return result;
    }


    public static void main(String[] args) {

        int[] input = {1,0,1, 0, 0,1,1};
        System.out.println(longestOnes(input, 3));

    }
}
