package prochnof.iutinfo.univlille1.fr.app_mobile;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brehonu on 27/03/17.
 */

public class Chat {

    Message[] chat;
    ClientREST client;
    Context context;

    public Chat(ClientREST client, Context context){
        chat = new Message[1];
        chat[0] = new Message("Systeme :", "Bienvenue sur CycleMate");

        this.client = client;
        this.context = context;
    }

    public void sendMessage(Message mes){
        final boolean resultat[] = new boolean[1];
        client.sendMessage(mes, new RestClassBack<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                resultat[0] = result;
            }
        });
        if(!resultat[0]){
            Toast.makeText(context, "A error has occured : can't send your message", Toast.LENGTH_SHORT);
        }
    }

    public void getMessages(){
        final List<Message[]> tmp = new ArrayList<>();
        Message[] tmp2;
        client.getMessage(new RestClassBack<Message[]>() {
            @Override
            public void onSuccess(Message[] result) {
                tmp.add(new Message[result.length]);
                for(int i = 0; i < result.length; i++){
                    tmp.get(0)[i] = result[i];
                }
            }
        });

        tmp2 = tmp.get(0);
        int diff = tmp2[tmp2.length-1].id - chat[chat.length-1].id;
        if(diff > 0){

            Message[] result = new Message[chat.length+diff];
            for(int i =0; i < chat.length; i++){
                result[i] = chat[i];
            }

            int idxResult = chat.length;
            int idx = tmp2.length - diff;
            for(int i = 0; i < diff; i++){
                result[idxResult] = tmp2[idx];
                idx++;
                idxResult++;
            }
            chat = result;
        }

    }
}
