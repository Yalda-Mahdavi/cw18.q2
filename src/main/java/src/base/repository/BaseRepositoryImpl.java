package src.base.repository;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import src.base.model.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@AllArgsConstructor
public abstract class BaseRepositoryImpl <T extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<T,ID>{
    EntityManager em;
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
    public T findById(ID id) {
        return em.find(getEntityClass(), id);
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

    @Override
    public void beginTransaction() {
        if(!em.getTransaction().isActive())
            em.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if(em.getTransaction().isActive())
            em.getTransaction().commit();
    }

    @Override
    public void rollBack() {
        if(em.getTransaction().isActive())
            em.getTransaction().rollback();
    }

    @Override
    public EntityManager getEm() {
        return em;
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
