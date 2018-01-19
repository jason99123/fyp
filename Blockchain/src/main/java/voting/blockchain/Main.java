package voting.blockchain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.java.shim.ChaincodeStub;

public class Main extends Chaincode{
	
	private final static Log log = LogFactory.getLog(Main.class);
	
	public final static String chaincodeID = "VotingBlockchain";
	
	public final static String PREFIX = chaincodeID + "-CLSC-";
	
	public static void main(String [] args) {
		System.out.print("ok");
	}
	
	public String getChaincodeID() {
		return chaincodeID;
	}

	@Override
	public String handleInit(ChaincodeStub stub, String[] args) {
		String s;
		s = handleLog(stub, args);
		return s;
	}

	private String handleLog(ChaincodeStub stub, String[] args) {
		String s;
		String key = args[0];
		String msg = args[1];
		log.info("Log message Prefix: "+ PREFIX +" Key: "+key+" Msg: "+msg);
		stub.putState(PREFIX+key, msg);
		s = msg;
		return s;
	}

	@Override
	protected String handleQuery(ChaincodeStub stub, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String handleOther(ChaincodeStub stub, String function, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
