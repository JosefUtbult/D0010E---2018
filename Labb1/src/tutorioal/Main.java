/**
 * @author Josef Utbult
 */

package tutorioal;

public class Main {

    public static void main(String[] args) {

		//System.out.println(Raises.loopThroughHalf()[0].toString() + "\n" + Raises.loopThroughHalf()[1].toString());
        //System.out.println(Raises.loopThroughOne()[0].toString() + "\n" + Raises.loopThroughOne()[1].toString());

        switch (Integer.parseInt(args[0])){
			case -1:
				Raises.compare();
				break;
            case 1:
                LifeLength.task1(Integer.parseInt(args[1]));
                break;
            case 2:
                LifeLength.task2(Integer.parseInt(args[1]));
                break;
            case 3:
                LifeLength.task3();
                break;
            case 4:
                LifeLength.task4();
                break;
            case 6:
                LifeLength.task6();
                break;

            default:
				System.out.println("WTF. This should not be happening. Check the switch statement.");
                break;
        }


    }

}

class LifeLength {

    public static void task1(int n){
		System.out.println(f1(n));
    }

    public static void task2(int n){
		System.out.println(stringify(n));
	}

    public static void task3() {
		System.out.println((iterateF(3, 5) + "\n" + iterateF(42, 3) + "\n" + iterateF(1, 3)));
    }

    public static void task4(){

    	StringBuilder buffer = new StringBuilder();

        for(int i = 1; i <= 15; i++ ){
        	buffer.append(intsToString(i, iterLifeLength(i)));

        	if(i < 15){
        		buffer.append("\n");
			}
		}

		System.out.println(buffer.toString());
	}

    public static void task6(){
        StringBuilder output = new StringBuilder();

        for(int i = 1; i <= 15; i++ ){
            output.append(String.format("Number: %d, Recursive life length: %d, Iterative life length: %d\n", i, LifeLength.regLifeLength(i), LifeLength.iterLifeLength(i)));
        }

		System.out.println(output.toString().substring(0, output.length() - 1));
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

    private static int f2(int a0){
        return f1(f1(a0));
    }
    private static int f4(int a0){
        return f2(f2(a0));
    }
    private static int f8(int a0){
        return f4(f4(a0));
    }
    private static int f16(int a0){
        return f8(f8(a0));
    }
    private static int f32(int a0){
        return f16(f16(a0));
    }

    public static String stringify(int a0){
        return String.format("f1=%d, f2=%d, f4=%d, f8=%d, f16=%d, f32=%d", f1(a0), f2(a0), f4(a0), f8(a0), f16(a0), f32(a0));
    }

    static int iterateF(int a0, int n) {
    	for(int i = 0; i < n; i++ ){
    		a0 = f1(a0);
		}
		return a0;
	}



    /*
    public static int iterateF(int a0, int n){
        if(a0 < 0){
            return -1;
        }
        else if(n <= 1){
            return f1(a0);
        }

        return iterateF(iterateF(a0, n / 2), n / 2);

	}
    */

    public static int iterLifeLength(int a0){

        int n = 0;

		while (a0 != 1) {

            a0 = f1(a0);
            n++;
        }

        return n;
    }

    public static String curriedIntsToString(int a0){
        return intsToString(a0, iterLifeLength(a0));
    }

    private static String intsToString(int x, int y){
        return String.format("The life length of %d is %d.", x, y);
    }

    public static String stringifyReqF1(int a){
        String output = "";

        int[] listOfF1 = reqF1(a);

        output += "value: " + String.valueOf(a) + " lifelength: " + String.valueOf(listOfF1.length - 1) + " list: ";

        for (int currentElement : listOfF1) {
            output += String.valueOf(currentElement) + " ";
        }


        return output;
    }

    private static int[] reqF1(int a){

        if(f1(a) == 1){
            return new int[]{1};
        }
        else{
            int[] temp = reqF1(f1(a));
            int[] output = new int[temp.length + 1];
            System.arraycopy(temp, 0, output, 1, temp.length);
            output[0] = f1(a);

            return output;
        }

        /*int[] temp = list.clone();
        temp = new int[list.length + 1];
        System.arraycopy(temp, 0, list, 0, temp.length);
        */


    }

    public static int regLifeLength(int a){
        return a <= 1 ? 0 : 1 + regLifeLength(f1(a));
    }

    public static void calculateList(){

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
        }

    }


}

