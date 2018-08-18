package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichDetailObj = new JSONObject(json);
            JSONObject nameObject = sandwichDetailObj.getJSONObject("name");

            sandwich.setMainName(nameObject.getString("mainName"));

            JSONArray alsoKnownAsArray = nameObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();
            for(int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsArray.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAsList);

            sandwich.setPlaceOfOrigin(sandwichDetailObj.getString("placeOfOrigin"));

            sandwich.setDescription(sandwichDetailObj.getString("description"));

            sandwich.setImage(sandwichDetailObj.getString("image"));

            JSONArray ingredientsArray = sandwichDetailObj.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();
            for(int i = 0; i < ingredientsArray.length(); i++) {
                ingredientsList.add(ingredientsArray.getString(i));
            }

            sandwich.setIngredients(ingredientsList);

        } catch(JSONException e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
        return sandwich;
    }
}
