package by.it.dziomin.jd03_03.Dao;

import by.it.dziomin.jd03_03.beans.BaseEntity;

import java.util.Collections;
import java.util.List;

public abstract class GenericDAO<T extends BaseEntity> extends AbstractDAO<T> implements InterfaceDAO<T> {

    protected abstract String getSelectByIdSql();

    protected abstract String getSelectAllSql();

    protected abstract String getDeleteSql();

    protected abstract String getInsertSql();

    protected abstract List<Object> getInsertParams(T entity);

    protected abstract List<Object> getUpdateParams(T entity);

    protected abstract String getUpdateSql();

    @Override
    public T getById(Long id) {
        String sqlString = getSelectByIdSql();
        List<Object> params = Collections.singletonList(id);

        List<T> objects = executeSelect(sqlString, params);
        if (objects != null && !objects.isEmpty()) {
            return objects.get(0);
        }

        return null;
    }

    @Override
    public List<T> getAll() {
        String sqlString = getSelectAllSql();
        return executeSelect(sqlString, Collections.emptyList());
    }

    @Override
    public T create(T entity) {
        String sqlString = getInsertSql();
        List<Object> params = getInsertParams(entity);
        Long id = executeUpdate(sqlString, params);
        entity.setId(id);
        return entity;
    }

    @Override
    public void update(T entity) {
        String sqlString = getUpdateSql();
        List<Object> params = getUpdateParams(entity);
        executeUpdate(sqlString, params);
    }

    @Override
    public void delete(T entity) {
        String sqlString = getDeleteSql();
        List<Object> params = Collections.singletonList(entity.getId());
        executeUpdate(sqlString, params);
    }
}
