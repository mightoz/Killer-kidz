package kidTests;

import static org.junit.Assert.*;
import model.entity.kids.SinEster;

import org.junit.Test;

public class SinEsterTest {

	/*
	 * Methods implemented in SinEster
	 */
	
	@Test
	public void testSinEster() {
		SinEster ester = new SinEster(500, 300);
		assertNotNull("Ester is not null", ester);
		assertEquals("Ester gets radius 10", 10, ester.getRadius(), 1e-16);
		assertEquals("Ester has full hp at start", 1, ester.getHpRatio(), 1e-16);
	}
	
	@Test
	public void testGetName() {
		SinEster ester = new SinEster(500, 300);
		assertEquals("Ester has got the right name", "Ester", ester.getName());
	}
	
	@Test
	public void testUpdate() {
		SinEster ester = new SinEster(500, 300);
		float firstX = ester.getX();
		ester.update(0.1);
		assertTrue("ester only moves to the left", ester.getX() <= firstX);
	}

	@Test
	public void testHitByCandy() {
		SinEster ester = new SinEster(500, 300);
		ester.hitByCandy("Hubbabubba", 50, 0);
		assertEquals("Ester dies of Hubbahubba", 0f, ester.getHpRatio(), 1e-16);
		
		ester.hitByCandy("JellyBean", 50, 0);
		assertTrue("Ester becomes killer kid of JellyBean", ester.enraged());
		assertEquals("Ester gets full hp when becoming killer", 1.0f, ester.getHpRatio(), 1e-16);
	}

	/*
	 * Methods implemented in Kid
	 */
	
	/*
	@Test
	public void testGenerateId() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testIsExpired() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetId() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRadius() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testKid() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetHpRatio() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEnteredStore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEnraged() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTransparency() {
		fail("Not yet implemented"); // TODO
	}
*/

}
