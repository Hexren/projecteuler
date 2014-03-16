import java.util.Map;
import java.util.HashMap;
import java.math.BigInteger;


public class Aufg25{

	public static Map<Long, BigInteger> cache = new HashMap<Long, BigInteger>();

	public static void main(String[] args){
		long i = 1;		
		while( String.valueOf(fib(i)).length() < 1000 ){
			i++;
		}
		System.out.println(i + ": " + fib(i));

	}

	public static BigInteger fib(long n){
		if(cache.containsKey(n))
			return cache.get(n);		

		if(n <= 2){
			return BigInteger.ONE;
		}else{
			BigInteger res = fib(n-1).add(fib(n-2));
			cache.put(n, res);
			return res;
		}
	}
	
}
