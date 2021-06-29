package june2021.week5;

import java.util.Arrays;

public class MaxConsecSimpleSlidingWindow {

    public static int longestOnes(int[] nums, int k){

        int zeroes = 0;
        for (int num : nums) {
            if(num == 0)
                zeroes++;
        }
        if(k > zeroes)
            k = zeroes;
        int[] zeroIndex = new int[zeroes];
        int insertedZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                zeroIndex[insertedZeroes++] = i;
            }
        }

        // Sliding windows now
        int[] tempNums = nums.clone();
        int longest = 0;
        for(int j = 0; j <= (zeroIndex.length - k); j++){

            if(j >= nums.length)
                return longest;

            for(int l = j; l < k + j; l++){
                tempNums[zeroIndex[l]] = 1;
            }

            int currentLongest = longOnes(tempNums);
            if(currentLongest > longest)
                longest = currentLongest;
            tempNums = nums.clone();
        }



        return longest;

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

        int[] input = {1,1,1, 0, 0,0,0};
        System.out.println(longestOnes(input, 3));

    }
}
