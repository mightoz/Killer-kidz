package candyTests;

import model.entity.candymodels.Candy;
import model.entity.candymodels.Chocolate;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class ChocolateTest {

    @Test
    public void testChocolate(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new Chocolate(200, 200, candyStatus);
        assertTrue("Chocolate is not created", candy != null);
    }

    @Test
    public void testUpdate(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new Chocolate(200, 200, candyStatus);
        float initialX = candy.getX();
        candy.update(1.0);
        float newX = candy.getX();
        assertTrue("Chocolate is not updated correctly", initialX < newX);
    }

    @Test
    public void testIsExpired(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new Chocolate(200, 200, candyStatus);
        boolean status = candy.isExpired();
        assertTrue("isExpired does not return the correct value", status == false);
    }
}