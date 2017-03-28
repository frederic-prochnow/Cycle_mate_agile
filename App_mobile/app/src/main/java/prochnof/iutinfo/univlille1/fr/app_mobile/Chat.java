package prochnof.iutinfo.univlille1.fr.app_mobile;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brehonu on 27/03/17.
 */

public class Chat {

    ArrayList<Message> chat = new ArrayList<>();;
    ClientREST client;
    Context context;
    Message[] tmp;

    public Chat(ClientREST client, Context context) {
        chat.add(new Message("Systeme :", "Bienvenue sur CycleMate"));
        tmp = new Message[0];

        this.client = client;
        this.context = context;
    }

    public void sendMessage(Message mes) {
        final boolean resultat[] = new boolean[1];
        client.sendMessage(mes, new RestClassBack<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                resultat[0] = result;
            }
        });
        if (!resultat[0]) {
            Toast.makeText(context, "A error has occured : can't send your message", Toast.LENGTH_SHORT);
        }
    }

    public void putMessages(int idxFinal) {
        //final List<Message[]> tmp = new ArrayList<>();
        int idxDepart = chat.get(chat.size()-1).id+1;
            for(int i = idxDepart; i < idxFinal; i++) {
                client.getMessage(i, new RestClassBack<Message>() {
                    @Override
                    public void onSuccess(Message result) {

                     //TODO
                }
            });
        }
    }

    public void getMessages(){
        client.getMaxMessage(new RestClassBack<List<Message>>() {
            @Override
            public void onSuccess(List<Message> result) {

                System.out
                        .println("MESSAGES : "+ result.size());
                for(Message sms : result) {
                    System.out.println("LE MESSAGE EST : "+sms);
                    chat.add(sms);
                }
                System.out.println("MESSAGES chat : "+ chat.size());
            }
        });
    }


}

