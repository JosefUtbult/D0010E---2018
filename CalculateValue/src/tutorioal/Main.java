package tutorioal;

import java.io.File;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
	    calculateList();
    }

    public static void calculateList(){

        int currentNr = 1;
        int recordedLength = 0;

        while (true){

            if(l1(currentNr) > recordedLength){
                System.out.println("\n" + "\n" + "\n" + "\n" + "\n");
                writeL1(currentNr);
                recordedLength = l1(currentNr + 1);
            }

            currentNr ++;
        }

        /*

        System.out.print("1");

        int recordedValue = 1;
        int recordedLength = 0;

        int currentValue = 1;
        String buffer = "";

        while (true) {

            int n = 0;
            int parsedValue = currentValue;
            do {
                parsedValue = f1(parsedValue);
                n++;

                if(parsedValue == recordedValue){
                    recordedValue = currentValue;
                    recordedLength += n;
                    break;
                }
                else {
                    buffer += ", " + String.valueOf(parsedValue);
                }

            } while (parsedValue != 1);

            System.out.print(String.format(", %d, %s", recordedValue, buffer));
            buffer = "";

            currentValue ++;
        } */

    }

    public static int f1(int a0){
        if(a0 == 1){
            return 1;
        }
        else if(a0 % 2 == 0){
            return a0 / 2;
        }
        else{
            return a0 * 3 + 1;
        }
    }

    public static int l1(int a0){
        return a0 > 2 ? l1(f1(a0)) : 1;
    }

    public static void writeL1(int a0){

        if(a0 <= 2) {
            System.out.print("1, 1");
        }
        else{
            System.out.println(String.format("%d, ", a0));
            writeL1(f1(a0));
        }
    }
}

