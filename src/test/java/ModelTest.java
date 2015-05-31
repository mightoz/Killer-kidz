import model.Model;
import model.entity.Entity;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class ModelTest {

    @Test
    public void testMovePlayer(){
        Model model = new Model("Pelle", "Kalle", 600, 900);
        boolean dir[] = {false, true, false, false};
        float initialY1;
        float initialY2;
        for(int i = 0; i < model.getEntities().size(); i++){
            initialY1 = model.getEntities().get(i).getY();
        }
        model.movePlayer(1, dir);
        model.updateGame(1.0);
        float newY1;

    }

    @org.junit.Test
    public void testChangeCandy() throws Exception {

    }

    @org.junit.Test
    public void testThrowCandy() throws Exception {

    }

    @org.junit.Test
    public void testGetCurrentLevelNumber() throws Exception {

    }

    @org.junit.Test
    public void testGetLevel() throws Exception {

    }

    @org.junit.Test
    public void testStartLevel() throws Exception {

    }

    @org.junit.Test
    public void testUpdateGame() throws Exception {

    }

    @org.junit.Test
    public void testLevelCompleted() throws Exception {

    }

    @org.junit.Test
    public void testGetWidth() throws Exception {

    }

    @org.junit.Test
    public void testGetHeight() throws Exception {

    }

    @org.junit.Test
    public void testGetEntities() throws Exception {

    }

    @org.junit.Test
    public void testGetCandyShop() throws Exception {

    }

    @org.junit.Test
    public void testMoveMarkerInStore() throws Exception {

    }

    @org.junit.Test
    public void testChoose() throws Exception {

    }

    @org.junit.Test
    public void testGetStatusInShop() throws Exception {

    }

    @org.junit.Test
    public void testGetMoney() throws Exception {

    }
}