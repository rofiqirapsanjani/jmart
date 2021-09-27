package AchmadRofiqiRapsanjaniJmartRK;

import AchmadRofiqiRapsanjaniJmartRK.Shipment.MultiDuration;

class Product extends Recognizable {
    private static int idCounter = 0;

    public final int id;
    public String name;
    public int weight;
    public int storeId;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public MultiDuration multiDuration;

    Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag,
            ProductCategory category, MultiDuration multiDuration) {
        super(id);
        this.id = idCounter++;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }

    public String toString() {
        this.name = "Harry Potter";
        this.weight = 1;
        this.conditionUsed = false;
        this.priceTag = priceTag;
        this.category = ProductCategory.BOOK;
        this.rating = rating;
        this.storeId = 1;
        return toString();
    }

    public boolean read() {
        return false;
    }

}