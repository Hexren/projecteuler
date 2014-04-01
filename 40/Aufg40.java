import java.math.BigInteger;

public class Aufg40{

	public static void main(String[] args){
		
		//generating constant		
		StringBuffer champBuf = new StringBuffer();
		for(int i=1; champBuf.length()<=1000000; i++){
			champBuf.append(i);
		}
		
		String champConst = champBuf.toString();
		
		//generating result
		long res = 1L;
		res *= d(1, champConst);
		res *= d(10, champConst);
		res *= d(100, champConst);
		res *= d(1000, champConst);
		res *= d(10000, champConst);
		res *= d(100000, champConst);
		res *= d(1000000, champConst);
		System.out.println(res);


	}

	public static int d(int n, String champConst){
		return Integer.parseInt(champConst.substring(n-1, n));
	}
}
