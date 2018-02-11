package labb1;

class Raise {

    public static int a = 0;
    public static int b = 0;

    public static double recRaiseHalf(double x, int k) {
        if(k==0) {
            return 1;
        } else {
            a++;
            double e = recRaiseHalf(x, (int)Math.floor(k/2));
            if(k%2==0) {
                return (e*e);
            } else {
                return (x*e*e);
            }
        }
    }


    public static double recRaiseOne(double x, int k) {
        b++;
        if(k==0) {
            return 1.0;
        } else {
            return x * recRaiseOne(x,k-1);
        }
    }




    public static void main(String[] args) {
        int k = 1;
        while(k <= 10000) {
            recRaiseHalf(1.0001,k);
            System.out.println(a+" "+k);

            a = 0;

            k++;
        }





    }

}
