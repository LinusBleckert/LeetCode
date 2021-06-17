package week4;

import java.math.BigInteger;

public class Concat {

    public static String concatenatedBinaryTemp(int n) {
        int i = 1;
        while(Math.pow(2,i) <= n){
            i++;
        }
        return binaryRepresentation(n, (int) Math.pow(2,i-1));
    }

    public static String concatenateResults(int n){
        String res = "";
        for(int k = 1; k<=n; k++){
            res += concatenatedBinaryTemp(k);
        }
        return res;
    }

    public static String binaryRepresentation(int n, int i){
        if(i == 0){
            return "";
        }
        if(n/i >= 1){
            return "1" + binaryRepresentation(n%i, i/2);
        }else{
            return "0" + binaryRepresentation(n%i, i/2);
        }
    }

    public static BigInteger stringToInt(String str){

        BigInteger sum = new BigInteger("0");
        char[] c = str.toCharArray();
        for(int i=0; i<c.length; i++){
            if(c[i] == '1'){
                sum = sum.add(twoCubicBigInt(c.length -i -1));
                //sum += twoCubicBigInt(c.length - i - 1);
            }
        }
        return sum;
    }

    public static long twoCubic(long n){

        long sum = 1;
        for(int i = 0; i < n; i++){
            sum *= 2;
        }

        return sum;
    }

    public static BigInteger twoCubicBigInt(long n){
        BigInteger sum = new BigInteger("1");
        //long sum = 1;
        for(int i = 0; i < n; i++){
            sum = sum.add(sum);
        }
        //BigInteger mod = BigInteger.valueOf(returnMod());


        return sum;
       // return sum.longValue();
    }

    public static long returnMod(){
        return (long)Math.pow(10,9) + 7;
    }

    public static long applyMod(long n){

        long mod = (long)Math.pow(10,9) + 7;
        return n % mod;
    }

    public static long concatenatedBinary(int n){

        String res = concatenateResults(n);
        System.out.println(res);
        BigInteger r = stringToInt(res);
        BigInteger mod = BigInteger.valueOf(returnMod());
        long res2 = r.mod(mod).longValue();
        return applyMod(res2);

    }
    public static void main(String[] args) {

        //System.out.println(twoCubic(5));
        //System.out.println(twoCubicBigInt(5));
        System.out.println(concatenatedBinary(42));
    }
}
