package prochnof.iutinfo.univlille1.fr.app_mobile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brehonu on 23/03/17.
 */

public class Utilisateurs {

    private List<User> users = new ArrayList<>();

    public Utilisateurs(ClientREST client, RestClassBack callback){
        getUsersFromRest(client, callback);
    }

    private void getUsersFromRest(final ClientREST client, RestClassBack callback){
        client.GetListUser(callback);
    }

    private void getPerfFromRest(ClientREST client, RestClassBack callback){
        client.getPerformances(callback);
    }

    public List<User> getUsers(){
        return users;
    }
}
