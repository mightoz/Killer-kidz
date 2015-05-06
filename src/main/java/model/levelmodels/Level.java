package model.levelmodels;

import java.util.ArrayList;

/**
 * Created by Matilda on 2015-05-03.
 */
public abstract class Level {

    private ArrayList<Kid> kids;

    public Level(){
        kids = new ArrayList<>();
    }

    public abstract void update(int type, float x, float y);

}
