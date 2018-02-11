package tutorioal;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(tree(3));

    }

    public static int addPrimes() {
        int sum = 0;

        for(int i = 0; i <= 100; i++ ){
            if(isPrime(i)){
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isPrime(int value){

        if(value < 2){
            return false;
        }

        for(int i = 2; i < value; i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }


    public static String blanks(int n){
        if( n < 1 || n > 61 || n % 2 == 0){
            return "";
        }
        n = n * 2;

        String output = "";

        for(int i = 1; i < n; i += 2 ){

            for(int j = 0; j < n - (i / 2); j++ ){
                output += " ";
            }

            for(int j = 0; j < i; j++ ){
                output += "*";
            }
            output += "\n";
        }
        return output;
    }

    public static String tree(int n){
        if( n < 1 || n > 61 || n % 2 == 0){
            return "";
        }

        String output = "";

        for(int i = 1; i < n; i++ ){
            output += add(' ', n - i - 1) + add('*', i * 2 - 1) + '\n';
        }

        return output;
    }

    public static String add(char value, int nr){
        char[] arr = new char[nr];
        Arrays.fill(arr, value);
        return new String(arr);
    }
    /*

    public static int addPrimes() {
        int sum = 0;

        for(int i = 0; i <= 100; i++ ){
            for(int j = 0; j < i; j++){
                if(i % j == 0){
                    break;
                }

            }
        }
    } */

    public static int cube(int value){

        if(value < 0){
            value = value * -1;
        }

        int cube = 0;

        for(int i = 0; i < value; i++ ){
            cube += i + i + 1;
        }

        return cube;
    }

    public static void cube2(int value){
        if(value < 0){
            System.out.println("Fuck off");
            return;
        }

        int cube = 0;

        for(int i = 0; i < value; i++ ){
            cube += i + i + 1;
        }

        System.out.println(cube);

        return;
    }
}
