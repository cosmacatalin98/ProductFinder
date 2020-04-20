package domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Aceasta clasa se ocupa cu crearea tipului de baza
 * pentru produsele din tabela products.
 * In cadrul DP-ului Observer are rolul de observable
 * deoarece orice schimbare asupa campurilor unui
 * obiect care apartine clasei se propaga
 * la obiectele de tip User.
 */
public class Product {
    private int ProductId;
    private int StoreId;
    private String ProductName;
    private int Quantity;
    private String Um;
    private int Price;
    private PropertyChangeSupport support;

    public Product(int productid, int storeid, String productname, int quantity, String um, int price) {
        ProductId = productid;
        StoreId = storeid;
        ProductName = productname;
        Quantity = quantity;
        Um = um;
        Price = price;
        support = new PropertyChangeSupport(this);
    }

    public Product() {

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int storeId) {
        StoreId = storeId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getUm() {
        return Um;
    }

    public void setUm(String um) {
        Um = um;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    /**
     * Aceasta metoda anunta toti utilizatorii de schimbarea
     * realizata la produsul pe care acestia il au adaugat
     * la favorit.
     */
    public void changed() {
        support.firePropertyChange("favourite", this, this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", StoreId=" + StoreId +
                ", ProductName='" + ProductName + '\'' +
                ", Quantity=" + Quantity +
                ", Um='" + Um + '\'' +
                ", Price=" + Price +
                '}';
    }
}
