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

    Random random;

    public LevelOne(){
        super();
        kidsInLevel = 50;
        random = new Random();
    }

    @Override
    public void update(double delta) {
  //      System.out.println("Updating level");

        updates++;

        //Intervallet får anpassas till resten av spelet
        if(updates >= 80){
            Model.kids.add(KidFactory.createKid(KidTypes.SIMPLE_SAM, Model.width, random.nextInt((int)Model.height)));
            updates = 0;
        }

        //uppdaterar positionen på alla kids
//        for(Entity kid: kids){
//            if(!kid.isExpired()){
//                kid.update(delta);
//            }else{
//                kids.remove(kid);
//            }
//
//        }

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
