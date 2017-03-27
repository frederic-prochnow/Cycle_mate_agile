package prochnof.iutinfo.univlille1.fr.app_mobile;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by slowinsd on 27/03/17.
 */

public class ChangeStats extends AppCompatActivity{
    View v;
    public  ChangeStats(View view){
        this.v = view;
    }

    /*public  void ChangeSpeed(int vitesseI, int vitesseMoy, int groupeI, int groupeMoy){
        TextView tv1 = (TextView) findViewById(R.id.frequenceinstant);
        TextView tv2 = (TextView) findViewById(R.id.frequencesmoyenne);
        TextView tv3 = (TextView) findViewById(R.id.frequencesgroupe);
        TextView tv4 = (TextView) findViewById(R.id.frequencegroupemoyenne);

        tv1.setText(vitesseI);
        tv2.setText(vitesseMoy);
        tv3.setText(groupeI);
        tv4.setText(groupeMoy);
    }*/
}
