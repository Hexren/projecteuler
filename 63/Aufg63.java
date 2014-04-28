import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.math.BigInteger;

public class Aufg63{

	public static void main(String[] args){
		int counter = 0;
		for(int base=0; base<=9; base++){
			for(int exp=1; exp<1000; exp++){
				BigInteger baseB = BigInteger.valueOf(base);
				BigInteger foo = baseB.pow(exp);
				if(toDigits(foo).size() == exp)
					counter++;
			}
		}
		System.out.println(counter);
	}

    public static List<Integer> toDigits(BigInteger n){
		List<Integer> digits = new ArrayList<Integer>();

		while(n.compareTo(BigInteger.ZERO) > 0){
			digits.add(n.mod(BigInteger.TEN).intValue());
			n = n.divide(BigInteger.TEN);
		}
		Collections.reverse(digits);
		return digits;
	}

}
