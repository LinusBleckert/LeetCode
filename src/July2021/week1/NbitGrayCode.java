package July2021.week1;

import java.util.ArrayList;
import java.util.List;

public class NbitGrayCode {


    public static List<Integer> grayCode(int n){

        // brute force, recursive testing


        List<Integer> numbersResult = new ArrayList<>();
        if(n == 0){
            return null;

        }

        return recursiveSearch(numbersResult, 0, n);
    }

    public static List<Integer> recursiveSearch(List<Integer> numbersResult, int addedNumber, int n){

        if(addedNumber == 0){
            numbersResult.add(0);
        }else{
            if(checkIfDiffersByOneBit(numbersResult.get(numbersResult.size() - 1), addedNumber)){
                numbersResult.add(addedNumber);
            }else{
                return numbersResult;
            }
        }

        // All numbers are put in
        if(numbersResult.size() == Math.pow(2,n)){
            // Check if its correct and return completed list
            if(checkIfDiffersByOneBit(numbersResult.get(0), numbersResult.get(numbersResult.size() - 1))){
                return numbersResult;
            }else{// If not remove last index
                numbersResult.remove(numbersResult.size()-1);
                return numbersResult;
            }
        }

        for(int i = 1; i < Math.pow(2,n); i++){
            if(!numbersResult.contains(i)){
                recursiveSearch(numbersResult, i, n);
                if(numbersResult.size() == Math.pow(2,n))
                    return numbersResult;
            }
        }

        numbersResult.remove(addedNumber);
        return numbersResult;
    }

    public static boolean checkIfDiffersByOneBit(int a, int b){

        int n = Math.max(a, b);
        for(int i = 0; i < n; i++){

            if(Math.abs(a-b) == Math.pow(2,i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        List<Integer> res = grayCode(2);
        res.forEach(System.out::println);
    }
}
