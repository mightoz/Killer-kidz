package kidTests;

import static org.junit.Assert.*;
import model.entity.kids.GrandalfTheGrey;

import org.junit.Test;

/**
 * Testing methods in GrandalfTheGrey
 * @author MarieKlevedal
 * @version 1.0
 */
public class GrandalfTheGreyTest {

	@Test
	public void testGrandalfTheGrey() {
		GrandalfTheGrey grandalf = new GrandalfTheGrey(500, 300);
		assertNotNull("Grandalf is not null", grandalf);
		assertEquals("Grandalf gets radius 5", 5, grandalf.getRadius(), 1e-16);
		assertEquals("Grandalf has 40% hp at start", 0.4, grandalf.getHpRatio(), 1e-3);
	}
	
	@Test
	public void testGetName() {
		GrandalfTheGrey grandalf = new GrandalfTheGrey(500, 300);
		assertEquals("Grandalf has got the right name", "Grandalf", grandalf.getName());
	}
	
	@Test
	public void testUpdate() {
		GrandalfTheGrey grandalf = new GrandalfTheGrey(500, 300);
		float firstX = grandalf.getX();
		float firstY = grandalf.getY();
		grandalf.update(0.1);
		assertTrue("Grandalf only moves to the left", grandalf.getX() < firstX);
		assertEquals("Grandalf doesn't move vertically", firstY, grandalf.getY(), 1e-16);
	}

	@Test
	public void testHitByCandy() {
		GrandalfTheGrey grandalf = new GrandalfTheGrey(500, 300);
		
		// Favourite candy
		grandalf.hitByCandy("candy4", 50, 0);
		assertSame("Grandalf dies of candy4 if he's not in killer mode", !grandalf.enraged(), grandalf.getHpRatio() == 0f);
		
		// Killer instinct triggering candy
		grandalf.hitByCandy("Hubbabubba", 50, 0);
		assertTrue("Grandalf becomes killer kid of Hubbabubba", grandalf.enraged());
		assertEquals("Grandalf gets full hp when becoming killer", 1, grandalf.getHpRatio(), 1e-16);
		assertEquals("Grandalf gets max radius when becoming killer", 30, grandalf.getRadius(), 1e-16);
		
		grandalf = new GrandalfTheGrey(500, 300);
		
		// JellyBean and Chocolate make Grandalf weaker
		float hpRat1 = grandalf.getHpRatio();
		grandalf.hitByCandy("JellyBean", 30, 0);
		float hpRat2 = grandalf.getHpRatio();
		assertTrue("Grandalf gets weaker by JellyBean", hpRat2 < hpRat1);
		grandalf.hitByCandy("Chocolate", 30, 0);
		float hpRat3 = grandalf.getHpRatio();
		assertTrue("Grandalf gets weaker by Chocolate", hpRat3 < hpRat2);
				
	}

}
