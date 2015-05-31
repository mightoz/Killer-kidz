import model.entity.Entity;
import model.entity.players.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class EntityTest {

    @Test
    public void testGetX(){
        Entity entity = new Player(200, 200, "Pelle");
        float playerX = entity.getX();
        assertTrue("getX returns wrong position", playerX == 200);
    }

    @Test
    public void testGetY(){
        Entity entity = new Player(200, 200, "Pelle");
        float playerY = entity.getY();
        assertTrue("getY returns wrong position", playerY == 200);
    }

    @Test
    public void testGetRadius(){
        Entity entity = new Player(200, 200, "Pelle");
        float playerRadius = entity.getRadius();
        assertTrue("getX returns wrong position", playerRadius == 10);

    }

}