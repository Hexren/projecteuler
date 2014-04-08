import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Arrays;

public class Aufg47{

	public static Map<Long, Boolean> cache = new TreeMap<Long, Boolean>();

	public static void main(String[] args){
		int consecs = 4;
		long n = 1;

		Set[] facSets = new Set[consecs];
		long[] numbers = new long[consecs];		

		for(int j = 0; j < facSets.length; j++){
			facSets[j] = factors(1);
		}

		int i = 0;		
		while( !(testExactNumFac(consecs, facSets) && disjoint(facSets)) ){

			facSets[i] = factors(n);
			numbers[i] = n;
			i++;
			i = i%consecs;

			if(n%5000 == 0)
				System.out.println(n);

			//if(n>15)
			//	break;
			n++;
		}
		
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(facSets));
	}

	//tests that there are exactly x factors in all sets
	public static boolean testExactNumFac(int x, Set... sets){
		for(Set set: sets){
			if(set.size() != x)
				return false;
		}
		return true;
	}

	public static boolean disjoint(Set a, Set b){
		for(Object o: a){
			if(b.contains(o))
				return false;
		}
		return true;
	}

	public static boolean disjoint(Set... sets){
		for(int i = 0; i < sets.length-1; i++){
			for(int j = i+1; j < sets.length; j++){
				if(!disjoint(sets[i],sets[j]))
					return false;
			}
		}
		return true;
	}

	public static Set<Factor> factors(long no){
		Set<Factor> factors = new HashSet<Factor>();
		long n = no;
		long foo = 1;

		for(long i = 3;  i <= no && n > 1; i = i+2){
			if(no%i == 0 && isPrime(i)){
				Factor f = new Factor();
				f.fac = i;
				f.exp = 0;	
				while(n%i==0){
					f.exp = f.exp + 1;
					n = n/i;
				}
				factors.add(f);
				//System.out.println(n);
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

		public int hashCode() {
        	return 5; 
    	}

		public boolean equals(Object other) {
			//System.out.println(this.toString());
			//System.out.println(other.toString());
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
