package civilstructure;

public class Client extends ValuesBean {

	private double length;
	private double load;
	private double loadPosition;
	private double qq;
	private double qxx1;
	private double qxx2;
	private double x;
	private double moment;
	private double momentPosition;

	public void setting() {
		this.length = getL();
		this.load = getP();
		this.loadPosition = getPx();
		this.x = getX();
		this.qq = getQ();
		this.qxx1 = getQx1();
		this.qxx2 = getQx2();
		this.moment = getM();
		this.momentPosition = getMx();
	}

	public void singleLoadSolve() {
		SingleLoadCalculator singleLoadCalculator = SingleLoadCalculator
				.getSingleLoadCalculator();
		singleLoadCalculator.singleLoadsolve(length, load, loadPosition, x);
	}

	public void distributedLoadSolve() {
		DistributedLoadCalculator distributedLoadCalculator = DistributedLoadCalculator
				.getDistributedLoadCalculator();
		distributedLoadCalculator.distributedLoadSolve(length, qq, qxx1, qxx2,
				x);
	}

	public void momentSolve() {
		MomentCalculator momentCalculator = MomentCalculator
				.getMomentCalculator();
		momentCalculator.momentSolve(length, moment, momentPosition, x);
	}
}
