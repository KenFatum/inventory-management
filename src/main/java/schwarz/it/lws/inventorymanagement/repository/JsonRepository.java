package schwarz.it.lws.inventorymanagement.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import schwarz.it.lws.inventorymanagement.exception.RepositoryException;
import schwarz.it.lws.inventorymanagement.model.BaseItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonRepository<T extends BaseItem> implements Repository<T> {
    private final Class<T> type;
    private final File file;
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonRepository(Class<T> type, File file) {
        this.type = type;
        this.file = file;
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public T save(T baseItem) {
        List<T> baseItems = findAll();
        baseItem.setId(generateId());
        baseItems.add(baseItem);
        try {
            mapper.writeValue(file, baseItems);
        } catch (IOException e) {
            throw new RepositoryException("Failed to save baseItem");
        }
        return baseItem;
    }

    @Override
    public T findById(long id) {
        List<T> baseItems = findAll();
        for (T baseItem : baseItems) {
            if (baseItem.getId() == id) {
                return baseItem;
            }
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        List<T> resultList = new ArrayList<>();
        if (file.exists()) {
            try {
                resultList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, type));
            } catch (IOException e) {
                throw new RepositoryException("Error while reading from file: " + file.getAbsolutePath());
            }
        }
        return resultList;
    }

    @Override
    public T update(T baseItem) {
        List<T> baseItems = findAll();
        for (T item : baseItems) {
            if (baseItem.getId().equals(item.getId())) {
                item = baseItem;
                baseItems.add(item);
                break;
            }
        }
        try {
            mapper.writeValue(file, baseItems);
        } catch (IOException e) {
            throw new RepositoryException("Failed to update!");
        }
        return null;
    }

    @Override
    public void delete(T baseItem) {
        List<T> baseItems = findAll();
        for (T item : baseItems) {
            if (baseItem.getId().equals(item.getId())) {
                baseItems.remove(item);
                break;
            }
        }
        try {
            mapper.writeValue(file, baseItems);
        } catch (IOException e) {
            throw new RepositoryException("Failed to delete!");
        }
    }

    @Override
    public void deleteById(Long id) {
        List<T> baseItems = findAll();
        for (T item : baseItems) {
            if (id.equals(item.getId())) {
                baseItems.remove(item);
                break;
            }
        }
        try {
            mapper.writeValue(file, baseItems);
        } catch (IOException e) {
            throw new RepositoryException("Failed to delete!");
        }
    }
}
