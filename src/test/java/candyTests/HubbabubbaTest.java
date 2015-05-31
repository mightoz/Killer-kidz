package candyTests;

import model.entity.candymodels.Candy;
import model.entity.candymodels.Hubbabubba;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class HubbabubbaTest {

    @Test
    public void testHubbabubba(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new Hubbabubba(200, 200, candyStatus);
        assertTrue("Hubbabubba is not created", candy != null);
    }

    @Test
    public void testUpdate(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new Hubbabubba(200, 200, candyStatus);
        float initialX = candy.getX();
        candy.update(1.0);
        float newX =candy.getX();
        assertTrue("Hubbabubba is not updated correctly", initialX < newX);
    }

    @Test
    public void testIsExpired(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new Hubbabubba(200, 200, candyStatus);
        boolean status = candy.isExpired();
        assertTrue("isExpired() returns wrong value", status == false);
    }
}