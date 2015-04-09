package civilstructure;

public class View {

	public static void main(String[] args) {
		Client client = new Client();
	//	Client client2 = new Client();
		
		client.setL(10); // length
	//	client2.setL(10);
		
		client.setP(10); // Single Load
		client.setPx(2); // Single Load Position
		
	//	client2.setP(10); // Single Load
		//	client2.setPx(5);
		
		client.setQ(10);
		client.setQx1(3);
		client.setQx2(5);
		
		client.setM(10);
		client.setMx(5);
		
		client.setX(3);  // x Value
		
		client.setElasticity(200);
		client.setInertia(20*20*20*20/12);
		
		
		client.setting();
		//client2.setting();
		
		client.singleLoadSolve();
	//	client2.singleLoadSolve();
		
		
	//	client.distributedLoadSolve();
//		client.momentSolve();
		
		
	}

}

