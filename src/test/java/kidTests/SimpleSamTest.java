package kidTests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.entity.kids.Kid;
import model.entity.kids.SimpleSam;

public class SimpleSamTest {

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
		double hpRat = sam.getHpRatio();
		sam.hitByCandy("JellyBean", 50);
		assertTrue("Sam gets weaker by JellyBean", sam.getHpRatio() < hpRat);
		// TODO: tests for other candies when I've decided exactly how Sam should behave
	}

	@Test
	public void testSimpleSam() {
		SimpleSam sam = new SimpleSam(500, 300);
		assertNotNull("Sam is not null", sam);
		assertEquals("Sam gets head radius 5", 5, sam.getHeadRadius(), 1e-16);
		assertEquals("Sam gets radius 10", 10, sam.getRadius(), 1e-16);
		assertEquals("Sam has full hp at start", 1, sam.getHpRatio(), 1e-16);
	}

	@Test
	public void testGenerateId() {
		SimpleSam sam1 = new SimpleSam(500, 300);
		SimpleSam sam2 = new SimpleSam(500, 300);
		assertNotEquals("Sams have unique ids", sam1.getId(), sam2.getId());
	}

	@Test
	public void testIsExpired() {
		SimpleSam sam = new SimpleSam(500, 300);
		assertTrue("Sam is expored if entered store or dead", 
				sam.isExpired() == sam.enteredStore() || sam.getHpRatio() == 0);
	}

	@Test
	public void testGetId() {
		SimpleSam sam = new SimpleSam(500, 300);
		assertEquals("Sam id starts with k", "k", sam.getId().substring(0, 1));
	}

	@Test
	public void testGetRadius() {
		SimpleSam sam = new SimpleSam(500, 300);
		float r1 = sam.getRadius();
		sam.update(0.1);
		sam.hitByCandy("JellyBean", 100);
		assertEquals("Sam has constant radius", 10, r1, 1e-16);
	}

	@Test
	public void testKid() {
		Kid sam = new SimpleSam(500, 300);
		assertNotNull("Sam not null");
		assertEquals("Sam gets correct xPos", 500, sam.getX(), 1e-16);
		assertEquals("Sam gets correct yPos", 300, sam.getY(), 1e-16);
		assertEquals("Sams id starts with k", "k", sam.getId().substring(0, 1));
		assertFalse("Sam isn't expired", sam.isExpired());
	}

	@Test
	public void testGetHeadY() {
		Kid sam = new SimpleSam(500, 300);
		assertEquals("Sam has correct yPos", (float)(300+10+5), sam.getHeadY(), 1e-16);
	}
/*
	@Test
	public void testGetHeadRadius() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHpRatio() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnteredStore() {
		fail("Not yet implemented");
	}

	@Test
	public void testEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBoundaries() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUpperBoundary() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLowerBoundary() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLeftBoundary() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRightBoundary() {
		fail("Not yet implemented");
	}
*/
}
