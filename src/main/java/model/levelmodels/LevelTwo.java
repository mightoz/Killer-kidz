package model.levelmodels;

import model.entity.Entity;
import model.entity.kids.KidTypes;

import static model.entity.kids.KidFactory.createKid;

/**
 * Created by Matilda on 2015-05-17.
 */
public class LevelTwo extends Level{

    public LevelTwo(){
        super();
        timePassed = 0;
        nextSpawnTime = 1;
    }

    @Override
    protected void updateLevel(double delta) {
        timePassed += delta;

        switch(currentWave){
            case 1:
                if(spawnedKids < 15){
                    if(timePassed >= nextSpawnTime){
                        int spawnKidType = random.nextInt(99);
                        if(spawnKidType < 20){
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()));
                        }else{
                            activeKids.add(createKid(KidTypes.SINESTER, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*4;
                    }
                }else if(kidsRemoved == 15){
                    changeWave();
                }
            case 2:
                if(spawnedKids < 20){
                    if(timePassed >= nextSpawnTime){
                        int spawnKidType = random.nextInt(99);
                        if(spawnKidType < 50){
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()));
                        }else{
                            activeKids.add(createKid(KidTypes.SINESTER, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*3;
                    }
                }else if(spawnedKids == 20){
                    changeWave();
                }

            case 3:
                if(spawnedKids < 20){
                    if(timePassed >= nextSpawnTime){
                        int spawnKidType = random.nextInt(99);
                        if(spawnKidType < 70){
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()));
                        }else{
                            activeKids.add(createKid(KidTypes.SINESTER, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*3;
                    }
                }else if(spawnedKids == 20){
                    changeWave();
                }
        }

    }

    @Override
    protected void changeWave(){
        currentWave++;
        spawnedKids = 0;
        nextSpawnTime = random.nextDouble()*4;
    }

    @Override
    public boolean levelDone() {
        return kidsRemoved == 55;
    }

    @Override
    public boolean levelFailed() {
        return kidsInStore == 10;
    }

}
