package prefs;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    Map<String,Object> pref = new HashMap<>();
    private static final String DB_BASIC_URL = "DBPref.json";
    
    public Prefs(){
        this(DB_BASIC_URL);
    }
    public Prefs(String filename) {
        try {
            String json = String.join("\n", Files.readAllLines(Paths.get(filename)));
            pref = new Gson().fromJson(json, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Object getPref(String key){
        return pref.get(key);
    }
    public String getString(String key){
       return getPref(key).toString();
    }

}

