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
			this.qdf2 = (-q * x)
					/ (24 * l * e * i)
					* (qx2 * qx2 * qx2 * qx2 - 4 * qx2 * qx2 * qx2 * l + 4
							* qx2 * qx2 * l * l + 2 * qx2 * qx2 * x * x - 4
							* qx2 * l * x * x + l * x * x * x);

			this.qvv2 = (-q)
					/ (24 * l * e * i)
					* (qx2 * qx2 * qx2 * qx2 - 4 * qx2 * qx2 * qx2 * l + 4
							* qx2 * qx2 * l * l + 6 * qx2 * qx2 * x * x - 12
							* qx2 * l * x * x + 4 * l * x * x * x);
			;

		} else {
			// qx2 = l-qx2 , x = l-x

			this.qdf2 = (-q * (l - x))
					/ (24 * l * e * i)
					* ((l - qx2) * (l - qx2) * (l - qx2) * (l - qx2) - 4
							* (l - qx2) * (l - qx2) * (l - qx2) * l + 4
							* (l - qx2) * (l - qx2) * l * l + 2 * (l - qx2)
							* (l - qx2) * x * x - 4 * (l - qx2) * l * x * x + l
							* (l - qx2) * (l - qx2) * (l - qx2));

			this.qvv2 = (-q)
					/ (24 * l * e * i)
					* ((l - qx2) * (l - qx2) * (l - qx2) * (l - qx2) - 4
							* (l - qx2) * (l - qx2) * (l - qx2) * l + 4
							* (l - qx2) * (l - qx2) * l * l + 6 * (l - qx2)
							* (l - qx2) * (l - x) * (l - x) - 12 * (l - qx2)
							* l * (l - x) * (l - x) + 4 * l * (l - x) * (l - x)
							* (l - x));

		}
		
		if (x >= 0 && x <= qx1) {
			this.qdf1 = (-q * x)
					/ (24 * l * e * i)
					* (qx1 * qx1 * qx1 * qx1 - 4 * qx1 * qx1 * qx1 * l + 4
							* qx1 * qx1 * l * l + 2 * qx1 * qx1 * x * x - 4
							* qx1 * l * x * x + l * x * x * x);

			this.qvv1 = (-q)
					/ (24 * l * e * i)
					* (qx1 * qx1 * qx1 * qx1 - 4 * qx1 * qx1 * qx1 * l + 4
							* qx1 * qx1 * l * l + 6 * qx1 * qx1 * x * x - 12
							* qx1 * l * x * x + 4 * l * x * x * x);
			;

		} else {
			// qx2 = l-qx2 , x = l-x

			this.qdf1 = (-q * (l - x))
					/ (24 * l * e * i)
					* ((l - qx1) * (l - qx1) * (l - qx1) * (l - qx1) - 4
							* (l - qx1) * (l - qx1) * (l - qx1) * l + 4
							* (l - qx1) * (l - qx1) * l * l + 2 * (l - qx1)
							* (l - qx1) * x * x - 4 * (l - qx1) * l * x * x + l
							* (l - qx1) * (l - qx1) * (l - qx1));

			this.qvv1 = (-q)
					/ (24 * l * e * i)
					* ((l - qx1) * (l - qx1) * (l - qx1) * (l - qx1) - 4
							* (l - qx1) * (l - qx1) * (l - qx1) * l + 4
							* (l - qx1) * (l - qx1) * l * l + 6 * (l - qx1)
							* (l - qx1) * (l - x) * (l - x) - 12 * (l - qx1)
							* l * (l - x) * (l - x) + 4 * l * (l - x) * (l - x)
							* (l - x));

		}
		this.qvv = qvv1+qvv2;
		this.qdf = qdf1+qdf2;

		printer();
	};

}
