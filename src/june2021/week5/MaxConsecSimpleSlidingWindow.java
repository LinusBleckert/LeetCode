package june2021.week5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxConsecSimpleSlidingWindow {

    public static int longestOnes(int[] nums, int k){


        List<int[]> ints = new ArrayList<>();

        int indexOfLastOne = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                if((indexOfLastOne - i) > k){
                    // Split?
                    ints.add(Arrays.copyOfRange(nums, i, indexOfLastOne));
                    indexOfLastOne = i;
                }
            }
        }

        ints.add(Arrays.copyOfRange(nums,indexOfLastOne, nums.length));


        // Sliding windows now
        int longest = 0;
        for (int[] anInt : ints) {
            int current = subRoutine(anInt, k);
            if(current > longest)
                longest = current;
        }
        return longest;
        /*int[] tempNums = nums.clone();
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
        }*/

        //return longest;

    }

    public static int subRoutine(int nums[], int k){
        int zeroes = 0;
        for (int num : nums) {
            if(num == 0)
                zeroes++;
        }

        if(k > zeroes)
            k = zeroes;
        int[] zeroIndex = new int[zeroes];

        int insertedZeroes = 0;
        int firstSplit = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                zeroIndex[insertedZeroes++] = i;

            }
        }

        // Split into more arrays if zeroIndex[i] - zeroIndex[i-1] > k


        // Sliding windows now
        return findLongestSlidingWindows(nums, zeroIndex, k);
    }

    public static int findLongestSlidingWindows(int[] original, int[] indexArray, int k){

        int[] tempNums = original.clone();
        int longest = 0;
        for(int j = 0; j <= (indexArray.length - k); j++){

            if(j >= original.length)
                return longest;

            for(int l = j; l < k + j; l++){
                tempNums[indexArray[l]] = 1;
            }

            int currentLongest = longOnes(tempNums);
            if(currentLongest > longest)
                longest = currentLongest;
            tempNums = original.clone();
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
        System.out.println(longestOnes(input, 1));

    }
}
