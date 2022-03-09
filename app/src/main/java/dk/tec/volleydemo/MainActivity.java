package dk.tec.volleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Instantiate the RequestQueue.
        //        RequestQueue queue = Volley.newRequestQueue(this);

        FruitDataService dataService = new FruitDataService(MainActivity.this);

//        dataService.getAllFruits(new DataServiceListener() {
//            @Override
//            public void onSucces(JSONArray jsonArray) {
//                Log.d("MyData", jsonArray.toString());
//            }
//
//            @Override
//            public void onSucces(JSONObject jsonObject) { }
//
//            @Override
//            public void onFailure(String err) {
//                Log.d("MyData", err);
//
//            }
//        });

                dataService.getFruit("Banana", new DataServiceListener() {
                    @Override
                    public void onSucces(JSONArray jsonArray) { }

                    @Override
                    public void onSucces(JSONObject jsonObject) {
                        Log.d("MyData", jsonObject.toString());
                    }

                    @Override
                    public void onFailure(String err) {
                        Log.d("MyData", err);
                    }
                });

    }

}
