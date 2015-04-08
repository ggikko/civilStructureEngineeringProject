package civilstructure;

public class DistributedLoadCalculator {

	private double qv; // y value
	private double qva;
	private double qm;

	private static DistributedLoadCalculator distributedLoadCalculator = null;

	public void printer() {
		System.out.println(qv);
		System.out.println(qm);
	}

	public static DistributedLoadCalculator getDistributedLoadCalculator() {
		if (distributedLoadCalculator == null) {
			distributedLoadCalculator = new DistributedLoadCalculator();
		}
		return distributedLoadCalculator;
	}
	// need exception process
	public void distributedLoadSolve(double l, double q, double qx1,
			double qx2, double x) {
		this.qva = ((q) * (qx2 - qx1) * (l - (qx1 + qx2) / 2)) / l; // calculate
		// Va
		if (x >= 0 && x <= qx1) { // if 0<x<x1
			this.qv = -qva;
			this.qm = qva * x;
		}
		if (x > qx1 && x <= qx2) { // if x1<x<x2
			this.qv = -qva + q * (x - qx1);
			this.qm = qva * x + (-q) * (x - qx1) * (x - (x + qx1) / 2);
		} else { // if x2<x<L
			this.qv = -qva + q * (qx2 - qx1);
			this.qm = qva * x + (-q) * (qx2 - qx1) * (x - (qx2 + qx1) / 2);
		}

		printer();
	};

}
