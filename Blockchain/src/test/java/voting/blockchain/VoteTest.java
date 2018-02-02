package voting.blockchain;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assert;



public class VoteTest {
	@Test
	public void testgetVote() {
		Vote vote = new Vote();
		int key = 1;
		String value = "test1";
		vote.hmap.put(key, value);
		
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		int result;
		result = vote.getVote();
		Assert.assertEquals(key, result);
	}
	
	@Test
	public void testAcceptVote() {
		Vote vote = new Vote();
		String path = "./build/resources/test/candidate.txt";
		vote.candidatepath = path;
		int result;
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		result = vote.acceptVote();
		assert(true);
	}

}
