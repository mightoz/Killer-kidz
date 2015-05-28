package kidTests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.entity.kids.Kid;
import model.entity.kids.SimpleSam;

public class SimpleSamTest {

	@Test
	public void testUpdate() {
		// Makes sure that Sam keeps moving to the left,
		// but keep the same yPos
		Kid sam = new SimpleSam(500, 300);
		float firstX = sam.getX();
		float firstY = sam.getY();
		sam.update(0.1);
		assertTrue(sam.getX() < firstX && sam.getY() == firstY);
	}

	@Test
	public void testHitByCandy() {
		fail("Not yet implemented");
	}

	@Test
	public void testSimpleSam() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateId() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExpired() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRadius() {
		fail("Not yet implemented");
	}

	@Test
	public void testKid() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeadY() {
		fail("Not yet implemented");
	}

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

}
