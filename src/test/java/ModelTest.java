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
    public void testMovePlayer(){
        Model model = new Model("Pelle", "Kalle", 600, 900);
        boolean dir[] = {false, true, false, false};
        float initialY1 = 0;
        float initialY2 = 0;
        for(int i = 0; i < model.getEntities().size(); i++){
            if(i == 0) {
                initialY1 = model.getEntities().get(i).getY();
            }else if(i == 1){
                initialY2 = model.getEntities().get(i).getY();
            }
        }
        model.movePlayer(1, dir);
        model.updateGame(1.0);
        float newY1 = 0;
        float newY2 = 0;
        for(int i = 0; i < model.getEntities().size(); i++){
            if(i == 0) {
                newY1 = model.getEntities().get(i).getY();
            }else if(i == 1){
                newY2 = model.getEntities().get(i).getY();
            }
        }
        assertTrue("movePlayer() does not update the right player", initialY1 < newY1 && initialY2 == newY2);
    }

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
    public void testGetWidth(){
        Model model = new Model("Pelle", 600, 900);
        float width = model.getWidth();
        assertTrue("getWidth() returns wrong value", width == 600);
    }

    @Test
    public void testGetHeight(){
        Model model = new Model("Pelle", 600, 900);
        float height = model.getHeight();
        assertTrue("getWidth() returns wrong value", height == 900);
    }

    @Test
    public void testGetEntities(){
        Model model = new Model("Pelle", 600, 900);
        ArrayList<Entity> entities = model.getEntities();
        assertTrue("getEntities() does not return the list", entities != null);
    }
}