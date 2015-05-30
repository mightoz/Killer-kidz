package model.entity.players;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-29.
 */
public class PlayerTest {

    @Test
    public void testAddCandy() throws Exception {

    }

    @Test
    public void testUpgradeCandy() throws Exception {

    }

    @Test
    public void testGetCandyData() throws Exception {

    }

    @Test
    public void testThrowCandy() throws Exception {

    }

    @Test
    public void testUpdateDir(){

    }

    @Test
    public void testUpdate(){
        Player player = new Player(100, 100, "Kalle");
        boolean[] directions = {false, true, false, false};
        player.updateDir(directions);
        float initialY = player.getY();
        float initialX = player.getX();

        player.update(0.1);

        assertTrue("Spelaren rör sig inte", player.getY() > initialY);
        //assertEquals("Spelaren rör sig åt fel håll", initialX, player.getX(), 1e-16);

    }

    @Test
    public void testGetSelectedCandy() throws Exception {

    }

    @Test
    public void testGenerateId() throws Exception {

    }

    @Test
    public void testGetActiveCandies() throws Exception {

    }

    @Test
    public void testIsExpired() throws Exception {

    }

    @Test
    public void testGetId() throws Exception {

    }
}