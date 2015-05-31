package levelTests;

import model.entity.kids.Kid;
import model.entity.kids.SimpleSam;
import model.levelmodels.Level;
import model.levelmodels.LevelOne;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-28.
 */
public class LevelTest {

    @Test
    public void testUpdate(){
        //Ska testa om kidsen flyttar på sigoch om kidsen läggs till som dom ska,
        // helst om det byts wave efter 10 st också

        Level level = new LevelOne();

        level.getActiveKids().add(new SimpleSam(500, 300));

        int kidsInList = level.getActiveKids().size();

        for(int i = 0; i < 65; i++){
            level.update(1.0);
        }


        assertTrue("Kids are not deleted from list correctly", level.getActiveKids().size() < kidsInList);
    }

    @Test
    public void testGetKills(){
        Level level = new LevelOne();
        for( int i = 0; i < 3; i++){
            level.killedByCandy();
        }
        int kills = level.getKills();
        assertTrue("Returns wrong number", kills == 3);
    }

    @Test
    public void testGetKidsInStore(){
        Level level = new LevelOne();
        for( int i = 0; i < 3; i++){
            level.enteredStore();
        }
        int kidsInStore = level.getKidsInStore();
        assertTrue("Returns wrong number", kidsInStore == 3);
    }

}