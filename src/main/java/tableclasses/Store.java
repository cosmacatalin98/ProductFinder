package tableclasses;

public class Store {
    private int StoreId;
    private String Name;
    private String Address;

    public Store(int storeId, String name, String address) {
        StoreId = storeId;
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
}
