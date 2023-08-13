package src.base.service;

import lombok.AllArgsConstructor;
import src.base.model.BaseEntity;
import src.base.repository.BaseRepository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
public class BaseServiceImpl <T extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<T,ID>>
        implements BaseService<T, ID> {
    protected final R repository;

    @Override
    public void save(T entity) {
        repository.beginTransaction();
        repository.save(entity);
        repository.commitTransaction();
    }

    @Override
    public void update(T entity) {
        repository.beginTransaction();
        repository.update(entity);
        repository.commitTransaction();
    }

    @Override
    public void delete(T entity) {
        repository.beginTransaction();
        repository.delete(entity);
        repository.commitTransaction();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public Collection<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        repository.beginTransaction();
        Collection<T> saveList = repository.saveAll(entityCollection);
        repository.commitTransaction();
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
