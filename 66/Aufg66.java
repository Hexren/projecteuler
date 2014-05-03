import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;
import java.util.Collections;

public class Aufg66{

    public static void main(String[] args){
        
		BigInteger max = BigInteger.ZERO;
		int maxD = 0;
        for(int d=2; d<=1000; d++){
			if(!isSquare(d)){
				if(findMinXC(d).compareTo(max) > 0){
					max = findMinXC(d);
					maxD = d;
				}			
			}
        }
		System.out.println("D: " + maxD + " x:" + max);           
   }

	//most anoying Pells equation this is.
	public static BigInteger findMinXC(int d){
        Numerators foo = new Numerators(d);
		BigInteger x;
		BigInteger y;
		BigInteger bd = BigInteger.valueOf(d); 
		int n = 0;
        do{
			foo.next();
			x = foo.getN();
			y = foo.getD();
 			//System.out.println(foo.getN() + "/" + foo.getD());
			//n++;           
        }while(n < 5 && !isSolution(x, y, bd));
        return x;
    }

	public static boolean isSolution(BigInteger x, BigInteger y, BigInteger d){
        BigInteger res = diophantine(x,y,d);
	
		if(res.equals(BigInteger.ONE))
			return true;
		else
			return false;
    }

    public static BigInteger diophantine(BigInteger x, BigInteger y, BigInteger d){
        return x.pow(2).subtract(d.multiply(y.pow(2)));
    }

    public static boolean isSquare(double d){
        if(Math.sqrt(d) == (int)Math.sqrt(d)){
            return true;
        }else{
            return false;
        }
    }


	public static class Numerators{
		ContFrac cf;
		BigInteger a;
        BigInteger h1 = BigInteger.valueOf(1);
        BigInteger h2 = BigInteger.valueOf(0);
        BigInteger k1 = BigInteger.valueOf(0);
        BigInteger k2 = BigInteger.valueOf(1);
        BigInteger h = null;
        BigInteger k = null;

		public Numerators(int s){
			this.cf = new ContFrac(s);
		}	

		public void next(){
            a = BigInteger.valueOf(cf.next());

            h = a.multiply(h1).add(h2); 
            k = a.multiply(k1).add(k2); 
            
            //System.out.println(h + "/" + k);
            
            h2 = h1;
            h1 = h;
            k2 = k1;
            k1 = k;
		} 

		public BigInteger getN(){
			return h;
		}

		public BigInteger getD(){
			return k;
		}
	}

	public static class ContFrac{

		protected int s;
		protected int m0 = 0;
		protected int d0 = 1;
		protected int a0;

		public ContFrac(int s){
			this.s = s;
			this.a0 = (int) Math.sqrt(s);
		}	

		public Integer next(){
			int res = a0;
			m0 = (d0*a0)-m0;
			d0 = (s-(m0*m0))/d0;
			a0 = ((int)(Math.sqrt(s)) + m0)/d0;
		 	
			return res;
		}

	}

}
