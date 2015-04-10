package civilstructure;

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
		System.out.println(mdf*1000000000);
		System.out.println(mvv*1000000);
	}

	// singleton
	public static MomentCalculator getMomentCalculator() {
		if (momentCalculator == null) {
			momentCalculator = new MomentCalculator();
		}
		return momentCalculator;
	}

	public void momentSolve(double l, double m, double mx, double x, double e, double i) {
		this.mva = m / l; // calculate Va
		if (x >= 0 && x < mx) {
			this.mv = -mva;
			this.mm = -mva * x;
		} else {
			this.mm = -mva * x - m;
		}
		if (x >= 0 && x <= mx) {
			this.mdf = (-m*x)/(6*l*e*i)*(6*mx*l-3*mx*mx-2*l*l-x*x);
			this.mvv = (-m)/(6*l*e*i)*(6*mx*l - 3*mx*mx - 2*l*l - 3 *x*x);
		} else {
			this.mdf = (-m*(l-x))/(6*l*e*i)*(6*(l-mx)*l-3*(l-mx)*(l-mx)-2*l*l-(l-x)*(l-x));
			this.mvv = (-m)/(6*l*e*i)*(6*(l-mx)*l-3*(l-mx)*(l-mx)-2*l*l-3*(l-x)*(l-x));
		}
		printer();
	};

}
