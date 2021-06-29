package june2021.week5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MaxConsecImprovement {

    public static int longestOnes(int[] nums, int k){

        int gaps = 0;
        int[][] indexGaps = new int[nums.length][2];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                int index = i;
                int size = 1;

                do{
                    size++;
                    i++;
                }while(i < nums.length && nums[i] == 0);
                indexGaps[gaps][0] = index;
                indexGaps[gaps][1] = size;
                gaps++;
            }
        }

        int[] tempNums = nums;
        // indexGapSize should be good now
        int remainingK = k;
        for (int i = 0; i < gaps; i++) {
            for (int j = indexGaps[i][0]; j < indexGaps[i][1]; j++) {
                tempNums[j] = 1;
                remainingK--;
            }
        }




        return 0;

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

        int[] input = {0,0,0,1, 0, 0};
        System.out.println(longestOnes(input, 4));

    }
}
