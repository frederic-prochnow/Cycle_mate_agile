package prochnof.iutinfo.univlille1.fr.app_mobile;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String[]> chat = new ArrayList<String[]>();
    final ArrayList<String> lead = new ArrayList<String>();
    CustomAdapter adapterLead;
    ChatAdapter adapterChat;
    VideoView video;
    EditText et;
    ListView listChat;
    String nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] tmp2 = {"Dylan","Lucas","Hugo","Ulysse","Vincent","Adrien","Margot","Kevin","Alexandre","Quentin","Cyril","Rodolphe"};
        for(String s :tmp2){
            lead.add(s);
        }
        nom = "Vincent";

        final ClientREST cr = new ClientREST(getApplicationContext());

        adapterLead = new CustomAdapter(this,lead,myNumber(lead,nom));
        final ListView listLead = (ListView)findViewById(R.id.leaderboard);
        listLead.setAdapter(adapterLead);

        Utilisateurs users = new Utilisateurs(cr, new RestClassBack<List<User>>() {
            @Override
            public void onSuccess(List<User> result) {
                for(User u : result){
                    u.updateVitesse();
                }
                int taille = result.size();
                for (int i = 0; i < taille; i++) {
                    int max = 0;
                    for (int j = 0; j < result.size(); j++) {
                        if (result.get(j).getPerformance().vitesse > result.get(max).getPerformance().vitesse) {
                            max = j;
                        }
                    }
                    lead.add(result.get(max).getName());
                    result.remove(max);
                }

                adapterLead.notifyDataSetChanged();
            }
        });

        Chat c = new Chat(cr,getApplicationContext());
        c.getMessages();
        //for(int i=0;i<c.chat.size();i++){
        System.out.print("La taille du tableau est : "+c.chat.size());
        //    System.out.println("Les elements du tableau sont : "+c.chat.get(i).toString());
        //}
        for(Message sms : c.chat){
            chat.add(new String[]{sms.name,sms.message});
            System.out.println("SMS nom : "+sms.name+ sms.message);
        }



        adapterChat = new ChatAdapter(this,chat,nom);
        listChat = (ListView)findViewById(R.id.chat);

        et = (EditText) findViewById(R.id.reponse);
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    String rep = et.getText().toString();
                    chat.add(new String[]{nom,rep});
                    adapterChat.notifyDataSetChanged();
                    et.setText("");
                    et.clearFocus();
                    InputMethodManager input = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    input.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
                    listChat.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
                    listChat.setStackFromBottom(true);
                }
                return false;
            }
        });
        listChat.setAdapter(adapterChat);
        video = (VideoView) findViewById(R.id.videoView2);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(video);
        mc.setMediaPlayer(video);
        String path = "android.resource://prochnof.iutinfo.univlille1.fr.app_mobile/"+R.raw.fitness;
        Uri uri = Uri.parse(path);
        video.setMediaController(mc);
        video.setVideoURI(uri);
        video.start();

        ChangeSpeed(30,26,33,28);
        ChangePower(162,163,166,168);
        ChangeCalorie(22,26,20,23);
        ChangeFrequence(160,167,181,173);

        listLead.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopupWindow popup = new PopupWindow(adapterLead.lInflater.inflate(R.layout.listusersdetails,null,false),500,500,true);
                //popup.showAtLocation(findViewById(R.id.leaderboard), Gravity.TOP,645,200+position*60);
                popup.showAtLocation(findViewById(R.id.activity_main), Gravity.TOP,645,245+position*100);
            }
        });

        /*int time = 0;
        while(time < 10000) {
            if(time%10 == 0)
            setUsers(cr);
        }*/
    }
    public void doSend(View view){
        String rep = et.getText().toString();
        chat.add(new String[]{nom,rep});
        adapterChat.notifyDataSetChanged();
        et.setText("");
        et.clearFocus();
        InputMethodManager input = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        listChat.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
        listChat.setStackFromBottom(true);
    }

    public int myNumber(ArrayList<String> s,String nom){
        System.out.println("Nom : "+nom+" Trouvé en : "+s.size()+" -------------------------------------------------------------------------------------");
        int i=0;
        for(String s4 : s){
            System.out.println("Nom : "+nom+" Trouvé en : "+s4+" -------------------------------------------------------------------------------------");
            if(s4.equals(nom)){
                System.out.println("Nom : "+nom+" Trouvé en : "+i+" -------------------------------------------------------------------------------------");
                return i;
            }
            i++;
        }
        return -1;
    }

    public  void ChangeSpeed(int vitesseI, int vitesseMoy, int groupeI, int groupeMoy){
        TextView tv1 = (TextView) findViewById(R.id.vitesseinstant);
        TextView tv2 = (TextView) findViewById(R.id.vitessemoyenne);
        TextView tv3 = (TextView) findViewById(R.id.vitesseinstantgroupe);
        TextView tv4 = (TextView) findViewById(R.id.vitessemoyennegroupe);

        tv1.setText(""+vitesseI);
        tv2.setText(""+vitesseMoy);
        tv3.setText(""+groupeI);
        tv4.setText(""+groupeMoy);
    }
    public  void ChangePower(int powerI, int powerMoy, int groupeI, int groupeMoy){
        TextView tv1 = (TextView) findViewById(R.id.puissanceinstant);
        TextView tv2 = (TextView) findViewById(R.id.puissancemoyenne);
        TextView tv3 = (TextView) findViewById(R.id.puissanceinstantgroupe);
        TextView tv4 = (TextView) findViewById(R.id.puissancemoyennegroupe);

        tv1.setText(""+powerI);
        tv2.setText(""+powerMoy);
        tv3.setText(""+groupeI);
        tv4.setText(""+groupeMoy);
    }
    public  void ChangeCalorie(int calorieI, int calorieMoy, int groupeI, int groupeMoy){
        TextView tv1 = (TextView) findViewById(R.id.calorieinstant);
        TextView tv2 = (TextView) findViewById(R.id.caloriemoyenne);
        TextView tv3 = (TextView) findViewById(R.id.calorieinstantgroupe);
        TextView tv4 = (TextView) findViewById(R.id.caloriemoyennegroupe);

        tv1.setText(""+calorieI);
        tv2.setText(""+calorieMoy);
        tv3.setText(""+groupeI);
        tv4.setText(""+groupeMoy);
    }
    public  void ChangeFrequence(int frequenceI, int frequenceMoy, int groupeI, int groupeMoy){
        TextView tv1 = (TextView) findViewById(R.id.frequenceinstant);
        TextView tv2 = (TextView) findViewById(R.id.frequencemoyenne);
        TextView tv3 = (TextView) findViewById(R.id.frequenceinstantgroupe);
        TextView tv4 = (TextView) findViewById(R.id.frequencemoyennegroupe);

        tv1.setText(""+frequenceI);
        tv2.setText(""+frequenceMoy);
        tv3.setText(""+groupeI);
        tv4.setText(""+groupeMoy);
    }

    /*public void setUsers(final ClientREST cr){
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Utilisateurs users = new Utilisateurs(cr, new RestClassBack<List<User>>() {
                            @Override
                            public void onSuccess(List<User> result) {
                                for(User u : result){
                                    u.updateVitesse();
                                }
                                int taille = result.size();
                                for (int i = 0; i < taille; i++) {
                                    int max = 0;
                                    for (int j = 0; j < result.size(); j++) {
                                        if (result.get(j).getPerformance().vitesse > result.get(max).getPerformance().vitesse) {
                                            max = j;
                                        }
                                    }
                                    lead.add(result.get(max).getName());
                                    result.remove(max);
                                }

                                adapterLead.notifyDataSetChanged();
                            }
                        });
                    }
                },
                3000);
    }*/
}
