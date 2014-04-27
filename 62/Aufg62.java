import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;


public class Aufg62{

	static Map<List<Integer>, Integer> companionCubes = new HashMap<List<Integer>, Integer>();
		

	public static void main(String[] args){
		int LIMIT = 100000;
		for(double i=1; i<=LIMIT; i++){
			BigInteger base = BigInteger.valueOf((long)i);
			List<Integer> digits = toDigits(base.pow(3));
			Collections.sort(digits);
			incr(digits);
		}
		//System.out.println(companionCubes.values());
		
		for(double i=1; i<=LIMIT; i++){
			BigInteger base = BigInteger.valueOf((long)i);
			List<Integer> digits = toDigits(base.pow(3));
			Collections.sort(digits);
			if(companionCubes.get(digits) == 5){
				System.out.println(base.pow(3).toString());
				System.out.println("YEAHHH!!");
				break;
			}
		}
	}

	

	public static void incr(List<Integer> digits){
		int i = 0;
		if(companionCubes.containsKey(digits)){
			i = companionCubes.get(digits);
		}else{
			i = 0;
		}
		i++;
		companionCubes.put(digits,i);
	
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
