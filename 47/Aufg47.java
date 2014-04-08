import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class Aufg47{

	public static Map<Long, Boolean> cache = new TreeMap<Long, Boolean>();
	public static List<Long> ePrimes = eSieve(200000);
	public static Long[] primeSearch;

	public static void main(String[] args){
		primeSearch = ePrimes.toArray(new Long[1]);
		int consecs = 4;
		long n = 1;

		Set[] facSets = new Set[consecs];
		long[] numbers = new long[consecs];		

		for(int j = 0; j < facSets.length; j++){
			facSets[j] = factors(1);
		}

		int i = 0;		
		while( !(testExactNumFac(consecs, facSets) && disjoint(facSets)) ){

			if(isPrime(n)){
				facSets[i] = new HashSet<Long>();
				numbers[i] = n;
			}else{
				facSets[i] = factors(n);
				numbers[i] = n;
			}
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
		
		for(Long prime: ePrimes){
			if(no%prime == 0){
				Factor f = new Factor();
				f.fac = prime;
				f.exp = 0;	
				while(n%prime==0){
					f.exp = f.exp + 1;
					n = n/prime;
				}
				factors.add(f);
			} 
			if(n == 1)
				break;
		}		
		return factors;
	}

	public static List<Long> eSieve(long limit){
		List<Long> primes = new ArrayList<Long>((int)limit/2);
		List<Long> candidates = new ArrayList<Long>((int)limit/2);

		primes.add(2L);
		for(long cand = 3; cand <= Math.max(limit,10); cand = cand+2){
			candidates.add(cand);
		}

		long nextPrime = candidates.remove(0);
		while(nextPrime <= Math.sqrt(limit)){
			primes.add(nextPrime);
			for (Iterator<Long> it = candidates.iterator(); it.hasNext(); ){
		    	if (it.next()%nextPrime==0)
		        	it.remove();	
			}
			nextPrime = candidates.remove(0);
		}

		primes.addAll(candidates); 
		return primes;
	}


	public static boolean isPrime(long n){
		//n = Math.abs(n);
		return Arrays.binarySearch(primeSearch, n) >= 0;
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
