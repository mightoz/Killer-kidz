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
        nextSpawnTime = 1;
        maxKidsInStore = 8;
    }

    @Override
    protected void updateLevel(double delta) {
        timePassed += delta;

        switch(currentWave){
            case 1:
                if(spawnedKids < 15){
                    if(timePassed >= nextSpawnTime){
                        int spawnKidType = random.nextInt(99);
                        float spawnPos = generateSpawnPos(10);
                        if(spawnKidType < 80){
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), spawnPos));
                        }else{
                            activeKids.add(createKid(KidTypes.DIZZY_DORIZ, Entity.getRightBoundary(), spawnPos));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*3;
                    }
                }else if(kidsRemoved == 15){
                    changeWave();
                }
                break;
            case 2:
                if(spawnedKids < 20){
                    if(timePassed >= nextSpawnTime){
                        int spawnKidType = random.nextInt(99);
                        float spawnPos = generateSpawnPos(10);
                        if(spawnKidType < 50){
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), spawnPos));
                        }else{
                            activeKids.add(createKid(KidTypes.DIZZY_DORIZ, Entity.getRightBoundary(), spawnPos));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*3;
                    }
                }else if(kidsRemoved == 35){
                    changeWave();
                }
                break;
            case 3:
                if(spawnedKids < 20){
                    if(timePassed >= nextSpawnTime){
                        int spawnKidType = random.nextInt(99);
                        float spawnPos = generateSpawnPos(10);
                        if(spawnKidType < 40){
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), spawnPos));
                        }else{
                            activeKids.add(createKid(KidTypes.DIZZY_DORIZ, Entity.getRightBoundary(), spawnPos));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*2;
                    }
                }
                break;
        }

    }

    @Override
    protected void changeWave(){
        currentWave++;
        spawnedKids = 0;
        nextSpawnTime = timePassed + 2;
    }

    @Override
    public boolean levelDone() {
        return kidsRemoved == 55 && kidsInStore < maxKidsInStore;
    }

    @Override
    public boolean levelFailed() {
        return kidsInStore == maxKidsInStore;
    }

}
