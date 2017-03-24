package prochnof.iutinfo.univlille1.fr.app_mobile;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by brehonu on 23/03/17.
 */

public class ClientREST{

    private Context context;
    private String url;

    public ClientREST(Context context){
        this.context = context;
        System.setProperty("http.proxyHost", "cache.univ-lille1.fr");
        System.setProperty("http.proxyPort", "3128");
        this.url = "http://172.18.49.157:8080/v1/user";
    }

    public String GetJSON(String localisation) {
        RequestQueue queue = Volley.newRequestQueue(context);
        final String[] res = new String[1];
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println("Response is: " + response.toString());
                        res[0] = response.toString();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Ca marche pas");
                System.out.println(error.getMessage());
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
        return res[0];
    }

}
