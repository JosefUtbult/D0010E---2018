package uppgifter;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //System.out.println(rekAntal(8888889, 8));
		//System.out.println(new Room().neighbors());
		System.out.println(trim("\t\t   \n\tHere\t\tto stay"));
	}

    public static int itAntal(long tal, int siffra){

    	int antal = 0;

    	while(tal >= 10){

    		if(tal % 10 == siffra){
    			antal++;
			}

			tal /= 10;

		}

		return antal;

    }

	public static int rekAntal(long tal, int siffra){


    	if(tal < 9){
    		return tal == siffra ? 1 : 0;
		}
		else{
    		return (tal % 10 == siffra ? 1 : 0) + rekAntal(tal / 10, siffra);
		}
	}

	public static String trim(String s){
		while (Character.isWhitespace(s.charAt(0))){
			s = s.substring(1);
		}

		return s;
	}


}

abstract class Vehicle{
	abstract double oil();
}

class ToyotaCorolla extends Vehicle {

	public ToyotaCorolla(int doors, int engine){

	}

	@Override
	double oil() {
		return 1.25;
	}
}

class Room{
	Room[] nextRoom(){
		Room equalRoom = new Room();
		return new Room[]{new Room(), equalRoom, new Room(), equalRoom, new Room(), equalRoom};
	}


	public int neighbors(){
		ArrayList<Room> buffer = new ArrayList<>();
		for (Room currentRoom : this.nextRoom() ) {
			boolean exists = false;
			for(Room currentIndex : buffer){
				if(currentIndex.hashCode() == currentRoom.hashCode()){
					exists = true;
					break;
				}
			}
			if(!exists){
				buffer.add(currentRoom);
			}
		}
		return buffer.size();


	}
}


