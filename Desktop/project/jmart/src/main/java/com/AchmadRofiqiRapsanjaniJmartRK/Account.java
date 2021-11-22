package com.AchmadRofiqiRapsanjaniJmartRK;

import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.Serializable;

import java.util.regex.*;


public class Account extends Serializable
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&_*~]+(?:\\.[a-zA-Z0-9&_*~]+)*@[A-Za-z0-9]{1}[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public double balance;
    public String name;
    public String email;
    public String password;
    public Store store;

    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    public boolean validate(){
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Pattern patternPass = Pattern.compile(REGEX_PASSWORD);
        Matcher mEmail = patternEmail.matcher(email);
        Matcher mPass = patternPass.matcher(password);
        if(mEmail.find() && mPass.find()){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString(){
        return ("name: " + name + "\nemail: " + email + "\npassword: " + password);
    }


}