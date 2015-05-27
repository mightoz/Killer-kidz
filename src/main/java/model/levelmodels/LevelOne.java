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
        timePassed = 0;
        nextSpawnTime = 3;
    }

    public void updateLevel(double delta){
        timePassed+=delta;
        switch(currentWave){
            case 1:
                if(spawnedKids < 10) {
                    if(timePassed >= nextSpawnTime){
                        activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat()* Entity.getUpperBoundary()));
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*4;
                    }
                }else if(kidsRemoved == 10){
                    changeWave();
                }
                break;
            case 2:
                if(spawnedKids < 15){
                    if(timePassed >= nextSpawnTime){
                        activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat()* Entity.getUpperBoundary()));
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*4;
                    }
                }
                break;
        }

    }

    @Override
    protected void changeWave() {
        spawnedKids = 0;
        currentWave++;
        nextSpawnTime = timePassed + 4;
    }

    //
    @Override
    public boolean levelDone(){
        return kidsRemoved == 20;
    }

    @Override
    public boolean levelFailed() {
        return kidsInStore == 5;
    }

}
