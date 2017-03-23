package prochnof.iutinfo.univlille1.fr.app_mobile;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> chat = new ArrayList<String>();
    ArrayList<String> lead = new ArrayList<String>();
    CustomAdapter adapterLead;
    ArrayAdapter<String> adapterChat;
    VideoView video;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> tmp = new ArrayList<String>();
        String[] tmp2 = {"Dylan","Lucas","Hugo","Ulysse","Vincent","Adrien","Margot","Kevin","Alexandre","Quentin","Cyril","Rodolphe"};
        for(String s :tmp2){
            tmp.add(s);
        }
        String nom = "Vincent";

        chat.add("Yo tout le monde c'est Squishy !");
        chat.add("Hey salut, ça va ?");
        chat.add("Ouais tranquil et toi ? mdr");
        chat.add("Bien frere !");
        lead = top10(tmp,nom,true);
        tmp = top10(tmp,nom,false);
        adapterLead = new CustomAdapter(this,tmp,myNumber(lead,nom));
        ListView listLead = (ListView)findViewById(R.id.leaderboard);


        listLead.setAdapter(adapterLead);

        adapterChat = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,chat);
        ListView listChat = (ListView)findViewById(R.id.chat);

        et = (EditText) findViewById(R.id.reponse);
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    String rep = et.getText().toString();
                    chat.add(rep);
                    adapterChat.notifyDataSetChanged();
                    et.setText("");
                    et.clearFocus();
                }
                return false;
            }
        });
        listChat.setAdapter(adapterChat);
        video = (VideoView) findViewById(R.id.videoView2);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(video);
        mc.setMediaPlayer(video);
        String path = "android.resource://prochnof.iutinfo.univlille1.fr.app_mobile/"+R.raw.makeup;
        Uri uri = Uri.parse(path);
        video.setMediaController(mc);
        video.setVideoURI(uri);
        video.start();

    }

    public void doSend(View view){

    }
    public ArrayList<String> top10(ArrayList<String> s,String nom,boolean b){
        ArrayList<String> res = new ArrayList<String>();
        for(int i=0;i<10;i++){
            if(!b) {
                res.add("N°" + (i + 1) + " : " + s.get(i));
            }else{
                res.add(s.get(i));
            }
        }
        if(myNumber(s,nom)>10){
            res.set(myNumber(s,nom),nom);
        }
        return res;
    }

    public int myNumber(ArrayList<String> s,String nom){
        for(int i=0;i<s.size();i++){
            System.out.println(" sgeti : -"+s.get(i)+"- nom: -"+nom+"-");
            if(egal(s.get(i),nom)){
                return i;
            }
        }
        return -1;
    }

    public boolean egal(String s1,String s2){
        if(s1.length() != s2.length()){
            System.out.println("Raté taille");
            return false;
        }
        for(int i =0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                System.out.println("Raté nom");
                return false;
            }
        }
        return true;
    }
}
