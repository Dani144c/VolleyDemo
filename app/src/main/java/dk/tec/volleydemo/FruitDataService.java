package dk.tec.volleydemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class FruitDataService {

    public static final String FRUIT_API = "https://fruityvice.com/api/fruit";
    private Context ctx;
    private JSONArray jsonArray;

    public FruitDataService(Context ctx) {
        this.ctx = ctx;
    }

    public void getAllFruits(DataServiceListener serviceListener) {

        String url = FRUIT_API + "/all";


        // Request a string response from the provided URL.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        serviceListener.onSucces(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        serviceListener.onFailure(error.getMessage());
                    }
                }
        );

        VolleySingleton.getInstance(ctx).addToRequestQueue(jsonArrayRequest);

    }
    public void getFruit(String name, DataServiceListener serviceListener) {
        String url = FRUIT_API + "/" + name;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        Log.d("MyData", response.toString());
                        serviceListener.onSucces(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        serviceListener.onFailure(error.getMessage());
                    }
                }
        );
        VolleySingleton.getInstance(ctx).addToRequestQueue(jsonObjectRequest);
    }
}
