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

        Level level = new LevelOne();

        level.getActiveKids().add(new SimpleSam(500, 300));

        int kidsInList = level.getActiveKids().size();

        for(int i = 0; i < 65; i++){
            level.update(10.0);
        }

        assertTrue("Kids tas inte bort ur listan", level.getActiveKids().size() < kidsInList);
    }
}