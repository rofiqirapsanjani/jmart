package com.AchmadRofiqiRapsanjaniJmartRK.controller;

import com.AchmadRofiqiRapsanjaniJmartRK.Account;
import com.AchmadRofiqiRapsanjaniJmartRK.Algorithm;
import com.AchmadRofiqiRapsanjaniJmartRK.Coupon;
import com.AchmadRofiqiRapsanjaniJmartRK.Predicate;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonAutowired;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    public static @JsonAutowired(value= Coupon.class, filepath="C:\\Users\\vicky\\Desktop\\AchmadRofiqiRapsanjaniJmartRK\\src\\coupon.json") JsonTable<Coupon> couponTable;


    @GetMapping("/{id}/canApply")
    public boolean canApply(@PathVariable int id, @PathVariable double price, @PathVariable double discount){
        for(Coupon coupon : couponTable){
            if(coupon.id == id){
                return coupon.canApply(price, discount);
            }
        }
        return false;
    }

    @GetMapping("/getAvailable")
    public List<Coupon> getAvailable(@RequestParam int page, @RequestParam int pageSize) {
        Predicate<Coupon> pred = coupon -> !coupon.isUsed();
        return Algorithm.paginate(couponTable, page, pageSize, pred);
    }

    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

    @GetMapping("/{id}/isUsed")
    public boolean isUsed(@PathVariable int id) {
        for (Coupon coupon : couponTable) {
            if (coupon.id == id) {
                return coupon.isUsed();
            }
        }
        return false;
    }

}
