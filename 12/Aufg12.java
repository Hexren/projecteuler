import java.util.ArrayList;
import java.util.*;

public class Aufg12{
	
	
	public static void main(String[] args){
				
		List<Integer> factors = new ArrayList<Integer>();

		int triangleSum = 0;
		int maxSize = 0;
		int i = 0;
		while(factors.size() < 500)
		{
			i++;
			triangleSum = triangleSum + i;
			factors = factors(triangleSum);
			
			//if(i%2==0)
				maxSize = Math.max(maxSize, factors.size());
			if(i % 100 == 0)			
				System.out.println(i + " :" + triangleSum + " : " + factors.size() +" : " + maxSize);
		}
		System.out.println(triangleSum);

	}

	static public List<Integer> factors(int n){
		List<Integer> factors = new ArrayList<Integer>();
		factors.add(n);
		for(int j = 1; j <= n/2; j++)
		{
			if(n % j == 0)
				factors.add(j);

		}
		
		return factors;
	}


}


