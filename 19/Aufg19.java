import java.util.BitSet;

public class Aufg19{
	public static void main(String[] args){
		int month = 1;
		int year = 1901;
		int days = 1;		
		int sundays = 0;
		while(year < 2001){
			
			System.out.println(month + "." + year);
			if((days+1) % 7 == 0){
				sundays++;
				System.out.println("Sunday: YAY");
			}
			days = days + getMonth(month, year);
			
			if(month == 12)
				year++;
			month = (month % 12)+1;
			
		}
		 System.out.println("Sundays: " + sundays);
			

	}


	
	public static int getMonth(int month, int year){
		switch(month){
			case 1: return 31;
			case 2: return ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28;
			case 3: return 31;
			case 4: return 30;
			case 5: return 31;
			case 6: return 30;
			case 7: return 31;
			case 8: return 31;
			case 9: return 30;
			case 10: return 31;
			case 11: return 30;
			case 12: return 31;
			default: throw new RuntimeException("BAHH");
		}

	}



}
