package kidTests;


import static org.junit.Assert.*;

import org.junit.Test;

import model.entity.kids.DizzyDoriz;
import model.entity.kids.GrandalfTheGrey;
import model.entity.kids.Kid;
import model.entity.kids.SimpleSam;
import model.entity.kids.SinEster;

/**
 * Testing methods in Kid
 * @author MarieKlevedal
 * @version 1.0
 */
public class KidTest {

	@Test
	public void testKid() {
		Kid kid = new SimpleSam(500, 300);
		assertNotNull("Kid is not null", kid);
		
		assertEquals("Kid gets correct xPos", 500, kid.getX(), 1e-16);
		assertEquals("Kid gets correct yPos", 300, kid.getY(), 1e-16);
		
		assertFalse("Kid is not expired", kid.isExpired());
		assertFalse("Kid is not in store", kid.enteredStore());
		assertFalse("Kid is not in killer mode", kid.enraged());
		assertEquals("Kid is completely visible", 1, kid.getTransparency(), 1e-16);

	}

	@Test
	public void testGenerateId() {
		Kid kid = new DizzyDoriz(500, 300);
		assertEquals("Kid gets id starting with k", "k", kid.getId().substring(0, 1));
		Kid kid2 = new DizzyDoriz(500, 300);
		assertNotEquals("Kids get unique ids", kid.getId(), kid2.getId());
	}

	@Test
	public void testGetHpRatio() {
		Kid kid = new SinEster(500, 300);
		assertTrue("Hp ratio is at least 0", kid.getHpRatio() >= 0);
		assertTrue("Hp ratio is at most 1", kid.getHpRatio() <= 1);
	}

	@Test
	public void testEnteredStore() {
		Kid kid = new GrandalfTheGrey(500, 300);
		assertSame("Kid entered store if behind left boundary", 
				kid.getX()+kid.getRadius() <= 0, kid.enteredStore());
	}

	@Test
	public void testIsExpired() {
		Kid kid = new SimpleSam(500, 300);
		assertSame("Kid expired if entered store or dead", kid.enteredStore() || kid.getHpRatio() == 0, kid.isExpired());
	}

	@Test
	public void testEnraged() {
		Kid kid1 = new SimpleSam(500, 300);
		kid1.hitByCandy("Chocolate", 1, 0);
		assertTrue("Sam enraged by Chocolate", kid1.enraged());
		
		Kid kid2 = new DizzyDoriz(500, 300);
		kid2.hitByCandy("candy4", 1, 0);
		assertTrue("Doriz enraged by candy4", kid2.enraged());
		
		Kid kid3 = new SinEster(500, 300);
		kid3.hitByCandy("JellyBean", 1, 0);
		assertTrue("Ester enraged by JellyBean", kid3.enraged());
		
		Kid kid4 = new GrandalfTheGrey(500, 300);
		kid4.hitByCandy("Hubbabubba", 1, 0);
		assertTrue("Grandalf enraged by Hubbabubba", kid4.enraged());
	}

	@Test
	public void testGetTransparency() {
		Kid kid = new SinEster(500, 300);
		kid.hitByCandy("JellyBean", 1, 0);
		kid.update(0.1);
		assertTrue("Ester becomes less visible when in killer mode", kid.getTransparency() < 1);
	}

}
