import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Aufg39{

    public static void main(String[] args){
        Map<Integer, Set<String>> solu = new HashMap<Integer, Set<String>>();
        

        for(int a = 1; a < 510; a++){
            for(int b = 1; b < 510; b++){
                double triangSum = triangleSum(a,b);
                if(triangSum <= 1000 && triangSum == Math.floor(triangSum)){
                    String solString = "{" + a + "," + b + "," + Math.sqrt(a*a + b*b) + "}";
                    
                    if(!solu.containsKey((int)triangSum)){
                        Set<String> s = new HashSet<String>();
                        solu.put((int)triangSum, s);
                    }
                    Set<String> s = solu.get((int)triangSum);
                    s.add(solString);
                    solu.put((int)triangSum, s);
                }
            }
        } 

        int maxSize = 0;
        int maxP = 0;
        for(Integer p: solu.keySet()){
            if(solu.get(p).size() >= maxSize){
                maxSize = solu.get(p).size();
                maxP = p;
                System.out.println(p + " = " + solu.get(p).size());
            }
               
        }
    }

    public static double triangleSum(int a, int b){
        return a + b + Math.sqrt(a*a + b*b);
    }
}
