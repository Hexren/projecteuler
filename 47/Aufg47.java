import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ArrayList;

public class Aufg47{

	public static List<Long> ePrimes = eSieve(200000);
	public static Long[] primeSearch;
	public static int consecs = 4;
	

	public static void main(String[] args){
		primeSearch = ePrimes.toArray(new Long[1]);
		
		long n = 1;

		Set[] facSets = new Set[consecs];
		long[] numbers = new long[consecs];		

		for(int j = 0; j < facSets.length; j++){
			facSets[j] = factors(1);
		}		

		int i = 0;		
		int counter = 0;
		while( !(testExactNumFac(consecs, facSets) && disjoint(facSets)) ){
			n++;
			
			i++;
			i = i%consecs;

			if(isPrime(n)){
				facSets[i] = new HashSet<Long>();
				
			}else{
				facSets[i] = factors(n);
			}

			if(facSets[i].size() != consecs && (isPrime(n+consecs-1) || factors(n+consecs-1).size() != consecs)){
				reset(facSets);
				n=n+consecs-1;	
			}else if(facSets[i].size() != consecs && (isPrime(n+consecs-2) || factors(n+consecs-2).size() != consecs)){
				reset(facSets);
				n=n+consecs-2;	
				counter++;
			}else if(facSets[i].size() != consecs){ 
				counter++;	
			}

			numbers[i] = n;
			
		}
		
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(facSets));
		System.out.println(counter);
	}

	public static long next(Long n, Set[] sets, int currentIdx){		
		
		return n+1;
	}

	public static void reset(Set[] sets){
		for(int i=0; i<sets.length; i++)
			sets[i] = new HashSet<Long>();
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
					f.exp += 1;
					n /= prime;
				}
				factors.add(f);
				if(n == 1)
					break;
			} 

		}		
		return factors;
	}

	public static List<Long> eSieve(long limit){
		List<Long> primes = new LinkedList<Long>();
		List<Long> candidates = new LinkedList<Long>();

		primes.add(2L);
		for(long cand = 3; cand <= Math.max(limit,10); cand = cand+2){
			candidates.add(cand);
		}

		long nextPrime = candidates.remove(0);
		long limitTest = (long)Math.sqrt(limit);
		while(nextPrime <= limitTest){
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
