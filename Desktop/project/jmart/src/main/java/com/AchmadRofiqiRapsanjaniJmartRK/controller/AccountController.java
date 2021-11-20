package com.AchmadRofiqiRapsanjaniJmartRK.controller;
import com.AchmadRofiqiRapsanjaniJmartRK.Account;

// TODO sesuaikan dengan package Anda: package com.alvinJmartRK.controller;


// TODO sesuaikan dengan package Anda: import com.alvinJmartRK.Account;
import com.AchmadRofiqiRapsanjaniJmartRK.JsonTable;
import com.AchmadRofiqiRapsanjaniJmartRK.Store;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

import javax.accessibility.AccessibleKeyBinding;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&_*~]+(?:\\.[a-zA-Z0-9&_*~]+)*@[A-Za-z0-9]{1}[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public  JsonTable<Account> accountTable;


    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(name, email, password);
    }

    @Override
    public List<Account> getPage(int page, int pageSize) {
        return null;
    }

    @Override
    public Account getById(int id) {
        return null;
    }

    @GetMapping("/{id}")
    //public String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
    public JsonTable<Account> getJsonTable(){
        return accountTable;

    }
   // @PostMapping("/login")
    //Account login
      //      (
        //            @RequestParam String email,
          //          @RequestParam String password
            //)
    //{
      //  for(Account account : accountTable){
        //    if(account.email.equals(email) && account.password.equals(password)){
          //      return account;
            //}
        //}
        //return null;
    //}
    @PostMapping("{id}/registerStore")
    Store registerStore(int id, String name, String address, String phoneNumber){
        return null;

    }
    @PostMapping("{id}/topUp")
    boolean topUp(int id, double balance){
        return true;

    }

}

