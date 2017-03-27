package prochnof.iutinfo.univlille1.fr.app_mobile;

import java.util.ArrayList;

/**
 * Created by brehonu on 23/03/17.
 */

public class User {

    private int id;
    private String email;
    private String name;
    private String alias;

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

    public void setBpm(String alias){ this.alias = alias; }

    public String toString(){
        return name+", email : "+email+", alias : "+alias;
    }
}
