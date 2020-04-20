package infoaccess;

import java.util.List;

/**
 * Aceasta interfata defineste metodele
 * de baza pentru operatiile de prelucrare
 * a datelor din baza de date.
 */
public interface DBAccessOperations {
    /**
     * Aceasta metoda ne returneaza toate elementele
     * de un anumit tip din baza de date.
     *
     * @return
     */
    List<Object> viewALL();

    /**
     * Aceasta metoda insereaza un obiect nou in baza de date.
     *
     * @param obj
     */
    void insert(Object obj);

    /**
     * Aceasat metoda sterge un obiect din baza de date
     * pe baza unui id primit ca parametru.
     *
     * @param id
     */
    void delete(int id);

    /**
     * Aceasta metoda actualizeaza campurile unui obiect
     * din baza de date.
     *
     * @param obj
     */
    void update(Object obj);

}
