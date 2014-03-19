public class Aufg28{

    public static void main(String[] args){

        int length = 1001;
        int res = 0;
        for(int i = length; i >= 1; i = i - 2){
            res += get4Corners(i);
        }
        System.out.println(res);
           

    }

    public static int get4Corners(int len){
        if(len == 1)
            return 1;        
        else
            return 4*len*len-6*(len-1);
        
        /*    
        int start = len * len;
        int res = 0;       
        
        res += start;
        res += start - (len-1);
        res += start - (2*(len-1));
        res += start - (3*(len-1));
       

        return res;
        */
    }


}
