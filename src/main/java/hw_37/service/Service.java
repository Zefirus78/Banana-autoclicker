package hw_37.service;

import java.util.List;

public interface Service<T> {

    void create(T obj);

    List<T> getAll();

    T getById(Long id);

    void update(T obj);

    void deleteById(Long id);
}
