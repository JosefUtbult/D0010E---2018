package uppgifter;

public class Egg{
	private int productionmethod;
	private String origin;
	private int factory;

	public Egg(int productionmethod, String origin, int factory){
		this.productionmethod = productionmethod;
		this.origin = origin;
		this.factory = factory;
	}

	public int getProductionmethod() {
		return productionmethod;
	}

	public void setProductionmethod(int productionmethod) {
		this.productionmethod = productionmethod;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getFactory() {
		return factory;
	}

	public void setFactory(int factory) {
		this.factory = factory;
	}
}
