package voting.blockchain;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.java.shim.ChaincodeBase;
import org.hyperledger.java.shim.ChaincodeStub;

public abstract class Chaincode extends ChaincodeBase {
	
	private static final Log log = LogFactory.getLog(Chaincode.class);

	// set String variable for chaincode functions
	public static final String _init = "init";
	public static final String _query = "query";
	
	// three main functions: init, query and other functions
	protected abstract String handleInit(ChaincodeStub stub, String[] args);
	protected abstract String handleQuery(ChaincodeStub stub, String[] args);
	protected abstract String handleOther(ChaincodeStub stub, String function, String[] args);
	
	@Override 
	public String run(ChaincodeStub stub, String func, String[] args) {
		String s;
		log.info("Blockchain Hello");
		switch (func) {
			case _init:
				s = handleInit(stub, args);
				break;
			case _query:
				s = handleQuery(stub, args);
				break;
			default:
				s = handleOther(stub, func, args);
				break;
		}
		return s;
	}
}
