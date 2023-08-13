package src.base.repository;

import jakarta.persistence.EntityManager;
import src.base.model.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable> {
    void save (T entity);
    void update (T entity);
    void delete (T entity);
    Optional<T> findById(ID id);
Collection<T> findAll();
Collection<T> saveAll (Collection<T> entityCollection);
void beginTransaction();
void commitTransaction();
void rollBack();
}
