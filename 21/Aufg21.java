import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Aufg21{

	public static void main(String[] args){
		Set<Integer> amicableNumbers = new HashSet<Integer>(); 
		for(int a = 1; a <= 10000; a++){
			int b = d(a);
			if(a != b && a == d(b)){
				amicableNumbers.add(a);
				amicableNumbers.add(b);
				//System.out.println("a: " + a + " b: " + b);
				//System.out.println("a: " + a + " factors = " + factors(a));
				//System.out.println("b: " + b + " factors = " + factors(b));
			}
		}
		
		int sum = 0;
		for(int n: amicableNumbers){
			sum += n;
		}
		System.out.println(sum);

	}

	static public int d(int n){
		int sum = 0;	
			
		for(int f: factors(n)){
			sum += f;
		}
		return sum;	
	
	}


	static public List<Integer> factors(int n){
		List<Integer> factors = new ArrayList<Integer>();
		for(int j = 1; j <= n/2; j++)
		{
			if(n % j == 0)
				factors.add(j);

		}
		
		return factors;
	}

}
