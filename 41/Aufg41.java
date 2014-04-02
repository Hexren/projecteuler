import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aufg41{
    
    public static void main(String[] args){
        int j = 0;
        for(int i=7654321; i>1; i=i-2){

            if(isPandigital(i) && isPrime(i)){
                System.out.println(i);
                break;
            }        
        }

    }

    public static boolean isPandigital(int number){
        String digits = "" + number;
        for(int a = 1; a <= digits.length(); a++){
            if(digits.indexOf(Integer.toString(a)) == -1)
                return false;
        }    
        
        return true;
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
