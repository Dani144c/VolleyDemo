package dk.tec.volleydemo;

import org.json.JSONArray;
import org.json.JSONObject;

public interface DataServiceListener {

    public void onSucces(JSONArray jsonArray);
    public void onSucces(JSONObject jsonObject);

    public void onFailure(String err);
}
