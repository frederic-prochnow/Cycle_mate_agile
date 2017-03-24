package prochnof.iutinfo.univlille1.fr.app_mobile;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by slowinsd on 22/03/17.
 */

public class ChatAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<String[]> data;
    String nom;

    ChatAdapter(Context context,ArrayList<String[]> data,String nom) {
        ctx = context;
        this.data = data;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.nom = nom;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = lInflater.inflate(R.layout.listtest, parent, false);
        }

        if (this.nom.equals(data.get(position)[0])) {
            ((TextView) view.findViewById(R.id.droite)).setPadding(20,0,20,0);
            ((TextView) view.findViewById(R.id.droite)).setText(data.get(position)[1]);
            ((TextView) view.findViewById(R.id.gauche)).setText("");
            ((TextView)view.findViewById(R.id.droite)).setTextSize(30);
            ((TextView) view.findViewById(R.id.droite)).setTextColor(Color.parseColor("#2ca0c4"));

        }else{
            ((TextView) view.findViewById(R.id.gauche)).setPadding(20,0,20,0);
            ((TextView) view.findViewById(R.id.gauche)).setText(data.get(position)[0]+" : "+data.get(position)[1]);
            ((TextView) view.findViewById(R.id.droite)).setText("");
            ((TextView) view.findViewById(R.id.gauche)).setTextSize(30);
            ((TextView) view.findViewById(R.id.gauche)).setTextColor(Color.parseColor("#b8b8b8"));
        }
        return view;
    }
}