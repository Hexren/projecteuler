import java.util.Set;
import java.util.TreeSet;
import java.math.BigInteger;


public class Aufg28{

	public static void main(String[] args){

		Set<BigInteger> powers = new TreeSet<BigInteger>();

		for(int a = 2; a <= 100; a++){
			for(int b = 2; b <= 100; b++){			
				powers.add(BigInteger.valueOf(a).pow(b));
			}
		}
		System.out.println(powers);
		System.out.println("Size: " + powers.size());
		BigInteger res = BigInteger.ZERO;
		for(BigInteger power: powers){
			res = res.add(power);
		}
		System.out.println("Result: " + res);
		
		
	}


}
