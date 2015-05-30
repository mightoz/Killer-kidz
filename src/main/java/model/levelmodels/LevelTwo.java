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
                        if(spawnKidType < 80){
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()-10));
                        }else{
                            activeKids.add(createKid(KidTypes.SINESTER, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()-10));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*4;
                    }
                }else if(kidsRemoved == 15){
                    changeWave();
                    System.out.println(currentWave);
                }
                break;
            case 2:
                if(spawnedKids < 20){
                    if(timePassed >= nextSpawnTime){
                        int spawnKidType = random.nextInt(99);
                        if(spawnKidType < 50){
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()-10));
                        }else{
                            activeKids.add(createKid(KidTypes.SINESTER, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()-10));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*3;
                    }
                }else if(spawnedKids == 20){
                    changeWave();
                }
                break;
            case 3:
                if(spawnedKids < 20){
                    if(timePassed >= nextSpawnTime){
                        int spawnKidType = random.nextInt(99);
                        if(spawnKidType < 70){
                            activeKids.add(createKid(KidTypes.SIMPLE_SAM, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()-10));
                        }else{
                            activeKids.add(createKid(KidTypes.SINESTER, Entity.getRightBoundary(), random.nextFloat()*Entity.getUpperBoundary()-10));
                        }
                        spawnedKids++;
                        nextSpawnTime += random.nextDouble()*3;
                    }
                }
                break;
        }

    }

    @Override
    protected void changeWave(){
        currentWave++;
        spawnedKids = 0;
        nextSpawnTime = timePassed + random.nextDouble()*4;
    }

    @Override
    public boolean levelDone() {
        return kidsRemoved == 55 && kidsInStore < 8;
    }

    @Override
    public boolean levelFailed() {
        return kidsInStore == 8;
    }

}
