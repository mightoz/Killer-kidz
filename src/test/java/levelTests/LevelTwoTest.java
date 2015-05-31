package levelTests;

import model.levelmodels.Level;
import model.levelmodels.LevelTwo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class LevelTwoTest {

    @Test
    public void testLevelTwo(){
        Level level = new LevelTwo();
        assertTrue("Level two is never created", level != null);
    }

    @Test
    public void testLevelDone(){
        Level level = new LevelTwo();
        boolean initialStatus = level.levelDone();
        for(int i = 0; i < 55; i++){
            level.killedByCandy();
        }
        boolean status = level.levelDone();
        assertTrue("Returns wrong number", initialStatus != status);
    }

    @Test
    public void testLevelFailed(){
        Level level = new LevelTwo();
        boolean initialStatus = level.levelFailed();
        for(int i = 0; i < level.getMaxKidsInStore(); i++){
            level.enteredStore();
        }
        boolean status = level.levelFailed();
        assertTrue("Returns wrong number", initialStatus != status);
    }
}