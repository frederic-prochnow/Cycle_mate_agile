package prochnof.iutinfo.univlille1.fr.app_mobile;

import java.util.Date;

/**
 * Created by brehonu on 27/03/17.
 */

public class Message {
    String name;
    String message;
    int id;
    Date date;

    public Message(String message, String name){
        this.name = name;
        this.message = message;
    }

    public Message(String message, String name, int id, Date date){
        this(message, name);
        this.id = id;
        this.date = date;
    }
}
