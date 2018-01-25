package voting.blockchain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.java.shim.ChaincodeStub;


public class Main extends Chaincode{
	
	private final static Log log = LogFactory.getLog(Main.class);
	
	public final static String chaincodeID = "VotingBlockchain";
	
	public final static String PREFIX = chaincodeID + "-CLSC-";
	
	public static void main(String [] args) {
		new Main().start(args);
		Login login = new Login();
	}
	
	public static boolean verifyLogin(String user, String pw) {
		boolean check = false;
		
		if (user.equals("user")&&pw.equals("pw")) {
			check = true;
		} else {
			check = false;
		}
		
		return check;	
	}

/*	private static void VerifyUser() {
		Login login = new Login();
		boolean check = false;
		while (check == false) {
			String user;
			user = login.readUser();
			String pw;
			pw = login.readPw();
			check = login.VerifyAccount(user,pw);
		} 
	}
*/
	public static void afterLogin() {
		System.out.println("ok");
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
		StringBuilder s = new StringBuilder();
		for (String key : args) {
			String prefixKey = PREFIX+key;
			String value = stub.getState(prefixKey);
			log.info("Query: "+prefixKey+" Value: "+value);
			s.append(value);
		}
		return s.toString();
		
	}

	@Override
	protected String handleOther(ChaincodeStub stub, String func, String[] args) {
		String s;
		switch (func) {
		case "log":
			s = handleLog(stub, args);
			break;
		default:
			s = "Function not found: "+func;
			break;
		}
		return s;
	}

	
}
