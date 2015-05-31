package kidTests;

import static org.junit.Assert.*;
import model.entity.kids.SinEster;

import org.junit.Test;

/**
 * Testing methods in SinEster
 * @author MarieKlevedal
 * @version 1.0
 */
public class SinEsterTest {

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
		
		// Favourite candy
		ester.hitByCandy("Hubbabubba", 50, 0);
		assertEquals("Ester dies of Hubbahubba", 0f, ester.getHpRatio(), 1e-16);
		
		// Killer instinct triggering candy
		ester.hitByCandy("JellyBean", 50, 0);
		assertTrue("Ester becomes killer kid of JellyBean", ester.enraged());
		assertEquals("Ester gets full hp when becoming killer", 1.0f, ester.getHpRatio(), 1e-16);
		
		// Chocolate and candy4 make Ester weaker
		float hpRat1 = ester.getHpRatio();
		ester.hitByCandy("Chocolate", 30, 0);
		float hpRat2 = ester.getHpRatio();
		assertTrue("Ester gets weaker by Chocolate", hpRat2 < hpRat1);
		ester.hitByCandy("candy4", 30, 0);
		float hpRat3 = ester.getHpRatio();
		assertTrue("Ester gets weaker by candy4", hpRat3 < hpRat2);
		
	}

}
