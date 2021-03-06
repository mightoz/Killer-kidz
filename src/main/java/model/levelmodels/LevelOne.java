package model.levelmodels;

import model.Model;
import model.entity.Entity;
import model.entity.kids.KidTypes;
import static model.entity.kids.KidFactory.createKid;

/**
 * Created by Matilda on 2015-05-03.
 */
public class LevelOne extends Level {

    public LevelOne() {
        super();
        nextSpawnTime = 3;
        maxKidsInStore = 5;
    }

    protected void updateLevel(double delta){
        timePassed+=delta;
        switch(currentWave){
            case 1:
                if(spawnedKids < 10) {
                    if(timePassed >= nextSpawnTime){
                        float spawnPos = generateSpawnPos(10);
                        activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), spawnPos));
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*2;
                    }
                }else if(kidsRemoved == 10){
                    changeWave();
                }
                break;
            case 2:
                if(spawnedKids < 15){
                    if(timePassed >= nextSpawnTime){
                        float spawnPos = generateSpawnPos(10);
                        activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), spawnPos));
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*2;
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Not an existing wave");
        }

    }

    @Override
    protected void changeWave() {
        spawnedKids = 0;
        currentWave++;
        nextSpawnTime = timePassed + 3;
    }

    @Override
    public boolean levelDone(){
        return kidsRemoved == 25 && kidsInStore < maxKidsInStore;
    }

    @Override
    public boolean levelFailed() {
        return kidsInStore >= maxKidsInStore;
    }

}
