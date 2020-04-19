package infoaccess;

import java.util.List;

public class DBAOContext {
    private DBAccessOperations dbao;

    public DBAOContext(DBAccessOperations dbao) {
        this.dbao = dbao;
    }

    public List<Object> executeGetAll() {
        return dbao.viewALL();
    }

    public void executeInsertItem(Object obj) {
        dbao.insert(obj);
    }

    public void executeDeleteItem(int id) {
        dbao.delete(id);
    }

    public void executeUpdateItem(Object obj) {
        dbao.update(obj);
    }
}
