package by.it.moroz.jd03.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<TypeBean> {

    TypeBean read(long id) throws SQLException;

    boolean create(TypeBean bean) throws SQLException;

    boolean update(TypeBean bean) throws SQLException;

    boolean delete(TypeBean bean) throws SQLException;

    List<TypeBean> getAll() throws SQLException;

    List<TypeBean> getAll(String WHERE) throws SQLException;
}
