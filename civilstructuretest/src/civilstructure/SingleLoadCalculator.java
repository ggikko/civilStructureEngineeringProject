package civilstructure;

public class SingleLoadCalculator {

	private double pv; // y value
	private double pva;
	private double pm;

	private static SingleLoadCalculator singleLoadCalculator = null;

	public void printer() {
		System.out.println(pv);
		System.out.println(pm);
	}

	// singleton
	public static SingleLoadCalculator getSingleLoadCalculator() {
		if (singleLoadCalculator == null) {
			singleLoadCalculator = new SingleLoadCalculator();
		}
		return singleLoadCalculator;
	}

	public void singleLoadsolve(double l, double p, double px, double x) {
		this.pva = p * (l - px) / l; // calculate Va
		if (x >= 0 && x <= px) { // if 0<x<x1
			this.pv = -pva;
			this.pm = pva * x;
		} else { // if x1<x<L
			this.pv = -pva + p;
			this.pm = pva * x - p * (x - px);
		}
		printer();
	}

}
