package com.apollo.htreader.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.Map;

public class DataLoader {
    public static final String DEFAULT_URL = "src/main/java/com/apollo/htreader/data/url.json";

    public static void writeTextToFile(File file, String text, Map<String, String> params){
        try{
            JsonWriter writer = new JsonWriter(new BufferedWriter(new FileWriter(file)));
            writer.beginObject();
            if(params.get("text_title") != null){
                writer.beginObject();
                writer.name("text_title");
                writer.value(params.get("text_title"));
                writer.endObject();
            }
            if(params.get("text_point") != null){
                writer.beginObject();
                writer.name("text_point");
                writer.value(params.get("text_point"));
                writer.endObject();
            }
            if(params.get("text_font") != null){

            }
            if(params)
            StringBuilder line = new StringBuilder();
            int lineCounter = 0;
            for(int i = 0; i < text.length(); i++){
                if(text.charAt(i) == '\n'){
                    writer.beginObject();
                    writer.name("l"+lineCounter++);
                    writer.value(line.toString());
                    writer.endObject();
                    continue;
                }
                line.append(text.charAt(i));
            }
            writer.endObject();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readTextFromFile(File file){
        return "";
    }

    public static boolean saveURL(String url){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(url);
        try{
            File f = FileManager.createFile(DEFAULT_URL);
            if(f == null) return false;
            JsonWriter writer = new JsonWriter(new BufferedWriter(new FileWriter(f)));
            writer.beginObject();
            writer.name("url").value(jsonString);
            writer.endObject();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static String fetchURL() {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new BufferedReader(new FileReader(DEFAULT_URL)));
        } catch (FileNotFoundException e) {
            try {
                FileManager.createFile(DEFAULT_URL);
                jsonReader = new JsonReader(new BufferedReader(new FileReader(DEFAULT_URL)));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        jsonReader.setLenient(true);


        try{
            jsonReader.beginObject();
            jsonReader.nextName();
            return jsonReader.nextString().replaceAll("\"","");
        } catch (IOException e) {
            return "";
        }
    }
}
