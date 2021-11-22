package com.AchmadRofiqiRapsanjaniJmartRK;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonTable;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
class Jmart
{
    static long DELIVERED_LIMIT_MS;
    static long ON_DELIVERY_LIMIT_MS;
    static long ON_PROGRESS_LIMIT_MS;
    static long WAITING_CONF_LIMIT_MS;
    public static boolean paymentTimekeeper (Payment payment){
        return false;
    }
    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize){
        Predicate<Product> pred = p -> (p.accountId == accountId);
        return paginate(list, page, pageSize, pred);
    }
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        List<Product> products = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)){
                products.add(product);
            }
        }
        return products;
    }
    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> pred = p -> (p.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, pred);
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

    public static void main(String[] args) {
        //List<Product> list = read("C:/Users/vicky/Desktop/project/jmart/src/AchmadRofiqiRapsanjaniJmartRK/account.json");

        //List<Product> filteredByName = filterByName(list, "gtx", 1, 5);
        //filteredByName.forEach(product -> System.out.println(product.name));

        //System.out.println("-------------------------");

        //List<Product> filteredByAccountId = filterByAccountId(list, 1, 0, 5);
        //filteredByAccountId.forEach(product -> System.out.println(product.name));
        SpringApplication.run(Jmart.class, args);
        try {
            String filepath = "C:\\Users\\vicky\\Desktop\\project\\jmart\\src\\AchmadRofiqiRapsanjani\\account.json";
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password", 0));
            tableAccount.writeJson();
            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString() + "asd"));
        } catch (Throwable t) {
            t.printStackTrace();
        }
        try {
            JsonTable<Payment> table = new JsonTable<>(Payment.class, "C:\\Users\\vicky\\Desktop\\project\\jmart\\src\\AchmadRofiqiRapsanjani\\randomPaymentList.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
            paymentPool.start();
            table.forEach(payment -> paymentPool.add((Payment) payment));
            while (paymentPool.size() != 0);
            paymentPool.exit();
            while (paymentPool.isAlive());
            System.out.println("Thread exited successfully");
            Gson gson = new Gson();
            table.forEach(payment ->{
                String history ;
               // history       = gson.toJson(payment.history);
              //  System.out.println(history);
            });




        } catch (Throwable t){
            t.printStackTrace();
        }
    }

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred)
    {
        try{
            List<Product> filteredList = list.stream().filter(p -> pred.predicate(p)).collect(Collectors.toList());
            int endIndex = (page * pageSize) + pageSize;
            if(endIndex > filteredList.size()){
                endIndex = filteredList.size();
            }
            return filteredList.subList((page * pageSize), endIndex);
        }catch (Exception e){
            return list.subList(0 ,0);
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