package civilstructure;

public class SingleLoadCalculator {

	private double pv; // y value
	private double pva;
	private double pm;
	private double pdf;
	private double pvv;

	private static SingleLoadCalculator singleLoadCalculator = null;

	public void printer() {
		System.out.println(pv);
		System.out.println(pm);
		System.err.println((pdf)*1000000000);
		System.out.println((pvv)*1000000);
	}

	// singleton
	public static SingleLoadCalculator getSingleLoadCalculator() {
		if (singleLoadCalculator == null) {
			singleLoadCalculator = new SingleLoadCalculator();
		}
		return singleLoadCalculator;
	}

	public void singleLoadsolve(double l, double p, double px, double x,
			double e, double i) {
		
		this.pva = p * (l - px) / l; // calculate Va
		if (x >= 0 && x <= px) { // if 0<x<x1
			this.pv = -pva;
			this.pm = pva * x;
		} else { // if x1<x<L
			this.pv = -pva + p;
			this.pm = pva * x - p * (x - px);
		}// add deflection function
		if (x >= 0 && x <= px) {
			this.pdf = (-p * (l - px) * x) / (6 * l * e * i)
					* (l * l - (l - px) * (l - px) - x * x);
			this.pvv = (-p*(1-px))/(6*l*e*i)*(l*l-(1-px)*(1-px)-3*x*x);
		} else {
			this.pdf = (-p * px * (l - x)) / (6 * l * e * i)
					* (l * l - px * px - ((l - x) * (l - x)));
			this.pvv = (-p*px)/(6*l*e*i)*(l*l-(px*px)-3*(l-x)*(l-x));

		}

		printer();
	}

}
