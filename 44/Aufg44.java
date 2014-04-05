import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Arrays;

public class Aufg44{

    public static List<Long> ps = new ArrayList<Long>();
	public static Long[] psA = new Long[0];

    public static void main(String[] args){
		
		int max = 30000;

      	for(int n = 1; n<max ;n++){
			ps.add((((long)n)*(3L*n-1))/2L);
		}

		psA = ps.toArray(new Long[0]);

		long ma = 0;
		long mb = 0;
		long maxDiff = Long.MAX_VALUE;
		int size=ps.size();			
		long last = ps.get(size-1); 

		for(int a = 0; a<size-1; a++){
			for(int b=a+1; (ps.get(a) + ps.get(b)) <= last ;b++){
				if(isPen(ps.get(a) + ps.get(b)) && isPen(ps.get(b) - ps.get(a))){// && isPen(ps.get(b) - ps.get(a))
					
					if(ps.get(b) - ps.get(a) < maxDiff){
						ma = ps.get(a);
						mb = ps.get(b);
						maxDiff = ps.get(b) - ps.get(a);	
					}
					System.out.println(ps.get(a) + " : " + ps.get(b) + " diff: " + (ps.get(b) - ps.get(a)));
				}
			}

		}	

		System.out.println(mb + " - " + ma + " = " + maxDiff);
    }

	public static boolean isPen(long n){
		return Arrays.binarySearch(psA, n) >= 0;
	}

}
