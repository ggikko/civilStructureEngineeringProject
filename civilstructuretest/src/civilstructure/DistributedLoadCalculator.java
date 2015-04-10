package civilstructure;

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
		System.out.println(qvv2-qvv1);
		System.out.println(qdf2-qdf1);
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
		int u = 1000000000;
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
		if (x >= 0 && x <= qx2) {
			this.qdf2 = u*(q * x)
					/ (24 * l * e * i)
					* (qx2 * qx2 * qx2 * qx2 - 4 * qx2 * qx2 * qx2 * l + 4
							* qx2 * qx2 * l * l + 2 * qx2 * qx2 * x * x - 4
							* qx2 * l * x * x + l * x * x * x);

			this.qvv2 = u/1000*(-q)
					/ (24 * l * e * i)
					* (qx2 * qx2 * qx2 * qx2 - 4 * qx2 * qx2 * qx2 * l + 4
							* qx2 * qx2 * l * l + 6 * qx2 * qx2 * x * x - 12
							* qx2 * l * x * x + 4 * l * x * x * x);

		} else {
			// qx2 = l-qx2 , x = l-x

			this.qdf2 = u*(q * qx2 * qx2)
					/ (24 * l * e * i)
					* (-qx2 * qx2 * l + 4 * l * l * x + qx2 * qx2 * x - 6 * l
							* x * x + 2 * x * x * x);
			this.qvv2 = u/1000*(-q * qx2 * qx2) / (24 * l * e * i)
					* (4 * l * l + qx2 * qx2 - 12 * l * x + 6 * x * x);

		}

		if (x >= 0 && x <= qx1) {
			this.qdf1 = u*(q * x)
					/ (24 * l * e * i)
					* (qx1 * qx1 * qx1 * qx1 - 4 * qx1 * qx1 * qx1 * l + 4
							* qx1 * qx1 * l * l + 2 * qx1 * qx1 * x * x - 4
							* qx1 * l * x * x + l * x * x * x);

			this.qvv1 = u/1000*(-q)
					/ (24 * l * e * i)
					* (qx1 * qx1 * qx1 * qx1 - 4 * qx1 * qx1 * qx1 * l + 4
							* qx1 * qx1 * l * l + 6 * qx1 * qx1 * x * x - 12
							* qx1 * l * x * x + 4 * l * x * x * x);

		} else {
			// qx2 = l-qx2 , x = l-x

			this.qdf1 = u*(q * qx1 * qx1)
					/ (24 * l * e * i)
					* (-qx1 * qx1 * l + 4 * l * l * x + qx1 * qx1 * x - 6 * l
							* x * x + 2 * x * x * x);
			this.qvv1 = u/1000*(-q * qx1 * qx1) / (24 * l * e * i)
					* (4 * l * l + qx1 * qx1 - 12 * l * x + 6 * x * x);

		}

		printer();
	};

}
