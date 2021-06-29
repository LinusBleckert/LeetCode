package june2021.week5;

public class MaxConsecutiveOnes3 {


    // how many ones in a row, k is the amount of 0 u can flip

    public static int longestOnes(int[] nums, int k){

        int zeroes = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                zeroes++;
        }

        int longest = 0;

        for(int j = 0; j < zeroes; j++){
            int[] tempNums = new int[nums.length];
            int zeroesPut = 0;
            int zeroesPast = 0;
            for(int i = 0; i < nums.length; i++){

                // If its a zero, put in a 1 if following conditions are true
                // we have enough k - zeroesPut
                // we went past j amount of zeroes
                if(nums[i] == 0){
                    if(j <= zeroesPast){
                        if(zeroesPut < k){
                            tempNums[i] = 1;
                            zeroesPut++;
                        }else{
                            tempNums[i] = 0;
                        }
                    }
                    zeroesPast++;

                }else{
                    tempNums[i] = nums[i];
                }
                int currentLength = longOnes(tempNums);
                if(currentLength > longest)
                    longest = currentLength;
            }
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
        return result;
    }


    public static void main(String[] args) {

        int[] input = {0,0,0,1};
        System.out.println(longestOnes(input, 4));

    }
}
