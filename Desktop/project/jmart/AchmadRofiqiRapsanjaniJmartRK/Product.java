package AchmadRofiqiRapsanjaniJmartRK;


public class Product
{
    int idCounter;
    int id = 0;
    String name;
    int weight;
    boolean conditionUsed;
    PriceTag priceTag;
    ProductCategory category;
    ProductRating rating;
    Product(String name, int weigth, boolean conditionUsed, PriceTag priceTag, ProductCategory category){
        this.name = name;
        this.weight = weigth;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        
        id = id + 1;





    }
}
