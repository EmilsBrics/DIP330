package recursiveDigitSum;

public class Solution {

    static long superDigit(long x) {

        String xString = String.valueOf(x);
        if (xString.length() == 1) return x;


        long lastDigit = Long.valueOf(xString.substring(xString.length() - 1));
        xString = xString.substring(0,xString.length() - 1);
        x = Long.valueOf(xString);
        long sumOfDigits = lastDigit + superDigit(x);

        if (String.valueOf(sumOfDigits).length() != 1) return superDigit(sumOfDigits);
        return sumOfDigits;
    }


    public static void main(String[] args) {
        System.out.println(superDigit(9875));
    }
}