package AchmadRofiqiRapsanjaniJmartRK;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Vector;

public class JsonTable <T> extends Vector {
    public final String filepath;
    private static final Gson gson = new Gson();
    public JsonTable(Class<T> clazz, String filepath) throws IOException  {
        this.filepath = filepath;
        File file = new File(filepath);
        file.getParentFile().mkdirs();
        file.createNewFile();
        Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
        T[] loaded = readJson(arrayType, filepath);


    }
    public static  <T>  T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        T reader;
        FileReader filereader = new FileReader(filepath);
        reader = gson.fromJson(filereader, clazz);
        return reader;

    }
    public void writeJson() throws IOException{
        writeJson(this, this.filepath);
    }
    public static void writeJson(Object object, String filepath) throws IOException{
        FileWriter writer = new FileWriter(filepath);
        String json = gson.toJson(object);
        writer.write(json);
        writer.close();

    }

    public static void main(String[] args) {
        try {
            String filepath ="a/b/c/account.json";
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "emai", "password"));
            tableAccount.writeJson();
        }catch (Throwable t){
            t.printStackTrace();
        }
    }



}
