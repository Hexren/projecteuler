import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Aufg61{

    public static void main(String[] args){
        Map<Integer, Set<Integer>> numbers = new TreeMap<Integer, Set<Integer>>();
        Map<Integer, Set<Integer>> numberToOrd = new TreeMap<Integer, Set<Integer>> ();
        numbers.put(100,new HashSet<Integer>());//used for collission detection         
        boolean run = true;
        int i = 1;
                
        do{
            run = false;
            int n;
            n = (triangle(i));
            if(toDigits(n).size() < 5)
                run = true;
            addToMap(n, numbers, 0, numberToOrd);

            n = (square(i));
            if(toDigits(n).size() < 5)
                run = true;
            addToMap(n, numbers, 1, numberToOrd);

            n = (pentagonal(i));
            if(toDigits(n).size() < 5)
                run = true;
            addToMap(n, numbers, 2, numberToOrd);

            n = (hexagonal(i));
            if(toDigits(n).size() < 5)
                run = true;
            addToMap(n, numbers, 3, numberToOrd);

            n = (heptagonal(i));
            if(toDigits(n).size() < 5)
                run = true;
            addToMap(n, numbers, 4, numberToOrd);

            n = (octagonal(i));
            if(toDigits(n).size() < 5)
                run = true;
            addToMap(n, numbers, 5, numberToOrd);

            i++;
        }while(run);
        
        numbers.remove(100);
        //System.out.println(numbers);        

        int[] set = new int[6]; 
        for(int a = 1000; a<10000; a++){
            set[0] = a;
            Set<Integer> possContsToA = numbers.get(last2(a));
            if(null == possContsToA)
                continue;
            for(Integer b: possContsToA){
                set[1] = b;
                Set<Integer> possContsToB = numbers.get(last2(b));
                if(null == possContsToB)
                    continue;
                for(Integer c: possContsToB){            
                    set[2] = c;
                    Set<Integer> possContsToC = numbers.get(last2(c));
                    if(null == possContsToC)
                        continue;
                    for(Integer d: possContsToC){
                        set[3] = d;
                        Set<Integer> possContsToD = numbers.get(last2(d));
                        if(null == possContsToD)
                            continue;
                        for(Integer e: possContsToD){
                            set[4] = e;
                            Set<Integer> possContsToE = numbers.get(last2(e));
                            if(null == possContsToE)
                                continue;
                            for(Integer f: possContsToE){
                                set[5] = f;
                                if(isSolution(set, numberToOrd)){
                                    System.out.println(Arrays.toString(set));
                                    int res = 0;
                                    for(int n: set){
                                        res+=n;
                                    }
                                    System.out.println(res);
                                }
                            }
                        }
                    }      
                }
            }
        }

    }

    public static boolean isSolution(int[] solution, Map<Integer, Set<Integer>>  numberToOrd){
        Set<Integer> polyType = new HashSet<Integer>();

        
        //System.out.println(Arrays.toString(solution));
        for(int n: solution){
            Set<Integer> foo = numberToOrd.get(n);
            if(null != foo)
                polyType.addAll(foo);
        }
        
        if(polyType.size() == 6 && last2(solution[solution.length-1]) == first2(solution[0]))
            return true;
        else
            return false;
    
    }

    public static int last2(int n){
        return listToInt(toDigits(n).subList(2,4));
    }

    public static int first2(int n){
        return listToInt(toDigits(n).subList(0,2));
    }

    public static void addToMap(int n, Map<Integer, Set<Integer>> numbers, int ordNum, Map<Integer, Set<Integer>>  numberToOrd){        
        if(isLegal(n, numbers)){
            List<Integer> digits = toDigits(n);
            int key = listToInt(digits.subList(0,2));
            Set<Integer> growingSet;

            if(numbers.containsKey(key)){
                growingSet = numbers.get(key);
            }else{
                growingSet = new HashSet<Integer>();
            }
            growingSet.add(n);
            numbers.put(key,growingSet);

            Set<Integer> ordInalSet;
            if(numberToOrd.containsKey(n)){
                ordInalSet = numberToOrd.get(n);
            }else{
                ordInalSet = new HashSet<Integer>();
            }

            ordInalSet.add(ordNum);
            numberToOrd.put(n, ordInalSet);

        }
    } 

    public static boolean isLegal(int n, Map<Integer, Set<Integer>> numbers){
        List<Integer> digits = toDigits(n);
        if(digits.size() != 4 || numbers.get(100).contains(n))
            return false;
        int key = listToInt(digits.subList(0,2));
        if(numbers.containsKey(key)){
            Set<Integer> ints = numbers.get(key);
            if(ints.contains(n)){
                ints.remove(n);
                numbers.put(key, ints);
                numbers.get(100).add(n);
                return false;
            }
        }
        return true;

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
