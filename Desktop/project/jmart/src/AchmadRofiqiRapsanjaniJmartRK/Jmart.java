package AchmadRofiqiRapsanjaniJmartRK;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;



class Jmart
{
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        List<Product> products = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)){
                products.add(product);
            }
        }
        return products;
    }
    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        if(minPrice <= 0){
            list.removeIf(product -> product.price > maxPrice);
        }else if(maxPrice <= 0){
            list.removeIf(product -> product.price < minPrice);
        }else{
            list.removeIf(product -> (product.price < minPrice) || (product.price > maxPrice));
        }
        return list;
    }
    public static void main(String[] args)
    {
        try{
// sesuaikan argument method read sesuai dengan lokasi resource
            List<Product> list = read("C:\\Users\\vicky\\Desktop\\project\\jmart\\src\\AchmadRofiqiRapsanjaniJmartRK/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 13000.0, 15000.0);
            filtered.forEach(product -> System.out.println(product.price));
        }catch (Throwable t)
        {
            t.printStackTrace();
        }

    }
    public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()){
                products.add(gson.fromJson(reader, Product.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}