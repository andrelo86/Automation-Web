package com.automationapi.framework;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONException;

public class Utilities {

  private static final String JSON_FILE_PATH = "src/test/java/com/automationapi/framework/resources/config.json";
  private static JsonParser parser = new JsonParser();

  public static String getJsonDataProperty(String property) {
    try {
      Object obj = parser.parse(new FileReader(JSON_FILE_PATH));

      JsonObject jsonObject = (JsonObject) obj;

      return jsonObject.get(property).getAsString();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return "";
  }

}
