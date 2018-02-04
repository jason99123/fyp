package voting.blockchain;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class MainTest {

	@Test
	public void testverifyLogin() {
		boolean check;
		check = Main.verifyLogin("user", "pw");
		Assert.assertEquals(check, true);
	}
	
	@Test
	public void testverifyLoginWrong() {
		boolean check;
		check = Main.verifyLogin("wrong", "wrong");
		Assert.assertEquals(check, false);
	}

}
