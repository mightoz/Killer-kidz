package model.levelmodels;

import model.entity.Entity;
import model.entity.kids.KidTypes;

import static model.entity.kids.KidFactory.createKid;

/**
 * Created by Matilda on 2015-05-30.
 */
public class LevelFour extends Level {

    float nextSpawnPos;
    int spawnDir;

    public LevelFour(){
        super();
        nextSpawnTime = 2;
        nextSpawnPos = Entity.getUpperBoundary()-10;
        spawnDir= 0;
    }

    @Override
    protected void updateLevel(double delta) {
        timePassed += delta;
        switch(currentWave){
            case 1:
                if(spawnedKids < 35){
                    if(timePassed >= nextSpawnTime){
                        activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), nextSpawnPos));
                        changeSpawnPos();
                        spawnedKids++;
                        nextSpawnTime += 1;
                    }
                }else if(kidsRemoved == 35){
                    changeWave();
                }
                break;
            case 2:
                if(spawnedKids < 25){
                    if(timePassed >= nextSpawnTime){
                        int kidToSpawn = random.nextInt(99);
                        if(kidToSpawn < 80){
                            activeKids.add(createKid(KidTypes.DIZZY_DORIZ, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()-10));
                        }else{
                            activeKids.add(createKid(KidTypes.ROLLING_RASCAL, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()-30));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*3;
                    }
                }else{
                    changeWave();
                }
                break;
            case 3:
                break;
        }

    }

    private void changeSpawnPos(){
        if(nextSpawnPos <= Entity.getLowerBoundary()){
            spawnDir = 1;
        }else if(nextSpawnPos >= Entity.getUpperBoundary()){
            spawnDir = 0;
        }
        switch (spawnDir){
            case 0:
                nextSpawnPos -= 25;
                break;
            case 1:
                nextSpawnPos += 25;
                break;
        }
    }

    @Override
    protected void changeWave() {
        currentWave++;
        spawnedKids = 0;
        nextSpawnTime = timePassed + 3;
    }

    @Override
    public boolean levelDone() {
        return kidsRemoved == 35 && kidsInStore < 10;
    }

    @Override
    public boolean levelFailed() {
        return kidsInStore == 10;
    }
}
