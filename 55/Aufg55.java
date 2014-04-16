import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.math.BigInteger;

public class Aufg55{

    public static void main(String[] args){
        int counter = 10000;
        for(int i=1; i<=10000; i++){
            BigInteger n = BigInteger.valueOf(i);
            for(int j=1; j<=50; j++){
                n=n.add(reverse(n));
                if(isPalindrome(n)){
                    counter--;
                    break;
                }
            }
        }
        System.out.println("Counter: " + counter);
    }

    
    public static BigInteger reverse(BigInteger n){
        List<Integer> digits = toDigits(n);
        Collections.reverse(digits);
        BigInteger res = listToBigInt(digits);
        return res;
    }

    public static boolean isPalindrome(BigInteger n){
        List<Integer> digits = toDigits(n);
        List<Integer> reverseDigits = toDigits(reverse(n));
        
        return digits.equals(reverseDigits);
    }

	public static List<Integer> toDigits(BigInteger n){
		int len = n.toString().length();
        		
		Integer[] numbers = new Integer[len];
		for(int i = len-1; i >=0; i--){
			numbers[i] = n.mod(BigInteger.TEN).intValue();
			n = n.divide(BigInteger.TEN);
		}
        
		return new ArrayList<Integer>(Arrays.asList(numbers));
	}

    public static BigInteger listToBigInt(List<Integer> digits){
        String n = "";
        for(Integer i: digits){
            n = n + i;
        }
        return new BigInteger(n);
    }


}
