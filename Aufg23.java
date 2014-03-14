import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Aufg23{

	public static void main(String[] args){
		int limit = 28123;
		//find all abundant numbers < 28123 setA
		Set<Integer> setA = generateAbundantNumbers(limit);
		
		//generate setN, every possible number n that is n = a_1 + a_2
		Set<Integer> setN = generatePossCombFromAbundantNumbers(setA);
		//System.out.println(setN);	
		
		//sum all numbers < 28123 != setN
		int sum = 0;
		for(int i = 0; i < limit; i++){
			if(!setN.contains(i)){
				sum += i;
			}

		}
		System.out.println(sum);

	}

	static public Set<Integer> generatePossCombFromAbundantNumbers(Set<Integer> setA){

		Set<Integer> setN = new HashSet<Integer>();
		Iterator<Integer> it=setA.iterator();
		int abun1 = 0;
		while(it.hasNext()){
			abun1 = it.next();
			
			for(Integer abun2: setA){
				setN.add(abun1 + abun2);

			}
			it.remove();
		}
	
		return setN;

	}



	static public Set<Integer> generateAbundantNumbers(int limit){
		Set<Integer> setA = new HashSet<Integer>();
		for(int i = 1; i <= limit; i++){
			if(isAbundant(i))
				setA.add(i);
		}

		return setA;

	}

	static public boolean isAbundant(int n){
		long sum = 0;		
		for(Integer f: factors(n)){
			sum += f;

		}
		return sum > n;

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
