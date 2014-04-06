public class Aufg45{

    public static void main(String[] args){
        int hits = 0;
        int i = 2;
        while(true){
            long hex = (long)i*(2L*i-1L);
            if(isPentagonal(hex) && isTriang(hex)){
                System.out.println(hex);        
                hits++;
                if(hits > 1)
                    break;
            }
            i++;

        }
    }

    public static boolean isPentagonal(long number) {
        double penTest = (Math.sqrt(1 + 24 * number) + 1.0) / 6.0;
        return penTest == ((int)penTest);
    }

    public static boolean isTriang(long number){
        double triang = (Math.sqrt(1L+8L*number) - 1.0) / 2.0;
        return triang == ((int)triang);
    }
}
