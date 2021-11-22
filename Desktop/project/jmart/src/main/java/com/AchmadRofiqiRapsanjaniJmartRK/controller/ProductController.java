package com.AchmadRofiqiRapsanjaniJmartRK.controller;

import com.AchmadRofiqiRapsanjaniJmartRK.Account;
import com.AchmadRofiqiRapsanjaniJmartRK.Product;
import com.AchmadRofiqiRapsanjaniJmartRK.ProductCategory;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonAutowired;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ProductController implements BasicGetController<Product> {
    public static @JsonAutowired(value= Product.class, filepath="C:\\Users\\vicky\\Desktop\\project\\jmart\\src\\AchmadRofiqiRapsanjani\\product.json") JsonTable<Product> productTable;

    @GetMapping("/create")
    Product create(int accountId, String name, int weight, boolean conditionUsed, double discount, ProductCategory category, byte shipmentPlans){

        return null;
    }

    public JsonTable<Product> getJsonTable(){
        return productTable;
    }

    @GetMapping("/{id}/store")

    public List<Product> getProductByStore(int id,int page, int pageSize) {
        return  null;
    }

    @GetMapping("/getFiltered")
    public List<Product> getProductFiltered(int page, int pageSize, int accountId, String search, int minPrice, int maxPrice, ProductCategory category) {
        return null;
    }
    @Override
    public List<Product> getPage(int page, int pageSize) {
        return null;
    }

    @Override
    public Product getById(int id) {
        return null;
    }

}
