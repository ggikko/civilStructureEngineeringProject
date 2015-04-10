package civilstructure2;

public class MomentCalculator {

	private double mv; // y value
	private double mm;
	private double mva;
	private double mdf;
	private double mvv;

	private static MomentCalculator momentCalculator = null;

	public void printer() {
		System.out.println(mv);
		System.out.println(mm);
		System.out.println(mdf*-1000000000);
		System.out.println(mvv*1000000);
	}

	// singleton
	public static MomentCalculator getMomentCalculator() {
		if (momentCalculator == null) {
			momentCalculator = new MomentCalculator();
		}
		return momentCalculator;
	}

	public void momentSolve(double l, double m, double mx, double x, double e,
			double i) {
		if (x >= 0 && x <= mx) {
			this.mv = 0;
			this.mm = m;
			this.mdf = (-m * x * x) / (2 * e * i);
			this.mvv = (-m * x) / (e * i);

		} else {
			this.mv = 0;
			this.mm = 0;
			this.mdf = (-m * x * x) / (2 * e * i);
			this.mvv = (-m * x) / (e * i);

		}

		printer();
	};

}
