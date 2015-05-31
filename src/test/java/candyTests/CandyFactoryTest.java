package candyTests;

import model.entity.candymodels.Candy;
import model.entity.candymodels.CandyFactory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class CandyFactoryTest {

    @Test
    public void testThrowCandy(){
        ArrayList<int[]> candyData = new ArrayList();
        int[] jellyBean = new int[4];
        for(int i = 0; i < 4; i++){
            jellyBean[i] = 0;
        }
        candyData.add(0,jellyBean);
        ArrayList<Candy> returnedCandies = CandyFactory.throwCandy(0, candyData, 200, 200);
        assertTrue("throwCandy does not return candies", returnedCandies.size() == 1);
    }
}