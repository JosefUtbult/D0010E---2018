package uppgifter;
import uppgifter.Marble;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

    	int millis1;
    	int millis2;

		ArrayList<Integer> temp = new ArrayList<>();

		for(int i = 0; i < 10000000; i++ ){
			temp.add((int)(Math.random() * 1000d));
		}

		long currentMillis;

		currentMillis = System.currentTimeMillis();
		max(temp);
		millis1 = (int) (System.currentTimeMillis() - currentMillis);

		currentMillis = System.currentTimeMillis();
		max2(temp);
		millis2 = (int) (System.currentTimeMillis() - currentMillis);

		System.out.format("Max1: %d	Max2: %d", millis1, millis2);


		//System.out.println(Arrays.toString(paperArk(10)));

    	/*
    	ArrayList<Integer> tempList;
		for(int i = 0; i < 100000; i++ ){

		} */
	}

    static int max(ArrayList<Integer> variables) {
    	int currentMax = Integer.MIN_VALUE;

		for (int currentVariable : variables) {
			currentMax = Integer.max(currentMax, currentVariable);
		}
		return currentMax;
	}

	static int max2(ArrayList<Integer> variables){
    	if(variables.size() < 1){
			return Integer.parseInt(null);
		}
		else if(variables.size() == 1){
    		return variables.get(0);
		}

		int maxVal1 = max2(new ArrayList<>(variables.subList(0, variables.size() / 2)));
		int maxVal2 = max2(new ArrayList<>(variables.subList(variables.size() / 2, variables.size())));

		return maxVal1 > maxVal2 ? maxVal1 : maxVal2;

	}

    public static void sayMjau2(int n){
		System.out.println("Mjau!");
		if(n > 1){
			sayMjau2(n - 1);
		}
	}

	public static boolean even(int n) {
		return n == 0 || odd(Math.abs(n - 1));		//If n == 0, the or operator wont execute the following code,
													//because the result of the operation already is defined, thus
													//stopping the recursion.
	}

	public static boolean odd(int n) {
    	return !(n == 0 || !even(Math.abs(n - 1)));		//Same stuff as even(int n), but with a bunch of not operators
														//to cancel out the fact that this dont work with an or
														//statement.
	}

	public static int[] paperArk(int nr){
		if(nr == 0){
			return new int[]{841, 1189};
		}
		int[] sizes = paperArk(nr - 1);

		return new int[]{sizes[1] / 2, sizes[0]};
	}

}

