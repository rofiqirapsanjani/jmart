package com.AchmadRofiqiRapsanjaniJmartRK;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class JsonTable <T> extends Vector {
    public final String filepath;
    private static final Gson gson = new Gson();
    @SuppressWarnings("uncheked")
    public JsonTable(Class<T> clazz, String filepath) throws IOException  {
        this.filepath = filepath;
       // File file = new File(filepath);
        //file.getParentFile().mkdirs();
        //file.createNewFile();
        //Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
        //T[] loaded = readJson(arrayType, filepath);
        try{

            Class <T[]> arrayType = (Class<T[]>)  Array.newInstance(clazz, 0).getClass();
            T[] loaded = readJson(arrayType, filepath);
            if(loaded != null)
                Collections.addAll(this, loaded);


        }catch (FileNotFoundException e){}


    }
    public static  <T>  T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        final  JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);

    }
    public void writeJson() throws IOException{
        writeJson(this, this.filepath);
    }
    public static void writeJson(Object object, String filepath) throws IOException{
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
        File file = new File(filepath);
        File parent = file.getParentFile();
        if (parent != null)
            parent.mkdirs();
        file.createNewFile();



    }

}
