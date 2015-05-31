package levelTests;

import model.levelmodels.Level;
import model.levelmodels.LevelOne;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-28.
 */
public class LevelOneTest {

    @Test
    public void testLevelOne(){
        Level level = new LevelOne();
        assertTrue("Level one is not created", level != null);
    }

    @Test
    public void testLevelDone(){
        Level level = new LevelOne();
        boolean initialStatus = level.levelDone();
        for(int i = 0; i < 25; i++){
            level.killedByCandy();
        }
        boolean status = level.levelDone();
        assertTrue("levelDone() error", status != initialStatus);
    }

    @Test
    public void testLevelFailed(){
        Level level = new LevelOne();
        boolean initialStatus = level.levelFailed();
        for(int i = 0; i < 5; i++){
            level.enteredStore();
        }
        boolean status = level.levelFailed();
        assertTrue("levelFailed() error", status != initialStatus);
    }
}