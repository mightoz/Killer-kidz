package model.levelmodels;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-28.
 */
public class LevelTest {

    public void testKidRemoved(){
        Level level = new levelOne();
        beforeKidsRemoved = level.kidsRemoved;

        level.kidRemoved();

        assertTrue("Field kidRemoved is increased", level.kidsRemoved > beforeKidsRemoved);
        
    }

    @org.junit.Test
    public void testEnteredStore() throws Exception {

    }

    @org.junit.Test
    public void testKilledByCandy() throws Exception {

    }

    public void testUpdate() throws Exception {
        Level level = new LevelOne();
        ArrayList<Kid> tempKids = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            tempKids.add(new SimpleSam(500, 300));
        }

        int kidsInList = tempKids.size();
        int kidCount = kidsInList;

        for(Kid kid: tempKids){
            kidCount--;
            if(kidsInList = 1) {
                kid.expired = true;
            }
        }

        level.update();

        assertTrue("Kids tas bort urlistan", tempKids.size() < kidsInList);
    }
}