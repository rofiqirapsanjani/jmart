package AchmadRofiqiRapsanjaniJmartRK;

public class Product extends Recognizable implements FileParser {
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;

    /**
     * Constructor for objects of class Product
     */
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag,
            ProductCategory category, Shipment.MultiDuration mutliDuration) {
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        this.multiDuration = multiDuration;

    }

    @Override
    public boolean read(String content) {
        return false;
    }

    public String toString() {
        // return("Name: Harry Potter\nWeight: 1\nconditionUsed: false\npriceTag:
        // 21000.0\ncategory: BOOK\nrating: 0\nstoreId: 1");
        return ("Name: " + name + "\nWeight: " + weight + "\nconditionUsed: " + conditionUsed + "\npriceTag: "
                + priceTag + "\ncategory: " + category + "\nrating: " + rating + "\nstoreId: " + storeId);
    }

}
