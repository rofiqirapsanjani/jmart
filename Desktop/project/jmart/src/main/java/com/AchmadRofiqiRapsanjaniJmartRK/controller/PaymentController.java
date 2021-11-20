package com.AchmadRofiqiRapsanjaniJmartRK.controller;

import com.AchmadRofiqiRapsanjaniJmartRK.JsonTable;
import com.AchmadRofiqiRapsanjaniJmartRK.ObjectPoolThread;
import com.AchmadRofiqiRapsanjaniJmartRK.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/payment")
public abstract class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 0;
    public static final long ON_DELIVERY_LIMIT_MS = 0;
    public static final long ON_PROGRESS_LIMIT_MS = 0;
    public static final long WAITING_CONF_LIMIT_MS = 0;
    public  static JsonTable<Payment> paymentTable;
    public  static ObjectPoolThread<Payment> poolThread;

    @PostMapping("{id}/accept")

    boolean accept(int id){
        return true;
    }
    @PostMapping("{id}/cancel")

    boolean cancel(int id){
        return true;
    }
    @PostMapping("/create")

    Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan){
        return null;

    }

    @Override
    public List<Payment> getPage(int page, int pageSize) {
        return null;
    }

    //@Override
    //public Payment getById(int id) {
     //   return null;
    //}

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;

    }
    @PostMapping("{id}/submit")

    boolean submit(int id, String receipt){
        return true;
    }
    private static boolean timekeeper(Payment payment){
        return true;
    }
}
