public class Aufg17{

	public static void main(String[] args){
		int numbers = 25;
		long length = 0;
		for(int i = 1; i <= 1000; i++ ){
			String letters;
			if(String.valueOf(i).length() == 1){
				letters = numberAsWord(i);
				System.out.println(letters);
				length = length + letters.length();
			}else if(String.valueOf(i).length() == 2){
				letters = tenerAsWord(i);
				System.out.println(letters);
				length = length + letters.length();
			}else if(String.valueOf(i).length() == 3){
				letters = hundredAsWord(i);
				System.out.println(letters);
				length = length + letters.length();
			}else{
				letters = "onethousand";
				System.out.println(letters);
				length = length + letters.length();			
			}
			System.out.println(length);
		}

	}


	public static String numberAsWord(int i){
		switch(i){	
			case 1: return "one";
			case 2: return "two";
			case 3: return "three";
			case 4: return "four";
			case 5: return "five";
			case 6: return "six";
			case 7: return "seven";
			case 8: return "eight";
			case 9: return "nine";
			}
		return "";
	}

	public static String tenerAsWord(int i){
		switch(getNthDigit(i,2)){			
			case 1: return teen(i);
			case 2: return "twenty" + numberAsWord(getNthDigit(i,1));
			case 3: return "thirty"+ numberAsWord(getNthDigit(i,1));
			case 4: return "forty"+ numberAsWord(getNthDigit(i,1));
			case 5: return "fifty"+ numberAsWord(getNthDigit(i,1));
			case 6: return "sixty"+ numberAsWord(getNthDigit(i,1));
			case 7: return "seventy" + numberAsWord(getNthDigit(i,1));
			case 8: return "eighty" + numberAsWord(getNthDigit(i,1));
			case 9: return "ninety" + numberAsWord(getNthDigit(i,1));
			}
		return "" + numberAsWord(getNthDigit(i,1));
	}


	public static String hundredAsWord(int i){
		String result = "";
		switch(getNthDigit(i,3)){			
			case 1: result += "onehundred"; break;
			case 2: result +=  "twohundred" ;break;
			case 3: result +=  "threehundred"; break;
			case 4: result +=  "fourhundred"; break;
			case 5: result +=  "fivehundred"; break;
			case 6: result +=  "sixhundred"; break;
			case 7: result +=  "sevenhundred" ; break;
			case 8: result +=  "eighthundred" ; break;
			case 9: result +=  "ninehundred" ; break;
			}

		if(tenerAsWord(i).length() > 0)
			result += "and" + tenerAsWord(i);
		return result;
	}

	public static String teen(int i){
		switch(getNthDigit(i,1)){
			case 0: return "ten";			
			case 1: return "eleven";
			case 2: return "twelve";
			case 3: return "thirteen";
			case 5: return "fifteen";
			case 8: return "eighteen";
		}
		return numberAsWord(getNthDigit(i,1)) + "teen";
	}


	public static int getNthDigit(int number, int n) {    
	  return (int) ((number / Math.pow(10, n - 1)) % 10);
	}

}
