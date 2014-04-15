import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Aufg55{

    public static void main(String[] args){
        int counter = 10000;
        for(int i=196; i<=196; i++){
            long n = i;
            for(int j=1; j<=50; j++){
                n=n+reverse(n);
                if(isPalindrome(n)){
                    counter--;
                    break;
                }
            }
        }
        System.out.println("Counter: " + counter);
    }

    
    public static long reverse(long n){
        List<Integer> digits = toDigits(n);
        Collections.reverse(digits);
        long res = listToLong(digits);
        return res;
    }

    public static boolean isPalindrome(long n){
        List<Integer> digits = toDigits(n);
        List<Integer> reverseDigits = toDigits(reverse(n));
        
        return digits.equals(reverseDigits);
    }

	public static List<Integer> toDigits(long n){
		int len = String.valueOf(n).length();
        		
		Integer[] numbers = new Integer[len];
		
		for(int i = len-1; i >=0; i--){
			numbers[i] = (int)(n%10);
			n = n/10;
		}
        System.out.println("n: " + Arrays.toString(numbers));
		return new ArrayList<Integer>(Arrays.asList(numbers));
	}

    public static long listToLong(List<Integer> digits){
        String n = "";
        for(Integer i: digits){
            n = n + i;
        }
        return Long.parseLong(n);
    }


}
