package model.entity.players;

import model.entity.candymodels.Candy;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-29.
 */
public class PlayerTest {

    @Test
    public void testPlayer(){
        Player player = new Player(200, 200, "Pelle");
        assertTrue("Player is not created", player != null);
    }

    @Test
    public void testAddCandy(){
        Player player = new Player(200, 200, "Pelle");
        int[] data = {0,0,0,0};
        int initialSize = player.getCandyData().size();
        player.addCandy(0, data);
        int size = player.getCandyData().size();
        assertTrue("Candy is not added correctly", initialSize < size);
    }

    @Test
    public void testUpgradeCandy(){
        Player player = new Player(200, 200, "Pelle");
        int[] data = {1,0,0,0};
        ArrayList<int[]> candyData = player.getCandyData();
        int[] initialData = candyData.get(0);
        player.upgradeCandy(0, data);
        ArrayList<int[]> candyData2 = player.getCandyData();
        int[] newData = candyData2.get(0);
        assertTrue("Candy is not upgraded correctly", initialData[0] < newData[0]);
    }

    @Test
    public void testGetCandyData(){
        Player player= new Player(200, 200, "Pelle");
        ArrayList<int[]> candyData = player.getCandyData();
        assertTrue("getCandyData does not return candyData", candyData != null);
    }

    @Test
    public void testThrowCandy(){
        Player player= new Player(200, 200, "Pelle");
        ArrayList<Candy> initialCandies = player.getActiveCandies();
        player.throwCandy();
        ArrayList<Candy> newCandies = player.getActiveCandies();
        assertTrue("Candies are not addedto list correctly", initialCandies.size() < newCandies.size());
    }

    @Test
    public void testUpdateDir(){
        Player player= new Player(200, 200, "Pelle");
        boolean[] directions = {false, false, true, false};
        player.updateDir(directions);
        float initialX = player.getX();
        player.update(1.0);
        float newX = player.getX();
        assertTrue("updateDir() doed not register the right directions", initialX < newX);
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
        assertEquals("Spelaren rör sig åt fel håll", initialX, player.getX(), 1e-16);

    }

    @Test
    public void testGetSelectedCandy(){
        Player player= new Player(200, 200, "Pelle");
        int selectedCandy = player.getSelectedCandy();
        assertTrue("getSelectedCandy returns null", selectedCandy == 0);

    }

    @Test
    public void testGenerateId(){
        Player player = new Player(200, 200, "Pelle");
        Player player2 = new Player(200, 200, "Kalle");
        assertTrue("generateId does not generate new ID's", player.getId() != player2.getId());

    }

    @Test
    public void testGetActiveCandies(){
        Player player= new Player(200, 200, "Pelle");
        ArrayList<Candy> activeCandies = player.getActiveCandies();
        assertTrue("getActiveCandies does not return a list", activeCandies != null);
    }

    @Test
    public void testIsExpired(){
        Player player= new Player(200, 200, "Pelle");
        boolean status = player.isExpired();
        assertTrue("isExpired does not return correct value", status == false);
    }

    @Test
    public void testGetId(){
        Player player= new Player(200, 200, "Pelle");
        String id = player.getId();
        assertTrue("getId() does not return the id", id != null);
    }
}