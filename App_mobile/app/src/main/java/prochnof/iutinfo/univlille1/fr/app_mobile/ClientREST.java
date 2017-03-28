package prochnof.iutinfo.univlille1.fr.app_mobile;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.icu.lang.UScript;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brehonu on 23/03/17.
 */

public class ClientREST{

    private String url;
    private RequestQueue queue;

    public ClientREST(Context context){
        System.setProperty("http.proxyHost", "cache.univ-lille1.fr");
        System.setProperty("http.proxyPort", "3128");

        this.url = "http://172.18.49.157:8080/v1/";
        this.queue = Volley.newRequestQueue(context);
    }

    public void GetListUser(final RestClassBack<List<User>> callBack) {
        String url = this.url + "user/";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        // Instancie une superbe liste d'user
                        List<User> users = new Gson().fromJson(response, new TypeToken<List<User>>(){}.getType());

                        callBack.onSuccess(users);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Ca marche pas : GET USER LIST");
                System.out.println(error.getMessage());
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void getUser(int nb, final RestClassBack<User> callBack){
        String url = this.url + nb +"/";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        callBack.onSuccess( new Gson().fromJson(response, User.class) );
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Ca marche pas : GET USER");
                System.out.println(error.getMessage());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void setUser(int id, final String name, final RestClassBack<Boolean> callBack){
        String url = this.url + "/user/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Ca marche pas : POST USER");
                System.out.println(error.getMessage());
                callBack.onSuccess(false);
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);

                return params;
            }
        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void sendMessage(final Message mes, final RestClassBack<Boolean> callBack){
        String url = this.url + "chat/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Ca marche pas : POST message");
                System.out.println(error.getMessage());
                callBack.onSuccess(false);
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("message", mes.message);
                params.put("name", mes.name);

                return params;
            }
        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void getMessage(int id, final RestClassBack<Message> callBack){
        String url = this.url + "chat/"+ id+ "/";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        System.out.println("CLIENT REST");
                        callBack.onSuccess( new Gson().fromJson(response, Message.class ));
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Ca marche pas : GET message");
                System.out.println(error.getMessage());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void getPerformances(final RestClassBack<List<Performance>> callBack){
        String url = this.url +"performance/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        List<Performance> performances = new Gson().fromJson(response, new TypeToken<List<Performance>>(){}.getType());
                        callBack.onSuccess(performances );
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Ca marche pas : GET performances");
                System.out.println(error.getMessage());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


    public void getMaxMessage(final RestClassBack<List<Message>> callBack){
        String url = this.url +"chat/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        List<Message> messages = new Gson().fromJson(response, new TypeToken<List<Message>>(){}.getType());
                        callBack.onSuccess( messages );
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Ca marche pas : GET performances");
                System.out.println(error.getMessage());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}


