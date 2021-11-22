package com.AchmadRofiqiRapsanjaniJmartRK.controller;

import com.AchmadRofiqiRapsanjaniJmartRK.Account;
import com.AchmadRofiqiRapsanjaniJmartRK.Coupon;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonAutowired;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    public static @JsonAutowired(value= Coupon.class, filepath="C:\\Users\\vicky\\Desktop\\project\\jmart\\src\\AchmadRofiqiRapsanjani\\coupon.json") JsonTable<Coupon> couponTable;
    public JsonTable<Coupon> getJsonTable(){
        return couponTable;
    }
    @Override
    public List<Coupon> getPage(int page, int pageSize) {
        return null;
    }

    @Override
    public Coupon getById(int id) {
        return null;
    }
    @GetMapping("/{id}/canApply")
    public boolean canApply(int id, double price, double discount){
        return false;
    }
    @GetMapping("/getAvailable")
    public List<Coupon> getAvailable(int page, int pageSize){
        return  null;
    }
    @GetMapping("/{id}/isUsed")
    public boolean isUsed(int id){
        return false;
    }

}
