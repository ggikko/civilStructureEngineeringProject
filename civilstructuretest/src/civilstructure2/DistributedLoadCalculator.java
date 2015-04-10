package civilstructure2;

public class DistributedLoadCalculator {

	private double qv; // y value
	private double qva;
	private double qm;
	private double qdf1;
	private double qdf2;
	private double qdf;
	private double qvv1;
	private double qvv2;
	private double qvv;

	private static DistributedLoadCalculator distributedLoadCalculator = null;

	public void printer() {
		System.out.println(qv);
		System.out.println(qm);
		// System.out.println(qvv2 - qvv1);
		// System.out.println(qdf2 - qdf1);
	}

	public static DistributedLoadCalculator getDistributedLoadCalculator() {
		if (distributedLoadCalculator == null) {
			distributedLoadCalculator = new DistributedLoadCalculator();
		}
		return distributedLoadCalculator;
	}

	// need exception process
	public void distributedLoadSolve(double l, double q, double qx1,
			double qx2, double x, double e, double i) {
		if (x >= 0 && x <= qx1) {
			this.qv = -q * (qx2 - qx1);
			this.qm = q * (qx2 - qx1) * x - q * (qx2 - qx1) * (qx2 + qx1) / 2;
		} else if (x > qx1 && x <= qx2) {
			this.qv = -q * (qx2 - qx1) + q * (x - qx1);
			this.qm = q * (qx2 - qx1) * x - q * (qx2 - qx1) * (qx2 + qx1) / 2
					- q * (x - qx1) * (x - (qx1 + x) / 2);
		} else {
			this.qv = -q * (qx2 - qx1) + q * (qx2 - qx1);
			this.qv = q * (qx2 - qx1) * x - q * (qx2 - qx1) * (qx2 + qx1) / 2
					- q * (qx2 - qx1) * (x - (qx1 + qx2) / 2);
		}
		
		

		printer();
	};

}
