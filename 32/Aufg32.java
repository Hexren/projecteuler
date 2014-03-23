import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Aufg32{

    public static void main(String[] args){
      
        //idea: which numbers can produce legal 9 digits.
        //not factor may be bigger than 9999 as 1 * 9999 = 9999 if factor bigger => than more than 9 digits 
        //smaller factor may not be bigger than 100 as 100 * 100 has more than 9 digits
        int panN = 9;
        Set<Integer> pandigitals = new HashSet<Integer>();
        

        for(int i = 1; i < 100; i++){
            for(int j = 9999; j > 0; j--){
                if(checkPandigital(i,j,panN)){
                    System.out.println(i + " * " + j + " = " + i*j);
                    pandigitals.add(i*j);
                }
            }

        }  

        long res = 0;
        for(Integer n: pandigitals){
            res += n;
        }
        System.out.println(res);

    }


    public static boolean checkPandigital(int i,int j, int panN){
        List<Integer> digits = new ArrayList<Integer>(9);   
        digits.addAll(toDigits(i));
        digits.addAll(toDigits(j));
        digits.addAll(toDigits(i*j));
        if(digits.size() > panN)
            return false;        
        for(int a = 1; a <= panN; a++){
            if(!digits.contains(a))
                return false;
        }    
        return true;
    }


    public static List<Integer> toDigits(int n){
		int len = String.valueOf(n).length();		
		Integer[] numbers = new Integer[len];
		
		for(int i = len-1; i >=0; i--){
			numbers[i] = n%10;
			n = n/10;
		}
		return Arrays.asList(numbers);
	}

}
