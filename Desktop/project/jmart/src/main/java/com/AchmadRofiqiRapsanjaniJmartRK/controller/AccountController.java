package com.AchmadRofiqiRapsanjaniJmartRK.controller;
import com.AchmadRofiqiRapsanjaniJmartRK.Account;

// TODO sesuaikan dengan package Anda: package com.alvinJmartRK.controller;


// TODO sesuaikan dengan package Anda: import com.alvinJmartRK.Account;
import com.AchmadRofiqiRapsanjaniJmartRK.Algorithm;
import com.AchmadRofiqiRapsanjaniJmartRK.Predicate;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonTable;
import com.AchmadRofiqiRapsanjaniJmartRK.Store;
import org.springframework.web.bind.annotation.*;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonAutowired;

import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonTable;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {

    public static final String REGEX_EMAIL = "^(?!\\.)([\\dA-Za-z&_*~]+\\.?)+@([\\dA-Za-z]+\\.?)+[\\dA-Za-z]+$";

    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    public static @JsonAutowired(value= Account.class, filepath="C:\\Users\\vicky\\Desktop\\project\\jmart\\src\\AchmadRofiqiRapsanjani\\account.json") JsonTable<Account> accountTable;



    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) {
// hash password
        String hashed = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] password_bytes = md.digest();
            for (byte b: password_bytes) {
                hashed += String.format("%x", b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        for (Object a : getJsonTable()) {
            Account acc = (Account) a;
            if (
                    email.equals(acc.email) && hashed.equals(acc.password)
            ) {
                return acc;
            }
        }
        return null;
    }


    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
// name cannot be empty
        if (name.isBlank()) return null;

// email and PW must validate
        if (!(REGEX_PATTERN_EMAIL.matcher(email).matches())) return null;
        if (!(REGEX_PATTERN_PASSWORD.matcher(password).matches())) return null;

// email must be unique
        for (Object a : getJsonTable()) {
            Account acc = (Account) a;
            if (email.equals(acc.email)) return null;
        }

// hash password
        String hashed = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] password_bytes = md.digest();
            for (byte b: password_bytes) {
                hashed += String.format("%x", b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        Account n = new Account(name, email, hashed, 0);
        accountTable.add(n);
        return n;
    }


    @PostMapping("/{id}/registerStore")
    Store registerStore(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) {
        Account target_account = getById(id);
        if (target_account != null) {
            if (target_account.store != null) return null;

            Store store = new Store(name, address, phoneNumber, 0);
            target_account.store = store;
            return store;
        }
        return null;
    }


    @PostMapping("/{id}/topUp")
    boolean topUp(
            @PathVariable int id,
            @RequestParam double balance
    ) {
        Account target_account = getById(id);
        if (target_account != null) {
            target_account.balance += balance;
            return true;
        }
        return false;
    }

    @Override
    @GetMapping("/page")
    public List<Account> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
       return null;
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        for (Object a : getJsonTable()) {
            Account acc = (Account) a;
            if (id == acc.id) return acc;
        }
        return null;
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
}