package schwarz.it.lws.inventorymanagement.repository;

import schwarz.it.lws.inventorymanagement.model.BaseItem;

import java.util.List;

public interface Repository <T extends BaseItem> {

    T save(T baseItem);
    T findById(long id);

    List<T> findAll();

    T update(T baseItem);

    void delete(T baseItem);
    void deleteById(Long id);

    default Long generateId() {
        return System.currentTimeMillis();
    }
}
