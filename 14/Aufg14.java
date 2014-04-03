import java.util.TreeMap;
import java.util.Map;
import java.math.BigInteger;
import java.util.BitSet;

public class Aufg14{

	private static Map<BigInteger, Integer> cache = new TreeMap<BigInteger, Integer>(); 
	private static int cacheHits = 0;
	private static BitSet bOne;

	static{
		BitSet one = new BitSet();
		one.set(0);
		bOne = one;
	}

	public static void main(String[] args){
		
		int longestChain = 0;
		int j = 1;
		int length = 0;
		for(int i = 1; i < 1000000; i++){
			length = collatzLengthBigInt(BigInteger.valueOf(i));	
			//length = collatzLengthBitSet(convert(i));			
			if(longestChain < length){
				longestChain = length;
				j = i;
			}
		}

	
		System.out.println(longestChain + " at: " + j);
		//System.out.println("cache.size() at: " + cache.size());
		//System.out.println("cache.hits at: " + cacheHits);

	}

	public static int collatzLengthBigInt(BigInteger n){
		BigInteger origN = n;
		int length = 0;		
		while(!n.equals(BigInteger.ONE)){
			if(true && cache.containsKey(n)){
				cache.put(origN, cache.get(n) + length);
				//System.out.println("cacheHit at: " + n);
				cacheHits++;
				return cache.get(origN);
			}
			//System.out.println("n: " + n);
			length++;
			if(n.mod(BigInteger.valueOf(2)) == BigInteger.ZERO)
				n = n.divide(BigInteger.valueOf(2));
			else
				n = n.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
			//System.out.println(n);

		}
		cache.put(origN, length);
		return length;
	}

	public static int collatzLengthBitSet(BitSet n){
		int length = 0;		
		while(n.length() > 1){

			//System.out.println("n: " + n);
			length++;
			if(!odd(n))
				n = divideBy2(n);
			else
				n = multiply3Add1(n);
			//System.out.println(n);

		}
		return length;
	}


	public static boolean odd(BitSet number){		
			return number.get(0);
	}

	public static BitSet multiply3Add1(BitSet number){
			BitSet result = add(number, number);
			result = add(result, number);
			result = add(result, bOne);			
			return result;
	}

	public static BitSet divideBy2(BitSet number){
			number = number.get(1,number.length()+1);			
			return number;
	}

	public static BitSet add(BitSet number1, BitSet number2){
			BitSet result = new BitSet();
			boolean carry = false;
			int i;			
			for(i = 0; i < Math.max(number1.length(), number2.length()); i++){
				result.set(i, carry ^ number1.get(i) ^ number2.get(i));
				if( (carry & ( number1.get(i) | number2.get(i))) || (number1.get(i) & number2.get(i)))
					carry = true;
				else 
					carry = false;
			}			
			if(carry)
				result.set(i);		
			return result;
	}


	public static BitSet convert(long value) {
    BitSet bits = new BitSet();
    int index = 0;
    while (value != 0L) {
      if (value % 2L != 0) {
        bits.set(index);
      }
      ++index;
      value = value >>> 1;
    }
    return bits;
  }
}
