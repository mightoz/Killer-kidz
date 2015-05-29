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
    public void testUpdateLevel(){

//        //Ska kolla om kids läggs till, och kanske om man byter wave
//        Level level = new LevelOne();
//        int initialKids = level.getActiveKids().size();
//
//        for(int i = 0; i < 10; i++) {
//            level.updateLevel(1.0);
//        }
//
//        assertTrue("Kids are not added in list correctly", initialKids < level.getActiveKids().size());

    }


    @Test
    public void testLevelDone(){
        Level level = new LevelOne();
        int counter = 0;

        boolean initialStatus = level.levelDone();

        for(int i = 0; i < 20; i++){
            if(counter < 18){
                level.enteredStore();
            }else{
                level.killedByCandy();
            }
            counter++;
        }

        boolean status = level.levelDone();

        assertTrue("levelDone() error", status != initialStatus);

    }

    @Test
    public void testLevelFailed(){
        Level level = new LevelOne();

        for(int i = 0; i < 5; i++){
            level.enteredStore();
        }

        boolean status = level.levelFailed();

        assertTrue("levelFailed() error", status == true);

    }
}