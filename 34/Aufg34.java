import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Aufg34{

	public static void main(String[] args){
		
		for(int i = 1; i <= 4000000; i++){
			int res = 0;
			for(int d: toDigits(i)){
				res += fac(d);
				if(res == i)
					System.out.println(res);
			}

		}
	}

	public static int fac(int n){
		int fac = 1;		
		for(int i=1; i<=n; i++){
			fac = fac * i;
		}
		return fac;
	}

	public static List<Integer> toDigits(int n){
		int len = String.valueOf(n).length();		
		Integer[] numbers = new Integer[len];
		
		for(int i = len-1; i >=0; i--){
			numbers[i] = n%10;
			n = n/10;
		}
		return Arrays.asList(numbers);
	}

}
