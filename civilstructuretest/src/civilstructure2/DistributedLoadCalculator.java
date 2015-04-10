package civilstructure2;

public class DistributedLoadCalculator {

	private double qv; // y value
	private double qm;
	private double qdf1;
	private double qdf2;
	private double qdf3;
	private double qdf;
	private double qvv1;
	private double qvv2;
	private double qvv3;
	private double qvv;

	private static DistributedLoadCalculator distributedLoadCalculator = null;

	public void printer() {
		System.out.println(qv);
		System.out.println(qm);
		System.out.println(qvv3);
	//	System.out.println(qdf3 - qdf2 - qdf1);
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
		
		this.qdf3 = (-q * x * x) / (24 * e * i)
				* (6 * l * l - 4 * l * x + x * x);
		this.qvv3 = (-q * x) / (6 * e * i) * (3 * l * l - 3 * l * x + x * x);

		if (x >= 0 && x <= qx1) {
			this.qdf2 = (-q * x * x) / (24 * e * i)
					* (6 * qx1 * qx1 - 4 * qx1 * x + x * x);
			this.qvv2 = (-q * x) / (6 * e * i)
					* (3 * qx1 * qx1 - 3 * qx1 * x + x * x);
		} else {
			this.qdf2 = (-q * qx1 * qx1 * qx1) / (24 * e * i) * (4 * x - qx1);
			this.qvv2 = (-q * qx1 * qx1 * qx1) / (6 * e * i);
		}

		if (x >= 0 && x <= qx1) {
			this.qdf1 = (-q * (l - qx1) * x * x) / (12 * e * i)
					* (3 * l + 3 * qx1 - 2 * x);
			this.qvv1 = (-q * ((l - qx1) * x)) / (2 * e * i) * (l + qx1 - x);
		} else {
			this.qdf1 = (-q)
					/ (24 * e * i)
					* (x * x * x * x - 4 * l * x * x * x + 6 * l * l * x * x
							- 4 * qx1 * qx1 * qx1 * x + qx1 * qx1 * qx1 * qx1);
			this.qvv1 = (-q)
					/ (6 * e * i)
					* (x * x * x - 3 * l * x * x + 3 * l * l * x - qx1 * qx1
							* qx1);

		}

		printer();
	};

}
