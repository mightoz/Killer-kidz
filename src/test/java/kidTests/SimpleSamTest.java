package kidTests;

import static org.junit.Assert.*;
import model.entity.kids.SimpleSam;

import org.junit.Test;

/**
 * Testing methods in SimpleSam
 * @author MarieKlevedal
 * @version 1.0
 */
public class SimpleSamTest {

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
		
		// Favourite candy
		sam.hitByCandy("JellyBean", 50, 0);
		assertEquals("Sam dies of JellyBean", 0f, sam.getHpRatio(), 1e-16);
		
		// Killer instinct triggering candy
		sam.hitByCandy("Chocolate", 50, 0);
		assertTrue("Sam becomes killer kid of Chocolate", sam.enraged());
		assertEquals("Sam gets full hp when becoming killer", 1f, sam.getHpRatio(), 1e-16);	
		sam.hitByCandy("JellyBean", 50, 0);
		assertEquals("Sam is now immune", 1f, sam.getHpRatio(), 1e-16);
		
		sam = new SimpleSam(500, 300);
		
		// Hubbabubba slows down and weakens Sam
		float x1 = sam.getX();
		sam.update(0.1);
		float x2 = sam.getX();
		float hpRat1 = sam.getHpRatio();
		sam.hitByCandy("Hubbabubba", 30, 0.3);
		float x3 = sam.getX();
		assertTrue("Sam get slower by Hubbabubba", x2-x3 < x1-x2);
		float hpRat2 = sam.getHpRatio();
		assertTrue("Sam gets weaker by Hubbabubba", hpRat2 < hpRat1);
		
		// candy4 makes Sam weaker
		sam.hitByCandy("candy4", 20, 0);
		assertTrue("Sam gets weaker by candy4", sam.getHpRatio() < hpRat2);
	}

}
