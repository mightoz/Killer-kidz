package model.levelmodels;

import model.Model;
import model.kids.KidTypes;

/**
 * Created by Matilda on 2015-05-03.
 */
public class LevelOne extends Level {

    public LevelOne(){t
                if(spawnedKids < 10) {
                    if (timePassed >= lastSpawnTime && timePassed <= timePassed + random.nextDouble()*3) {
                        Model.spawnKid(KidTypes.SIMPLE_SAM, Model.width, random.nextInt((int) Model.height));
                        spawnedKids++;
                        lastSpawnTime = timePassed;
                    }
                }
                break;
            case 2:
                if(spawnedKids < 15){
                    if(timePassed >= lastSpawnTime && timePassed <= timePassed + random.nextDouble()*3){
                        Model.spawnKid(KidTypes.SIMPLE_SAM, Model.width, random.nextInt((int) Model.height));
                        spawnedKids++;
                        lastSpawnTime = timePassed;
                    }
                }
                break;
        }


        if(kidsRemoved == 10 && (kidsInStore + kidsKilled) == 10){
            currentWave++;
            spawnedKids = 0;
        }
    }


    @Override
    public boolean levelDone(){
        if(kidsRemoved == 20){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean levelFailed() {
        if(kidsInStore == 3){
            return true;
        }else{
            return false;
        }
    }

}
