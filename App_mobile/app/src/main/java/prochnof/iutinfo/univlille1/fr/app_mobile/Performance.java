package prochnof.iutinfo.univlille1.fr.app_mobile;

import com.google.gson.annotations.SerializedName;

/**
 * Created by brehonu on 27/03/17.
 */

public class Performance {

    @SerializedName("id")
    int id;
    @SerializedName("periode")
    int periode;
    @SerializedName("puissance")
    int puissance;
    @SerializedName("calories")
    int calories;
    @SerializedName("vitesse")
    int vitesse;
    @SerializedName("freqcard")
    int freqcard;

    public Performance(int id, int periode, int puissance, int calories, int vitesse, int freqcard){
        this.id = id;
        this.calories = calories;
        this.freqcard = freqcard;
        this.periode = periode;
        this.vitesse = vitesse;
        this.puissance = puissance;
    }
}
