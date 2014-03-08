import java.math.BigInteger;

public class Aufg16{

	public static void main(String[] args){
		BigInteger two = BigInteger.valueOf(2);
		BigInteger number = two.pow(1000);

		long result = 0;
		for(int i = 0; i < number.toString().length(); i++){
		
			result = result + (new Integer(number.toString().substring(i,i+1)));
		
		}
		System.out.println(result);

	}
} 
