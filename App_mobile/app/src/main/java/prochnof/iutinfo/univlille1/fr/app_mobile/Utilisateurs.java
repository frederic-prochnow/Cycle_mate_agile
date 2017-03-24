package prochnof.iutinfo.univlille1.fr.app_mobile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by brehonu on 23/03/17.
 */

public class Utilisateurs {

    private User[] users;

    public Utilisateurs(){


    }

    private User[] getInformation(){
        /*NodeList listN = doc.getElementsByTagName("user");
        User[] tmp = new User[listN.getLength()];
        int bpm = 0;
        int souffle = 0;
        String nom = "Michel";
        Node node;
        for(int i = 0; i < users.length; i++){
            node = listN.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element elem = (Element) node;
                NodeList infoList = elem.getElementsByTagName("info");
                for (int count = 0; count < infoList.getLength(); count++) {
                    Node node1 = infoList.item(count);

                    if (node1.getNodeType() == node1.ELEMENT_NODE) {
                        Element info = (Element) node1;
                        switch(info.getAttribute("type")){
                            case "id": bpm = Integer.parseInt(info.getTextContent());
                            case "name": nom = info.getTextContent();
                            case "souffle": souffle = count;
                        }
                    }
                }
                tmp[i] = new User(nom, bpm, souffle);
            }
        }
        return tmp;*/
        return null;
    }

    public User[] getUsers(){
        return users;
    }
}
