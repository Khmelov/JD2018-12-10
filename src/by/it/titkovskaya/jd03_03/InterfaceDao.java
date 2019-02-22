package by.it.titkovskaya.jd03_03;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<TypeBean> {

    public TypeBean read(long id) throws SQLException;

    public boolean create(TypeBean bean) throws SQLException;

    public boolean update(TypeBean bean) throws SQLException;

    public boolean delete(TypeBean bean) throws SQLException;

    public List<TypeBean> getAll() throws SQLException;

    public List<TypeBean> getAll(String where) throws SQLException;

}
