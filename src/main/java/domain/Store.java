package domain;

/**
 * Aceasta clasa reprezinta tipul de baza pentru obiectele
 * din tabela stores din baza de date.
 **/

public class Store {
    private int StoreId;
    private String Name;
    private String Address;

    public Store(int storeid, String name, String address) {
        StoreId = storeid;
        Name = name;
        Address = address;
    }

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int storeId) {
        StoreId = storeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Store{" +
                "StoreId=" + StoreId +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
