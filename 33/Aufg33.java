import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Aufg33{

	public static void main(String[] args){
		long denomProd = 1;
	    long nomProd = 1;

		for(int i = 10; i < 100; i++){
			for(int j = i+1; j < 100; j++){
				//filter out trivial cases		
				if(i%10 != 0 && j%10 != 0)
					if(test(i,j)){
						nomProd *= i;						
						denomProd *= j;	                		
					}			
			}
		}

		
		System.out.println(nomProd);
		System.out.println(denomProd);		
		System.out.println(gcd(denomProd, nomProd));
		System.out.println(denomProd/gcd(denomProd, nomProd));
	}

	//test all four possible cases for naive cancelation
	public static boolean test(int i, int j){
		List<Integer> digitsI = toDigits(i);
		List<Integer> digitsJ = toDigits(j);
		for(int di = 0; di < digitsI.size(); di++ ){
			for(int dj = 0; dj < digitsJ.size(); dj++ ){
				if(digitsI.get(di) == digitsJ.get(dj)){
					if((double)i/j == (double)digitsI.get((di+1)%2)/digitsJ.get((dj+1)%2)){
						System.out.println(i + "/" + j + "=" + digitsI.get(di) + "/" + digitsJ.get(dj));
						return true;			
					}
				}
			}
		}
		return false;
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


	//euclids algorithm gcd
	public static long gcd(long a, long b) {
    	if (b == 0)
       		return a;
    	else
       		return gcd(b, a%b);
    }


}
