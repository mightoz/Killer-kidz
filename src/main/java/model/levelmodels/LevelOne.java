package model.levelmodels;

import model.Model;
import model.kids.KidTypes;

import static model.kids.KidFactory.createKid;

/**
 * Created by Matilda on 2015-05-03.
 */
public class LevelOne extends Level {

    public LevelOne() {
        super();
        timePassed = 0;
        nextSpawnTime = 3;
    }

    public void updateLevel(double delta){
        timePassed+=delta;
        switch(currentWave){
            case 1:
                if(spawnedKids < 10) {
                    if(timePassed >= nextSpawnTime){
                        activeKids.add(createKid(KidTypes.SIMPLE_SAM, Model.width, random.nextInt((int) Model.height)));
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*4;
                    }
                }else if(kidsRemoved == 10){
                    spawnedKids = 0;
                    currentWave++;
                    nextSpawnTime = timePassed + 3;
                }
                break;
            case 2:
                if(spawnedKids < 15){
                    if(timePassed >= nextSpawnTime){
                        activeKids.add(createKid(KidTypes.SIMPLE_SAM, Model.width, random.nextInt((int) Model.height)));
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*4;
                    }
                }
                break;
        }

    }

//
    @Override
    public boolean levelDone(){
        if(kidsRemoved == 25){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean levelFailed() {
        if(kidsInStore == 5){
            return true;
        }else{
            return false;
        }
    }

}
