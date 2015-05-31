package levelTests;

import model.entity.Entity;
import model.entity.kids.Kid;
import model.entity.kids.SimpleSam;
import model.levelmodels.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Matilda on 2015-05-28.
 */
public class LevelTest {

    @Test
    public void testUpdate(){
        // Lägg helst till att kolla om det byts wave efter 10 st

        //Testing protected update method in LevelOne simultaneously
        Level levelOne = new LevelOne();
        int kidsInListOne = levelOne.getActiveKids().size();

        for(int i = 0; i < 20; i++){
            levelOne.update(10.0);
        }

        Kid kid = levelOne.getActiveKids().get(0);

        assertTrue("Kid does not move", kid.getX() < Entity.getRightBoundary());
        assertTrue("Kids are not deleted from list correctly", levelOne.getActiveKids().size() > kidsInListOne);

        //Test for protected method generateSpawnPos()
        float spawnPos = kid.getY();
        assertTrue("Spawn position is out of bounds", spawnPos > Entity.getLowerBoundary() && spawnPos < Entity.getUpperBoundary());

        //Test if Kids are removed when expired
        int initialListSize = levelOne.getActiveKids().size();
        for(int i = 0; i < 45; i++){
            levelOne.update(10.0);
        }
        int listSize = levelOne.getActiveKids().size();

        assertTrue("Kids are not removed correctly", listSize < initialListSize);


        //Testing protected update method in LevelTwo simultaneously
        Level levelTwo= new LevelTwo();
        int kidsInListTwo = levelOne.getActiveKids().size();

        for(int i = 0; i < 20; i++){
            levelTwo.update(1.0);
        }

        Kid kidTwo = levelTwo.getActiveKids().get(0);

        assertTrue("Kid does not move", kidTwo.getX() < Entity.getRightBoundary());
        assertTrue("Kids are not deleted from list correctly", levelTwo.getActiveKids().size() > kidsInListTwo);

        //Testing protected update method in LevelThree simultaneously
        Level levelThree= new LevelThree();
        int kidsInListThree = levelThree.getActiveKids().size();

        for(int i = 0; i < 20; i++){
            levelThree.update(1.0);
        }

        Kid kidThree = levelThree.getActiveKids().get(0);

        assertTrue("Kid does not move", kidThree.getX() < Entity.getRightBoundary());
        assertTrue("Kids are not deleted from list correctly", levelThree.getActiveKids().size() > kidsInListThree);


        //Testing protected update method in LevelFour simultaneously
        Level levelFour = new LevelFour();
        int kidsInListFour = levelFour.getActiveKids().size();

        for(int i = 0; i < 20; i++){
            levelFour.update(1.0);
        }

        Kid kidFour = levelFour.getActiveKids().get(0);

        assertTrue("Kid does not move", kidFour.getX() < Entity.getRightBoundary());
        assertTrue("Kids are not deleted from list correctly", levelFour.getActiveKids().size() > kidsInListFour);

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