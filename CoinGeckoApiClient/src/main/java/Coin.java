public class Coin {
    private String id;
    private String name;
    private Double price;


    public Coin(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Without a default constructor, Jackson will throw an exception
    public  Coin() {}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
