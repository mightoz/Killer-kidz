package model.levelmodels;

import model.Entity;
import model.Model;
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
            kids.add(KidFactory.createKid(KidTypes.SIMPLE_SAM, Model.width, random.nextInt((int)Model.height)));
            updates = 0;
        }

        //uppdaterar positionen på alla kids
        for(Entity kid: kids){
            if(!kid.isExpired()){
                kid.update(delta);
            }else{
                kids.remove(kid);
            }

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
