package kidTests;

import static org.junit.Assert.*;
import model.entity.kids.SimpleSam;

import org.junit.Test;

public class SimpleSamTest {

	/*
	 * Methods implemented in SimpleSam
	 */
	
	@Test
	public void testSimpleSam() {
		SimpleSam sam = new SimpleSam(500, 300);
		assertNotNull("Sam is not null", sam);
		assertEquals("Sam gets radius 10", 10, sam.getRadius(), 1e-16);
		assertEquals("Sam has full hp at start", 1, sam.getHpRatio(), 1e-16);
	}
	
	@Test
	public void testGetName() {
		SimpleSam sam = new SimpleSam(500, 300);
		assertEquals("Sam has got the right name", "Sam", sam.getName());
	}
	
	@Test
	public void testUpdate() {
		SimpleSam sam = new SimpleSam(500, 300);
		float firstX = sam.getX();
		float firstY = sam.getY();
		sam.update(0.1);
		assertTrue("Sam only moves to the left", sam.getX() < firstX);
		assertEquals("Sam doesn't move vertically", firstY, sam.getY(), 1e-16);
	}

	@Test
	public void testHitByCandy() {
		SimpleSam sam = new SimpleSam(500, 300);
		sam.hitByCandy("JellyBean", 50, 0);
		assertEquals("Sam dies of JellyBean", 0f, sam.getHpRatio(), 1e-16);
		
		sam.hitByCandy("Chocolate", 50, 0);
		assertTrue("Sam becomes killer kid of Chocolate", sam.enraged());
		assertEquals("Sam gets full hp when becoming killer", 1.0f, sam.getHpRatio(), 1e-16);
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
