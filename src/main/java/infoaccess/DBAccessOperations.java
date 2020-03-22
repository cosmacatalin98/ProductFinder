package infoaccess;

import java.util.List;

public interface DBAccessOperations {

    List<Object> viewALL();
    void insert(Object obj);
    void delete(int id);
    boolean findByID(int id);
    boolean findByName(String name);

}
