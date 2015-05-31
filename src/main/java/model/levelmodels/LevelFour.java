package model.levelmodels;

import model.entity.Entity;
import model.entity.kids.KidTypes;
import static model.entity.kids.KidFactory.createKid;

/**
 * Created by Matilda on 2015-05-30.
 */
public class LevelFour extends Level {

    float nextSpawnPos;

    public LevelFour(){
        super();
        nextSpawnTime = 2;
        maxKidsInStore = 8;
        nextSpawnPos = Entity.getUpperBoundary()-10;
    }

    @Override
    protected void updateLevel(double delta) {
        timePassed += delta;
        switch(currentWave){
            case 1:
                if(spawnedKids < 16){
                    if(timePassed >= nextSpawnTime){
                        activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), nextSpawnPos));
                        nextSpawnPos -= 25;
                        spawnedKids++;
                        nextSpawnTime += 1;
                    }
                }else if(kidsRemoved == 16){
                    changeWave();
                }
                break;
            case 2:
                if(spawnedKids < 30){
                    if(timePassed >= nextSpawnTime){
                        int kidToSpawn = random.nextInt(99);
                        if(kidToSpawn < 80){
                            float spawnPos = generateSpawnPos(10);
                            activeKids.add(createKid(KidTypes.DIZZY_DORIZ, Entity.getRightBoundary(), spawnPos));
                        }else{
                            float spawnPos = generateSpawnPos(30);
                            activeKids.add(createKid(KidTypes.GRANDALF_THE_GREY, Entity.getRightBoundary(), spawnPos));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*3;
                    }
                }else if(kidsRemoved == 46){
                    changeWave();
                }
                break;
            case 3:
                if(spawnedKids < 16) {
                    if (timePassed >= nextSpawnTime) {
                        activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), nextSpawnPos));
                        nextSpawnPos -= 25;
                        spawnedKids++;
                        nextSpawnTime += 1;
                    }
                }
                break;
            default:
            	throw new IllegalArgumentException("Not an existing wave");
        }
    }


    @Override
    protected void changeWave() {
        currentWave++;
        spawnedKids = 0;
        nextSpawnTime = timePassed + 3;
        nextSpawnPos = Entity.getUpperBoundary()-10;
    }

    @Override
    public boolean levelDone() {
        return kidsRemoved == 62 && kidsInStore < maxKidsInStore;
    }

    @Override
    public boolean levelFailed() {
        return kidsInStore == maxKidsInStore;
    }
}
