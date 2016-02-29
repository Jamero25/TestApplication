package com.example.usuario.testapplication.process;

import android.content.Context;
import android.widget.Toast;

import com.example.usuario.testapplication.R;
import com.example.usuario.testapplication.data.Items;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Usuario on 27/02/2016.
 */
public class ReadLocalJSON {

    private String json = "";
    private ArrayList<Items> itemses = new ArrayList<>();
    private BufferedReader bufferedReader;
    private StringBuilder builder;

    public ArrayList<Items> getItemses(Context c, int indicator) {
        try {
            builder = new StringBuilder();
            if (indicator == 0) {
                bufferedReader = new BufferedReader(new InputStreamReader(c.getAssets().open("jsons/planets.json")));
            } else if (indicator == 1) {
                bufferedReader = new BufferedReader(new InputStreamReader(c.getAssets().open("principales.json")));
            }
            String line = "";
            itemses.clear();
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            bufferedReader.close();
            json = builder.toString();
            JSONArray jsonArray = new JSONArray(json);
            for (int index = 0; index < jsonArray.length(); index++) {
                Items items = new Items();
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                items.setId(jsonObject.getInt("id"));
                items.setUrlImagen(jsonObject.getString("description"));
                items.setName(jsonObject.getString("name"));
                itemses.add(items);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(c, c.getString(R.string.error_json), Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(c, c.getString(R.string.error_json), Toast.LENGTH_SHORT).show();
        }

        return itemses;
    }
}
