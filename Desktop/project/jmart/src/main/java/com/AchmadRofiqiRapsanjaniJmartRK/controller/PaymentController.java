package com.AchmadRofiqiRapsanjaniJmartRK.controller;

import com.AchmadRofiqiRapsanjaniJmartRK.Account;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonAutowired;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonTable;
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
    public static @JsonAutowired(value= Account.class, filepath="C:\\Users\\vicky\\Desktop\\project\\jmart\\src\\AchmadRofiqiRapsanjani\\payment.json") JsonTable<Account> accountTable;
    public static JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>("tHREAD", PaymentController::timekeeper);


    @PostMapping("/{id}/accept")
    boolean accept(int id) {
        return false;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(int id) {
        return false;
    }

    @PostMapping("/create")
    boolean create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan) {
        return false;
    }

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/{id}/submit")
    boolean submit(int id, String receipt) {
        return false;
    }

    private static Boolean timekeeper(Payment payment) {
        return false;
    }
}
