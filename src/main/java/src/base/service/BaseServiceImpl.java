package src.base.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import src.base.model.BaseEntity;
import src.base.repository.BaseRepository;

import java.io.Serializable;
import java.util.Collection;

@AllArgsConstructor
@Getter
public class BaseServiceImpl <T extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<T,ID>>
        implements BaseService<T, ID> {
    private final R repository;
    @Override
    public void save(T entity) {
        try {
            repository.beginTransaction();
            repository.save(entity);
            repository.commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(T entity) {
        try {
            repository.beginTransaction();
            repository.update(entity);
            repository.commitTransaction();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(T entity) {
       try {
           repository.beginTransaction();
           repository.delete(entity);
           repository.commitTransaction();
       }catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public Collection<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        Collection<T> saveList = null;
        try {
           repository.beginTransaction();
           saveList = repository.saveAll(entityCollection);
           repository.commitTransaction();
       }catch (Exception e) {
           System.out.println(e.getMessage());
       }
        return saveList;
    }

    @Override
    public void beginTransaction() {
        repository.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        repository.commitTransaction();
    }

    @Override
    public void rollBack() {
        repository.rollBack();
    }
}
