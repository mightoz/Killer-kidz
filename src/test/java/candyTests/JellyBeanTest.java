package candyTests;

import model.entity.candymodels.Candy;
import model.entity.candymodels.JellyBean;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class JellyBeanTest {

    @Test
    public void testJellyBean(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new JellyBean(200, 200, candyStatus);
        assertTrue("JellyBean is not created", candy != null);
    }

    @Test
    public void testIsExpired(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new JellyBean(200, 200, candyStatus);
        assertTrue("isExpired() returns wrong value", candy.isExpired() == false);
    }

    @Test
    public void testUpdate(){
        int[] candyStatus = {0,0,0,0};
        Candy candy = new JellyBean(200, 200, candyStatus);
        float initialX = candy.getX();
        candy.update(1.0);
        float newX = candy.getX();
        assertTrue("candy is not updated correctly", initialX < newX);
    }

    @Test
    public void testGetColor(){
    }
}