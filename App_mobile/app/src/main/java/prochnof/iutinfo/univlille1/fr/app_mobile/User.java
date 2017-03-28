package prochnof.iutinfo.univlille1.fr.app_mobile;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by brehonu on 23/03/17.
 */

public class User {

    @SerializedName("id")
    private int id;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("alias")
    private String alias;
    private Performance perf;

    public User(String name, int id, String email, String alias){
        this.name = name;
        this.email = email;
        this.alias = alias;
        this.id = id;
    }

    public User(){}

    public String getAlias(){return alias;}
    public String getEmail(){return email;}
    public String getName(){return this.name;}
    public int getId() {return this.id;}
    public Performance getPerformance(){return this.perf;}

    public void setAlias(String alias){ this.alias = alias; }
    public void setPerf(Performance perf){ this.perf = perf;}

    public String toString(){
        return name+", email : "+email+", alias : "+alias;
    }

}
