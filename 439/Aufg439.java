import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Aufg439{
    public static void main(String[] args){

        List<BigInteger>  foo = new ArrayList<BigInteger>();
        System.out.println(foo.size());
    
        foo = divisors(BigInteger.valueOf(3));
        System.out.println(foo);
        System.out.println(foo.size());
    }

    public static List<BigInteger> divisors(BigInteger n){
        List<BigInteger> divisors = new ArrayList<BigInteger>();
        for(BigInteger i = BigInteger.ONE; i.compareTo(n) < 0 ;i = i.add(BigInteger.ONE)){
                        
            if(n.mod(i).compareTo(BigInteger.ZERO) == 0){
                divisors.add(i);
            }
        }
        divisors.add(n);
        return divisors;
    }

    public static BigInteger d(int k){
        int sum = 0;
        for(int i=1; i<k; i++){
            for(int j=1; j<k; j++){
                //todo 
            }
        }
        return sum;
    }

}
