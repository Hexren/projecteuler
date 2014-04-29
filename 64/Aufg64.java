import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class Aufg64{

	public static void main(String[] args){
		for(int i=2; i<=13; i++){
			System.out.print(i + ": ");
			System.out.println(contFrac(i));
		}
	}


	public static List<Integer> contFrac(int s){
		List<Integer> cont = new ArrayList<Integer>();
		Set<Integer[]> seen = new HashSet<Integer[]>();
		int m0 = 0;
		int d0 = 1;
		int a0 = (int) Math.sqrt(s);
		Integer[] thisComb = {m0,d0,a0};
		cont.add(a0);
		if((int) Math.sqrt(s) == Math.sqrt(s))
			return cont;
		do{
			m0 = (d0*a0)-m0;
			d0 = (s-(m0*m0))/d0;
			//if(d0 == 0)
			//	return cont;
			a0 = (a0 + m0)/d0;
			cont.add(a0);
		}while(false);

		return cont;
	}

}
