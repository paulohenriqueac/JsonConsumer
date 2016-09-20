package br.com.phac.jsonconsumer.service;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.phac.jsonconsumer.R;
import br.com.phac.jsonconsumer.domain.Data;

public class DataService {
    public static List<Data> getCarros(Context context) throws IOException, JSONException {

        List<Data> dataList = new ArrayList<Data>();

        JSONArray jsonArray = getJSONObject(context).getJSONArray("data");

        for (int i = 0; i < jsonArray.length(); i++) {
            Data d = new Data();

            JSONObject jo = jsonArray.getJSONObject(i);

            d.setId(jo.getString("id"));
            d.setName(jo.getString("name"));
            d.setPwd(jo.getString("pwd"));

            dataList.add(d);
        }

        return dataList;
    }
    private static JSONObject getJSONObject(Context context)  throws IOException, JSONException {
        Resources resources = context.getResources();
        InputStream is = resources.openRawResource(R.raw.data);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is,  "utf-8"));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }

        String result = sb.toString();
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(result);
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }

        return jsonObject;
    }
}

