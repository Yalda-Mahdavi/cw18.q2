package src.base.repository;

import src.base.model.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface BaseRepository <T extends BaseEntity<ID>, ID extends Serializable> {
    T saveOrUpdate(T entity);
    void save(T entity);
    void update(T entity);
    void delete (T entity);
    void deleteById(ID id);
    Optional<T> findById (ID id);
    Collection<T> findAll();
    Collection<T> saveAll(Collection<T> entityCollection);
    long getCount();
    void beginTransaction();
    void commitTransaction();
    void rollBack();
}
