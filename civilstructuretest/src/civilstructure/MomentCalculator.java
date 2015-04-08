package civilstructure;

public class MomentCalculator {

	private double mv; // y value
	private double mm;
	private double mva;

	private static MomentCalculator momentCalculator = null;

	public void printer() {
		System.out.println(mv);
		System.out.println(mm);
	}

	// singleton
	public static MomentCalculator getMomentCalculator() {
		if (momentCalculator == null) {
			momentCalculator = new MomentCalculator();
		}
		return momentCalculator;
	}

	public void momentSolve(double l, double m, double mx, double x) {
		this.mva = m / l; // calculate Va
		if (x >= 0 && x < mx) {
			this.mv = -mva;
			this.mm = -mva * x;
		} else {
			this.mm = -mva * x - m;
		}
		printer();
	};

}
