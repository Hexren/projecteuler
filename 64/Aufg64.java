import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Aufg64{

	public static void main(String[] args){
        int counter = 0;
		for(int i=2; i<=10000; i++){
			List<Integer> continuation = contFrac(i);
            if(continuation.size() > 1 && (continuation.size()-1)%2 != 0){
                counter++;
            }
            //System.out.println(i + ": " + continuation);
		}
        
        System.out.println(counter);
	}


	public static List<Integer> contFrac(int s){
		List<Integer> cont = new ArrayList<Integer>();
		Set<List<Integer>> seen = new HashSet<List<Integer>>();
		int m0 = 0;
		int d0 = 1;
		int a0 = (int) Math.sqrt(s);
		Integer[] thisComb = {m0,d0,a0};
        //return empty on perfect squares
		if((int) Math.sqrt(s) == Math.sqrt(s))
			return cont;
		while(!seen.contains(Arrays.asList(thisComb))){
            cont.add(a0);
            seen.add(Arrays.asList(thisComb));
			m0 = (d0*a0)-m0;
			d0 = (s-(m0*m0))/d0;
			a0 = ((int)(Math.sqrt(s)) + m0)/d0;
            thisComb = new Integer[]{m0,d0,a0};
		}
		return cont;
	}

}
