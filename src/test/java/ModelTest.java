import model.Model;
import model.entity.Entity;
import model.entity.players.Player;
import model.levelmodels.Level;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class ModelTest {

    @Test
    public void testGetCurrentLevelNumber(){
        Model model = new Model("Pelle", 600, 900);
        int level = model.getCurrentLevelNumber();
        assertTrue("getCurrentLevelNumber() returns wrong value", level == 1);
    }

    @Test
    public void testGetLevel(){
        Model model = new Model("Pelle", 600, 900);
        Level level = model.getLevel();
        assertTrue("getLevel() does not return level", level != null);
    }

    @Test
    public void testGetEntities(){
        Model model = new Model("Pelle", 600, 900);
        ArrayList<Entity> entities = model.getEntities();
        assertTrue("getEntities() does not return the list", entities != null);
    }
}