package model.levelmodels;

import model.Entity;
import model.kids.KidFactory;
import model.kids.KidTypes;

import java.util.Random;

/**
 * Created by Matilda on 2015-05-03.
 */
public class LevelOne extends Level {

    public LevelOne(){
        super();
        kidsInLevel = 50;
    }

    @Override
    public void update(double delta) {
        updates++;
        Random random = new Random();

        //Intervallet får anpassas till resten av spelet
        if(updates > 5){
            kids.add(KidFactory.createKid(KidTypes.SIMPLE_SAM, 640, random.nextInt(480)));
            updates = 0;
        }

        //uppdaterar positionen på alla kids
        for(Entity kid: kids){
            kid.update(delta);
        }

    }

    @Override
    public boolean levelFailed() {
        if(kidsInStore == 10){
            return true;
        }else{
            return false;
        }
    }

}
