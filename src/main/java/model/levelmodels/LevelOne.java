package model.levelmodels;

import java.util.ArrayList;

/**
 * Created by Matilda on 2015-05-03.
 */
public class LevelOne extends Level {

    public LevelOne(){
        super();
        kidsInLevel = 50;
    }

    @Override
    public void update() {
        frames++;

        //Intervallet får anpassas till resten av spelet
        if(frames > 5){
            kids.add(new Kid());
            frames = 0;
        }

        //uppdaterar positionen på alla kids
        for(Kid kid: kids){
            kid.update();
        }

    }

    @Override
    public boolean levelDone() {

        if(kidsInLevel == 0 || kidsInStore < 10 && kidsInLevel == 0){
            return true;
        }else{
            return false;
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
