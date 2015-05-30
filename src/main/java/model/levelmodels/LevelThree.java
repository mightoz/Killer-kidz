package model.levelmodels;

import model.entity.Entity;
import model.entity.kids.KidTypes;

import static model.entity.kids.KidFactory.createKid;

/**
 * Created by Matilda on 2015-05-27.
 */
public class LevelThree extends Level {

    public LevelThree(){
        super();
        nextSpawnTime = 3;
        maxKidsInStore = 10;
    }

    @Override
    protected void updateLevel(double delta) {
        timePassed += delta;
        switch (currentWave){
            case 1:
                if(spawnedKids < 15){
                    if(timePassed >= nextSpawnTime) {
                        int spawnKidType = random.nextInt(99);
                        if (spawnKidType < 45) {
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat() * Entity.getUpperBoundary()));
                        } else if (spawnKidType < 90) {
                            activeKids.add(createKid(KidTypes.DIZZY_DORIZ, Entity.getRightBoundary(), random.nextFloat() * Entity.getUpperBoundary()));
                        } else {
                            activeKids.add(createKid(KidTypes.SINESTER, Entity.getRightBoundary(), random.nextFloat() * Entity.getUpperBoundary()));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble() * 3;
                    }
                }else{
                    changeWave();
                }
                break;
            case 2:
                if(spawnedKids < 20){
                    if(timePassed >= nextSpawnTime) {
                        int spawnKidType = random.nextInt(99);
                        if (spawnKidType < 30) {
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat() * Entity.getUpperBoundary()));
                        } else if (spawnKidType < 50) {
                            activeKids.add(createKid(KidTypes.SINESTER, Entity.getRightBoundary(), random.nextFloat() * Entity.getUpperBoundary()));
                        } else {
                            activeKids.add(createKid(KidTypes.DIZZY_DORIZ, Entity.getRightBoundary(), random.nextFloat() * Entity.getUpperBoundary()));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble() * 5;
                    }
                }else{
                    changeWave();
                }
                break;
            case 3:
                if(spawnedKids < 15){
                    if(timePassed >= nextSpawnTime) {
                        int spawnKidType = random.nextInt(99);
                        if (spawnKidType < 30) {
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat() * Entity.getUpperBoundary()));
                        } else if (spawnKidType < 60) {
                            activeKids.add(createKid(KidTypes.SINESTER, Entity.getRightBoundary(), random.nextFloat() * Entity.getUpperBoundary()));
                        } else {
                            activeKids.add(createKid(KidTypes.DIZZY_DORIZ, Entity.getRightBoundary(), random.nextFloat() * Entity.getUpperBoundary()));
                        }
                    }
                }
                spawnedKids++;
                nextSpawnTime += random.nextDouble()*4;
                break;
        }
    }

    @Override
    protected void changeWave() {
        currentWave++;
        spawnedKids = 0;
        nextSpawnTime = timePassed + 2;
    }

    @Override
    public boolean levelDone() {
        return kidsRemoved == 50 && kidsInStore < 10;
    }

    @Override
    public boolean levelFailed() {
        return kidsInStore == 10;
    }
}
