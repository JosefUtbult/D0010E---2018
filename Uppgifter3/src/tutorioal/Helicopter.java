package tutorioal;

public class Helicopter {
	private String callSign = "";
	private long rtX = 0L, rtY = 0L;
	private double distanceFlown = 0.0d;

	public Helicopter(String name) {
		callSign = name;
	}

	public void
	flyTo(long x, long y) {
		double dx = Math.abs(x - rtX);
		double dy = Math.abs(y - rtY);
		distanceFlown += Math.sqrt(dx * dx + dy * dy);
		rtX = x;
		rtY = y;
	}

	public String callSign() {
		return callSign;
	}

	public long getX() {
		return rtX;
	}

	public long getY() {
		return rtY;
	}

	public double distanceFlown() {
		return distanceFlown;
	}
}
