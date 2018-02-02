package voting.blockchain;

import static org.junit.Assert.*;
import org.junit.Assert;

import org.junit.Test;

import voting.blockchain.Login;

public class LoginTest {

	@Test
	public void testVerifyAccount() {
		Login login = new Login();
		boolean check;
		check = login.VerifyAccount("user", "pw");
		Assert.assertEquals(true, check);
	}
	
	@Test
	public void testVerifyAccountFalse() {
		Login login = new Login();
		boolean check;
		check = login.VerifyAccount("error", "wrong");
		Assert.assertEquals(false, check);
	}

}
