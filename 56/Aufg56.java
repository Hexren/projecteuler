import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Arrays;

public class Aufg56{

    public static void main(String[] args){
        BigInteger max = BigInteger.ZERO;
        long maxSum = 0; 
        for(int a=1; a<100; a++){
            for(int b=1; b<100; b++){
                BigInteger bigA = BigInteger.valueOf(a);
                BigInteger res = bigA.pow(b);
                long digSum = digitSum(res);
                if(digSum > maxSum){
                    maxSum = digSum;
                    max = res;
                }
            }
        }
        System.out.println("Result: " + max);
        System.out.println("Sum: " + maxSum);

    }

    public static long digitSum(BigInteger n){
        long res = 0;    
        for(int d: toDigits(n)){
            res += d;
        }
        return res;

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

}
