package AchmadRofiqiRapsanjaniJmartRK;


/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Driver
{


public void main (String args[]){
getPromo();
}

public int getPromo(){
return 0;
}

public String getCustomer(){
return "oop";
}
 
public float getDiscountPercentage(int before,int after)
{
if (before < after){
return 0.0f;
}else{
return (((before - after)/before)*100);
}
}

public int getDiscountedPrice(int price, float discountPercentage){
if (discountPercentage>100.0f){
return 0;
}else{
return (int)(price - (price * discountPercentage/100));
}
}

public int getOriginalPrice(int discountedPrice, float discountedPercentage){
return discountedPrice + (discountedPrice * (int)discountedPercentage/100);
}

public float getCommissionMultiplier(){
return 0.05f;
}

public float getAdjustedPrice(int price){
return (int)price + (price +0.05f);
}

public float getAdminFree(int price){
return (int)(price*getCommissionMultiplier());
}
}
