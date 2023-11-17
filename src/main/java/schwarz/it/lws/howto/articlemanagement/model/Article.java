package schwarz.it.lws.howto.articlemanagement.model;

public class Article {
    private Long id;
    private String name;
    private String cagtegory;
    private double price;
    private int quantity;

    // default Konstruktor
    public Article() {
    }

    // Konstruktor ohne id
    public Article(String name, String cagtegory, int quantity, double price) {
        this(null, name, cagtegory, quantity, price);
    }

    // Konstruktor mit allen Feld-Attributen
    public Article(Long id, String name, String cagtegory, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.cagtegory = cagtegory;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCagtegory() {
        return cagtegory;
    }

    public void setCagtegory(String cagtegory) {
        this.cagtegory = cagtegory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cagtegory='" + cagtegory + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
