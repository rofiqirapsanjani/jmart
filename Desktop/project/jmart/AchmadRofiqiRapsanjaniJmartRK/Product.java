package AchmadRofiqiRapsanjaniJmartRK;

class Product extends Recognizable {
    private static int idCounter = 0;

    public final int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;

    Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag,
            ProductCategory category) {
        super(id);
        this.id = idCounter++;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }

    Product(int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag,
            ProductCategory category) {
        super(id);
        this.id = idCounter++;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();

    }

}