package civilstructure2;

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
		System.err.println(pdf);
		System.out.println(pvv);
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
		if(x>=0 && x<=px){
			this.pv = -p;
			this.pm = (-p*px)+(p*x);
			this.pdf = (-p*x*x)/(6*e*i)*(3*px-x);
			this.pvv = (-p*x)/(2*e*i)*(2*px-x);
		}else{
			this.pv = 0;
			this.pm = 0;
			this.pdf =  (-p*px*px)/(6*e*i)*(3*x-px);
			this.pvv = (-p*px*px)/(2*e*i);
		}
		
		

		printer();
	}
}
