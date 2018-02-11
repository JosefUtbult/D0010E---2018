/**
 * @author Josef Utbult
 */

package tutorioal;

import java.util.ArrayList;

public class Raises {

	private static int recRaiseHalfNr = 0;		//Number of times the recRaiseHalf function has iterated
	private static int recRaiseOneNr = 0;		//Number of times the recRaiseOne function has iterated

	private static ArrayList<Integer> listOfK = new ArrayList<>();		//A list of k-values that makes the program iterate one more time
	private static ArrayList<Integer> listOfX = new ArrayList<>();		//A list of the iteration matched with listOfK


	public static double recRaiseHalf(double x, int k){					//The standard function

		//recRaiseHalfNr ++;

		if(k == 0){
			return 1;
		}
		else{
			recRaiseHalfNr ++;		//Counts the number of iterations up

			double tempVal = recRaiseHalf(x, (int) Math.floor(k / 2));		//Stores the value of the function recRaiseHalf, so it dos'nt need to be called for again.

			if(k % 2 == 0){
				return tempVal * tempVal;					//Returns the proper value
			}
			else {
				return x * tempVal * tempVal;
			}
		}
	}

	public static double recRaiseOne(double x, int k) {


		if (k==0) {
			return 1.0;
		}
		else {
			recRaiseOneNr ++;
			return x * recRaiseOne (x, k-1);
		}

	}


	public static ArrayList[] loopThroughHalf(){

		listOfK = new ArrayList<>();			//Clears both lists
		listOfX = new ArrayList<>();

		for(int k = 1; k < 100; k++ ){		//Tries every k-value from 1 to 10000

			//Raises.recRaiseHalf(1.0001, k);	//Runs the function, which in sets the recRaiseHalfNr to the number of steps required
			System.out.println(String.format("k: %d	result: %.10f	number of recursions: %d", k, Raises.recRaiseHalf(1.0001, k), recRaiseHalfNr));

				if(!listOfX.contains(recRaiseHalfNr)){		//If the number of steps that was required for this k-value isn't in the list of recorded nr of steps
					listOfX.add(recRaiseHalfNr);			//Adds the number o iterations to listOfK and the number of steps to listOfK
					listOfK.add(k);
				}

				recRaiseHalfNr = 0;

		}

		return new ArrayList[]{listOfK, listOfX};
	}

	public static ArrayList[] loopThroughOne(){

		listOfK = new ArrayList<>();
		listOfX = new ArrayList<>();

		for(int i = 1; i < 10000; i++ ){

			System.out.println(Raises.recRaiseOne(1.0001, i) + " " + recRaiseOneNr);
			//Raises.recRaiseOne(1.0001, i);

			if(!listOfK.contains(recRaiseOneNr)){
				listOfK.add(recRaiseOneNr);
				listOfX.add(i);
			}

			recRaiseOneNr = 0;

		}

		return new ArrayList[]{listOfK, listOfX};
	}

	public static void compare(){
		for(int k = 1; k <= 15; k++ ){
			recRaiseHalfNr = 0;
			recRaiseOneNr = 0;

			recRaiseOne(1.5, k);

			System.out.format("1.5^%d	Result: %.2f	Iterations for recRaiseOne: %d	Iterations for recRaiseHalf: %d\n", k, recRaiseHalf(1.5, k), recRaiseOneNr, recRaiseHalfNr);
		}
	}
}
