import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Aufg37{

    public static void main(String[] args){
        long res = 0;
        for(int i = 11; i < 10000000 ; i = i+2){
            if(testFromRight(i) && testFromLeft(i)){
                System.out.println(i);
                res += i;
            }
        }
        System.out.println(res);

    }

    public static List<Integer> toDigits(int i){
        List<Integer> digits = new ArrayList<Integer>();
        while(i != 0){
            digits.add(i%10);
            i /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static boolean testFromLeft(int n){
        List<Integer> digits = toDigits(n);
        for(int i=0; i < digits.size() ;i++){
            int sm = listToInt(digits.subList(i, digits.size()));
            if(!isPrime(sm)){
                return false;
            }        
        }
        return true;
    }

    public static boolean testFromRight(int n){
        List<Integer> digits = toDigits(n);
        for(int i=digits.size(); i > 0 ;i--){
            int sm = listToInt(digits.subList(0, i));
            if(!isPrime(sm)){
                return false;
            }        
        }
        return true;
    }

    public static int listToInt(List<Integer> digits){
        String n = "";
        for(Integer i: digits){
            n = n + i;
        }
        return Integer.parseInt(n);
    }

	public static boolean isPrime(long n){
		n = Math.abs(n);

        if(n == 2)
            return true;
		if(n <= 1) 
			return false;
		if(n % 2== 0)
			return false;
		
		for(int i = 3; i <= Math.sqrt(n)+1; i = i + 2){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}

}
