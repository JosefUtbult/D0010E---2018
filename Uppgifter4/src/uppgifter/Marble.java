package uppgifter;

public class Marble{
	public double radius;
	public double posX;
	public double posY;
	public double posZ;

	public Marble(double radius, double posX, double posY, double posZ){
		this.radius = Math.abs(radius);
		this.posX = Math.abs(posX);
		this.posY = Math.abs(posY);			//I wont go into negative positions for simplicities sake
		this.posZ = Math.abs(posZ);
	}

	public static boolean collides(Marble s1, Marble s2){

		return Math.sqrt(Math.pow(relation(s1.posX, s2.posX), 2) +
						 Math.pow(relation(s1.posY, s2.posY), 2) +		//Pythagoras theorem in 3 dimensions compared to
						 Math.pow(relation(s1.posZ, s2.posZ), 2))		//the combined radius of the two
						 <= s1.radius + s2.radius;
	}

	private static double relation(double pos1, double pos2){
		return pos1 > pos2 ? pos1 - pos2 : pos2 - pos1;
	}
}
