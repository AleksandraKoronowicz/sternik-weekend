package shop.zasoby;

import java.util.concurrent.atomic.AtomicLong;

public class Products {

    private long id;
    private String name;
    private String category_name;
    private String cost;
    private String quantity;
    private static final AtomicLong counter = new AtomicLong(100);

    public Products(String name, String category_name, String cost, String quantity,long id) {
        this.name = name;
        this.category_name = category_name;
        this.cost = cost;
        this.quantity = quantity;    
        this.id = id;
    }
    
    public Products(String name, String category_name, String cost, String quantity) {
        this.name = name;
        this.category_name = category_name;
        this.cost = cost;
        this.quantity = quantity;        
        this.id = counter.incrementAndGet();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category_name;
    }

    public void setCategory(String category) {
        this.category_name = category;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + 
                ", category name=" + category_name + ", cost=" + cost + 
                ", quantity=" + quantity + '}';
    }

    
}