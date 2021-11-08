package AchmadRofiqiRapsanjaniJmartRK;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;



class Jmart {
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
        List<Product> products = new ArrayList<>();
        for (Product product : list) {
            if (product.category.equals(category)) {
                products.add(product);
            }
        }
        return products;
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
        if (minPrice <= 0) {
            list.removeIf(product -> product.price > maxPrice);
        } else if (maxPrice <= 0) {
            list.removeIf(product -> product.price < minPrice);
        } else {
            list.removeIf(product -> (product.price < minPrice) || (product.price > maxPrice));
        }
        return list;
    }

    public static void main(String[] args) {
        try {

            List<Product> list = read("C:\\Users\\vicky\\Desktop\\project\\jmart\\src\\AchmadRofiqiRapsanjaniJmartRK/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 13000.0, 15000.0);
            filtered.forEach(product -> System.out.println(product.price));
            List<Product> name = filterByName(list, "gtx", 1, 5);
            name.forEach(product -> System.out.println(product.name));
            System.out.println();
            List<Product> filteredAccountId = filterByAccountId(list, 1, 1, 5);
            filteredAccountId.forEach(product -> System.out.println(product.accountId));

        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while (reader.hasNext()) {
                products.add(gson.fromJson(reader, Product.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize){
        Predicate<Product> pred = p -> (p.accountId == accountId);
        return paginate(list, page, pageSize, pred);
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = a -> (a.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        try {
            List<Product> copyList = new ArrayList<>(list); //Bikin salinan dari list untuk dilakukan filtering aman
            List<Product> filteredList = copyList.stream().filter(p -> pred.predicate(p)).collect(Collectors.toList());
            int endIndex = (page * pageSize) + pageSize;
            if (endIndex > filteredList.size()) {
                endIndex = filteredList.size();
            }
            return filteredList.subList((page * pageSize), endIndex);
        } catch (Exception e) {
            return null;
        }
    }
}