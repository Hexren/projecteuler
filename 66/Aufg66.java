public class Aufg66{

    public static void main(String[] args){
        for(int d=2; d<=10; d++){
            if(!isSquare(d)){
                int x = findMinX(d);
                //System.out.println("D: " + d + " x: " +x);
                //diophantine()
                System.out.println(diophantine(x,y,13));
            }
        }
    }

    //gives wrong numbers
    public static int findMin(int d){
        double y = 0;
        int x = 1;
        while(!isInt(y) || y<1){
            y = getY(x,d);
            x++;
            if(x < 0)
                throw new RuntimeException("AHAAHHHAHAHA at: " + d);
   
        }
        return x;
    }

    public static int findMinX(int d){
        int y = 1;
        double x = 0;
        while(!isInt(x) || x<1){
            x = getX(y,d);
            
            y++;
            if(x < 0)
                throw new RuntimeException("AHAAHHHAHAHA at: " + d);
   
        }
        return (int)x;
    }


    public static double getY(int x, int d){
        double foo = (1-Math.pow(x,2));
        //System.out.println("nenner: " + foo);
        double res = -1 * ((foo)/d);
        //System.out.println("res: " + res);
        return Math.sqrt(res);
    }

    public static double getX(int y, int d){
        return Math.sqrt(1+d*Math.pow(y,2));
    }


    public static int diophantine(int x, int y, int d){
        return (int) (Math.pow(x,2) - (d * Math.pow(y,2)));
    }

    public static boolean isInt(double d){
        return d == (int)d;
    }

    public static boolean isSquare(double d){
        if(Math.sqrt(d) == (int)Math.sqrt(d)){
            return true;
        }else{
            return false;
        }
    }

}
