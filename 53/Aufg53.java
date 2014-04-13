import java.math.BigInteger;

public class Aufg53{
	
	public static void main(String[] args){
		long counter = 0;
		BigInteger mil = BigInteger.valueOf(1000000); 
		for(int n=1; n<=100; n++){
			for(int r=1; r<=n; r++){
				BigInteger val = c(n,r);
				if(val.compareTo(mil) > 0){
					counter++;
				}
			}
		}
		System.out.println(counter);

	}

	public static BigInteger fac(int n){
		BigInteger res = BigInteger.ONE;
		for(int i = 1; i <= n; i++){
			res = res.multiply(BigInteger.valueOf(i));
		}
		return res;
	}

	public static BigInteger c(int n, int r){
		BigInteger facN = fac(n);
		BigInteger facR = fac(r);
		BigInteger facNR = fac(n-r);
		BigInteger res = facN.divide((facR.multiply(facNR)));
		return res;
	}

}
