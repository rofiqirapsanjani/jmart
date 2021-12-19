package com.AchmadRofiqiRapsanjaniJmartRK;

public class PhoneTopUp extends Invoice
{
    String phoneNumber;
    Invoice.Status status;
    public PhoneTopUp(int buyerId, int productId, String phoneNumber){
        super(buyerId, productId);
        this.phoneNumber = phoneNumber;


    }
    public double getTotalPay(Product product){

        return Treasury.getAdjustedPrice(product.price, product.discount);
    }
}
