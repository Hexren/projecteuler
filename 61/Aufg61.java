import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Aufg61{

    public static void main(String[] args){
        Map<Integer, Set<Integer>> numbers = new HashMap<Integer, Set<Integer>>();
        boolean run = true;
        int i = 1;        
        do{
            run = false;
            System.out.println(octagonal(i));
            
            i++;
        }while(run);
    }

    //give this function only 4 digit integers
    public static void addToMap(int n, Map<Integer, Set<Integer>> numbers){
        List<Integer> digits = toDigits(n);
        int key = listToInt(digits.sublist(0,2));
    } 


    public static List<Integer> toDigits(int n){
		int len = String.valueOf(n).length();		
		Integer[] numbers = new Integer[len];
		
		for(int i = len-1; i >=0; i--){
			numbers[i] = n%10;
			n = n/10;
		}
		return new ArrayList<Integer>(Arrays.asList(numbers));
	}

    public static int listToInt(List<Integer> digits){
		int res = 0;
		int mult = 1;
		for(int i=digits.size()-1; i>=0; i--){
			res = res + (mult*digits.get(i));

			mult *= 10;
		}
		return res;
    }

    public static int triangle(int n){
        return (n*(n+1))/2;   
    } 

    public static int square(int n){
        return n*n;
    }

    public static int pentagonal(int n){
        return (n*(3*n-1))/2;
    }

    public static int hexagonal(int n){
        return (n*(2*n-1));
    }

    public static int heptagonal(int n){
        return (n*(5*n-3))/2;
    }

    public static int octagonal(int n){
        return (n*(3*n-2));
    }

}
