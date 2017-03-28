package prochnof.iutinfo.univlille1.fr.app_mobile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by brehonu on 23/03/17.
 */

public class Utilisateurs {

    private User[] users;

    public Utilisateurs(ClientREST client){
        getUsersFromRest(client);
    }

    private void getUsersFromRest(final ClientREST client){
        client.GetListUser( new RestClassBack<List<User>>(){
            @Override
            public void onSuccess(List<User> result) {
                users = new User[result.size()];
                for (int i = 0; i < users.length; i++){
                    users[i] = result.get(i);
                }
                getUsersFromRest(client);
            }
        });
    }

    private void getPerfFromRest(ClientREST client){
        client.getPerformances(new RestClassBack<List<Performance>>() {
            @Override
            public void onSuccess(List<Performance> result) {
                for (int i = 0; i < result.size(); i++){
                    users[i].setPerf(result.get(i));
                }
            }
        });
    }

    public User[] getUsers(){
        return users;
    }
}
