package model.levelmodels;

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
    public void update(double delta) {
        timePassed += delta;


    }

    @Override
    public boolean levelDone() {
        return false;
    }

    @Override
    public boolean levelFailed() {

        return false;
    }

}
