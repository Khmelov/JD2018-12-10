package by.it.skosirskiy.jd03_03.dao;

import java.sql.SQLException;
import java.util.List;

interface InterfaceDAO<TYPE> {
    //READ чтение отдельной сущности
    TYPE read(int id) throws SQLException;
    //CREATE,UPDATE,DELETE обновление сущности
    boolean create(TYPE entity);
    boolean update(TYPE entity);
    boolean delete(TYPE entity);

    //READ - чтение всех элементов по условию
    List<TYPE> getAll(String WhereAndOrder) throws SQLException;
    //и другие необходимые системе операции

}
