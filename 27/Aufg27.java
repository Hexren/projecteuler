import java.util.Map;
import java.util.HashMap;

public class Aufg27{

	public static Map<Long, Boolean> cache = new HashMap<Long, Boolean>(); 

	public static void main(String[] args){
		int a = 0;
		int b = 0;
		int n = 0;
		int maxLen = 0;
		int maxA = 0;
		int maxB = 0;
		for(a = -1000; a < 1000; a = a+1){	
	
			for(b = -1000; b < 1000; b = b+1){	
				int len = 0;
				//System.out.println("a: " + a + " b: " + b);
				for(n = 0; true; n++){
					long x = formula(a,b,n);
					if(isPrime(x)){
						len++;
					}else if(len > maxLen){
						maxLen = len;
						maxA = a;
						maxB = b;
						System.out.println("a: " + maxA + " b: " + maxB + " maxLen: " + maxLen);
						break;				
					}else{
						break;
					}

				}
			}
		}
		System.out.println("a: " + maxA + " b: " + maxB + " maxLen: " + maxLen + " erg: " + maxA*maxB);

	}


	public static long formula(long a, long b, long n){
		return n*n + a*n + b;
	}

	public static boolean isPrime(long n){
		n = Math.abs(n);
		if(cache.containsKey(n))
			return cache.get(n);
    	
		if(n <= 1) 
			return false;
		if(n % 2== 0)
			return false;
		
		for(int i = 3; i <= Math.sqrt(n)+1; i = i + 2){
			if(n % i == 0){
				cache.put(n,false);
				return false;
		
			}
		}
		cache.put(n,true);
		return true;
	}
}
