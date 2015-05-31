package candyTests;

import model.entity.candymodels.Candy;
import model.entity.candymodels.Hubbabubba;
import model.entity.candymodels.JellyBean;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class CandyTest {

    @Test
    public void testGenerateId(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new JellyBean(200, 200, candyStatus);
        Candy candy2 = new JellyBean(200, 200, candyStatus);
        assertTrue("generateId() does not generate unique id's", candy.getId() != candy2.getId());
    }

    @Test
    public void testGetType(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new JellyBean(200, 200, candyStatus);
        Candy candy2 = new Hubbabubba(200, 200, candyStatus);
        assertTrue("getType does not return right candy type", candy.getType().equals("JellyBean") && candy2.getType().equals("Hubbabubba"));
    }

    @Test
    public void testGetDamage(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new JellyBean(200, 200, candyStatus);
        int damage = candy.getDamage();
        assertTrue("getDamage() does not return correct damage", damage == 10);

    }

    @Test
    public void testGetId(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new JellyBean(200, 200, candyStatus);
        String id = candy.getId();
        assertTrue("getId() does not return the id", id != null);
    }

    @Test
    public void testGetSlowRate(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new Hubbabubba(200, 200, candyStatus);
        double slowrate = candy.getSlowRate();
        assertTrue("getSlowRate does not return correct slow rate", slowrate == 0.8);
    }

    @Test
    public void testGetPenCapacity(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new JellyBean(200, 200, candyStatus);
        int penCap = candy.getPenCapacity();
        assertTrue("getPenCapacity() does not return correct penetration capacity", penCap == 0);
    }

    @Test
    public void testDecPenCapacity(){
        int[] candyStatus = {0,0,0,1};
        Candy candy = new JellyBean(200, 200, candyStatus);
        int initialPenCap = candy.getPenCapacity();
        candy.decPenCapacity();
        int newPenCap = candy.getPenCapacity();
        assertTrue("decPenCapacity() does not decrement the penetration capacity", initialPenCap > newPenCap);
    }
}