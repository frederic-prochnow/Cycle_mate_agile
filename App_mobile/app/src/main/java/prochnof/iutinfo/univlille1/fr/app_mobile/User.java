package prochnof.iutinfo.univlille1.fr.app_mobile;

import java.util.ArrayList;

/**
 * Created by brehonu on 23/03/17.
 */

public class User {

    private int bpm;
    private int souffle;
    private String name;

    public User(String name, int bpm, int souffle){
        this.bpm = bpm;
        this.souffle = souffle;
        this.name = name;
    }

    public int getBpm(){return bpm;}
    public int getSouffle(){return souffle;}

    public void setBpm(int bpm){ this.bpm = bpm; }
    public void setSouffle(int souffle){this.souffle = souffle;}

    public String toString(){
        return name+", bpm : "+bpm+", souffle : "+souffle;
    }
}
