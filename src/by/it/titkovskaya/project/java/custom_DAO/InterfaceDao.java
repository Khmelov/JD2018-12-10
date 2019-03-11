package by.it.titkovskaya.project.java.custom_DAO;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<TypeBean> {

    TypeBean read(long id) throws SQLException;

    boolean create(TypeBean bean) throws SQLException;

    boolean update(TypeBean bean) throws SQLException;

    boolean delete(TypeBean bean) throws SQLException;

    List<TypeBean> getAll() throws SQLException;

    List<TypeBean> getAll(String where) throws SQLException;

}
