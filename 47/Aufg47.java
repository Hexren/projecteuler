import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


public class Aufg47{

	public static Map<Long, Boolean> cache = new TreeMap<Long, Boolean>();

	public static void main(String[] args){
		Set<Factor> fac = factors(15L);
		System.out.println(fac);
		

	}


	public static Set<Factor> factors(long no){
		Set<Factor> factors = new HashSet<Factor>();
		long n = no;
		for(long i = 2;  i <= no; i++){
			if(isPrime(i) && no%i == 0){
				Factor f = new Factor();
				f.fac = i;
				f.exp = 0;	
				while(n%i==0){
					f.exp++;
					n = n/i;
				}
				factors.add(f);
			} 
		}		
		return factors;
	}

	public static boolean isPrime(long n){
		//n = Math.abs(n);
		if(cache.containsKey(n))
			return cache.get(n);
    	
        if(n == 2)
            return true;
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


	public static class Factor{
		long fac;
		long exp;

		
		public String toString(){
			return "Factor: " + fac + " Exponent: " + exp;
		}

		 public boolean equals(Object other) {
			if (other.getClass() != getClass()) 
      			return false; 
    		if (fac != ((Factor)other).fac) 
       			return false;
			if (exp != ((Factor)other).exp) 
       			return false;
			return true;
   		} 

	}

}
