package by.it.subach.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<TypeBean> {


    boolean create(TypeBean bean) throws SQLException;

    TypeBean read(long id) throws SQLException;

    boolean update(TypeBean bean) throws  SQLException;

    boolean delete(TypeBean bean) throws SQLException;

    List<TypeBean> getAll() throws SQLException;

    List<TypeBean> getAll(String where) throws SQLException;
}
