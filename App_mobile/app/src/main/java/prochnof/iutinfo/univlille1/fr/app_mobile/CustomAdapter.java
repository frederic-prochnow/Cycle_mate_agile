package prochnof.iutinfo.univlille1.fr.app_mobile;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by slowinsd on 22/03/17.
 */

public class CustomAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    List<String> data;
    int numero;

    CustomAdapter(Context context, List<String> data, int numero) {
        this.numero = numero;
        ctx = context;
        this.data = data;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            view = lInflater.inflate(R.layout.listitem, parent, false);
        }

        if (position == numero) {
            view.setBackgroundColor(Color.parseColor("#2ca0c4"));
        }else{
            view.setBackgroundColor(Color.parseColor("#b8b8b8"));
        }

        ((TextView) view.findViewById(R.id.heading)).setText(data.get(position));
        ((TextView)view.findViewById(R.id.heading)).setTextSize(50);
        ImageView imageView = (ImageView) view.findViewById(R.id.imagevue);
        String path = "android.resource://prochnof.iutinfo.univlille1.fr.app_mobile/"+R.raw.chinois;
        Uri uri = Uri.parse(path);
        imageView.setImageURI(uri);

        return view;
    }
}