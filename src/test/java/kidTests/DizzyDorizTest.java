package kidTests;

import static org.junit.Assert.*;
import model.entity.kids.DizzyDoriz;

import org.junit.Test;

public class DizzyDorizTest {

	/*
	 * Methods implemented in DizzyDoriz
	 */
	
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
		
	}

	@Test
	public void testHitByCandy() {
		DizzyDoriz doriz = new DizzyDoriz(500, 300);
		doriz.hitByCandy("Chocolate", 50, 0);
		assertEquals("Doriz dies of Chocolate", 0f, doriz.getHpRatio(), 1e-16);
		
		doriz.hitByCandy("candy4", 50, 0);
		assertTrue("Doriz becomes killer kid of candy4", doriz.enraged());
		assertEquals("Doriz gets full hp when becoming killer", 1.0f, doriz.getHpRatio(), 1e-16);
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
