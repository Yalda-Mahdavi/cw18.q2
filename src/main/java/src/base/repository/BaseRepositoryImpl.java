package src.base.repository;

import jakarta.persistence.EntityManager;
import src.base.model.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl <T extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<T,ID>{
   protected EntityManager em;

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(em.find(getEntityClass(), id));
    }

    @Override
    public Collection<T> findAll() {
        return em.createQuery("FROM" + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        List<T> saveEntity = new ArrayList<>();
        entityCollection.forEach(e->saveEntity.add(saveWithOutTransaction(e)));
        return saveEntity;
    }
    public T saveWithOutTransaction(T entity){
        if(entity.getId() == null)
            em.persist(entity);
        else
            em.merge(entity);
        return entity;
    }
    public abstract Class<T> getEntityClass();
}