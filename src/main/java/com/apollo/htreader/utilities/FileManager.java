package com.apollo.htreader.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileManager {
    public static void saveFile(String fileName, String text, Map<String, String> params){
        try {
            File file = createFile(fileName);
            DataLoader.writeTextToFile(file, text, params);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    protected static File createFile(String fileName) throws IOException {
        if(!createDataDir()) return null;
        if(!createSavesDir()) return null;
        File f = new File(fileName);
        if(f.exists()) return f;
        if(!f.createNewFile()) return null;
        return f;
    }
    private static boolean createDataDir(){
        File dataDir = new File("src/main/java/com/apollo/htreader/data/");
        if(!dataDir.exists()) return dataDir.mkdir();
        return true;
    }
    private static boolean createSavesDir(){
        File savesDir = new File("src/main/java/com/apollo/htreader/data/saves/");
        if(!savesDir.exists()) return savesDir.mkdir();
        return true;
    }
}
