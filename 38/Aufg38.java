import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Aufg38{

    public static void main(String[] args){
        int max = 0;        
        for(int i=1; i < 10000; i++){
            int conN = conProd(i);
            if(conN > max && checkPandigital(conN, 9)){
                max = conN;
                System.out.println(i + " = " + max);
            }
        }        
    }

    public static int conProd(int n){
        String number = "";
        for(int i=1; number.length() < 9; i++){
            number += n * i; 
        }

        if(number.length() == 9)
            return Integer.parseInt(number);
        else
            return 0;
    }

    public static boolean checkPandigital(int number, int panN){
        List<Integer> digits = new ArrayList<Integer>(9);   
        digits.addAll(toDigits(number));
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
