package levelTests;

import model.levelmodels.Level;
import model.levelmodels.LevelThree;
import model.levelmodels.LevelTwo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-31.
 */
public class LevelThreeTest {

    @Test
    public void testLevelThree(){
        Level level = new LevelThree();
        assertTrue("Level three is never created", level != null);
    }

    @Test
    public void testLevelDone(){
        Level level = new LevelThree();
        boolean initialStatus = level.levelDone();
        for(int i = 0; i < 50; i++){
            level.killedByCandy();
        }
        boolean status = level.levelDone();
        assertTrue("Returns wrong number", initialStatus != status);
    }

    @Test
    public void testLevelFailed(){
        Level level = new LevelThree();
        boolean initialStatus = level.levelFailed();
        for(int i = 0; i < 10; i++){
            level.enteredStore();
        }
        boolean status = level.levelFailed();
        assertTrue("Returns wrong number", initialStatus != status);
    }
}