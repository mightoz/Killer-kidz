package kidTests;

import static org.junit.Assert.*;
import model.entity.Entity;
import model.entity.kids.DizzyDoriz;

import org.junit.Test;

/**
 * Testing methods in DizzyDoriz
 * @author MarieKlevedal
 * @version 1.0
 */
public class DizzyDorizTest {

	@Test
	public void testDizzyDoriz() {
		DizzyDoriz doriz = new DizzyDoriz(500, 300);
		assertNotNull("Doriz is not null", doriz);
		assertEquals("Doriz gets radius 10", 10, doriz.getRadius(), 1e-16);
		assertEquals("Doriz has full hp at start", 1, doriz.getHpRatio(), 1e-16);
	}
	
	@Test
	public void testGetName() {
		DizzyDoriz doriz = new DizzyDoriz(500, 300);
		assertEquals("Doriz has got the right name", "Doriz", doriz.getName());
	}
	
	@Test
	public void testUpdate() {
		Entity.setBoundaries(0, 1000, 1000, 0);
		
		DizzyDoriz doriz = new DizzyDoriz(500, 300);
		doriz.update(0.1);
		assertTrue("Doriz doesn't escape playfield to the right", 
				doriz.getX() + doriz.getRadius() <= DizzyDoriz.getRightBoundary());
		assertTrue("Doriz doesn't escape above playfield", 
				doriz.getY() + doriz.getRadius() <= DizzyDoriz.getUpperBoundary());
		assertTrue("Doriz doesn't escape below playfield", 
				doriz.getY() - doriz.getRadius() >= DizzyDoriz.getLowerBoundary());
	}

	@Test
	public void testHitByCandy() {
		DizzyDoriz doriz = new DizzyDoriz(500, 300);
		
		// Favourite candy
		doriz.hitByCandy("Chocolate", 50, 0);
		assertEquals("Doriz dies of Chocolate", 0f, doriz.getHpRatio(), 1e-16);
		
		// Killer instinct triggering candy
		doriz.hitByCandy("candy4", 50, 0);
		assertTrue("Doriz becomes killer kid of candy4", doriz.enraged());
		assertEquals("Doriz gets full hp when becoming killer", 1.0f, doriz.getHpRatio(), 1e-16);
		
		doriz = new DizzyDoriz(500, 300);
		
		// JellyBean and Hubbabubba make Doriz weaker
		float hpRat1 = doriz.getHpRatio();
		doriz.hitByCandy("JellyBean", 30, 0);
		float hpRat2 = doriz.getHpRatio();
		assertTrue("Doriz gets weaker by JellyBean", hpRat2 < hpRat1);
		doriz.hitByCandy("Hubbabubba", 30, 0.3);
		float hpRat3 = doriz.getHpRatio();
		assertTrue("Doriz gets weaker by Hubbahubba", hpRat3 < hpRat2);
		
	}

}
