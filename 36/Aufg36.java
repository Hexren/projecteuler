public class Aufg36{

    public static void main(String[] args){
        //System.out.println(toBinary(65));
        long res = 0;
        for(int i = 1; i < 1000000; i = i + 2){
            if(isPal(Integer.toString(i)) && isPal(toBinary(i))){
                System.out.println(i + " == " + toBinary(i));
                res += i;            
            }
        }        
        System.out.println(res);
    }

    public static boolean isPal(String n){
        String rev = new StringBuilder(n).reverse().toString();
        return n.equals(rev);
    }

    public static String toBinary(int i){
        StringBuilder buffer = new StringBuilder();       
        while(i != 0){
            buffer.append(i%2);
            i = i/2;
        }   
        return buffer.reverse().toString();
    }

    

}
