package hw_37.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    void create(T obj);

    Optional<List<T>> getAll();

    Optional<T> getById(Long id);

    void update(T obj);

    void deleteById(Long id);
}
