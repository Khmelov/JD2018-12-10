package by.it.titkovskaya.jd03.jd03_03.universal_DAO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversalDao<TypeBean> {

    private Class<TypeBean> beanClass;
    private String table;
    private Field[] fields;

    UniversalDao(Class<TypeBean> beanClass, String table) {
        this.beanClass = beanClass;
        this.table = table;
        this.fields = beanClass.getDeclaredFields();
    }

    public TypeBean read(long id) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<TypeBean> beans = getAll(" WHERE `id`=" + id);
        return beans.size() == 1 ? beans.get(0) : null;
    }

    public boolean create(TypeBean bean) throws SQLException, IllegalAccessException {
        String sql = "INSERT INTO `" + table + "` (";
        String values = "";
        String delimiter = "";
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);           //делаем поля публичными для получения values (иначе IllegalAccessException)
            sql = sql.concat(delimiter + "`" + fields[i].getName() + "`");
            values = values.concat(delimiter + "'" + fields[i].get(bean) + "'");
            delimiter = ",";
        }
        sql = sql + ") VALUES (" + values + ")";
        long id = executeCreate(sql);
        if (id > 0) {
            fields[0].setAccessible(true);
            fields[0].set(bean, id);
        }
        return id > 0;
    }

    public boolean update(TypeBean bean) throws SQLException, IllegalAccessException {
        String sql = "UPDATE `" + table + "` SET ";
        String delimiter = "";
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);      //делаем поля публичными для получения values (иначе IllegalAccessException)
            sql = sql.concat(delimiter + "`" + fields[i].getName() + "`='" + fields[i].get(bean) + "'");
            delimiter = ",";
        }
        sql = sql + " WHERE `id`='" + fields[0].get(bean) + "'";
        return executeUpdate(sql);
    }

    public boolean delete(TypeBean bean) throws SQLException, IllegalAccessException {
        String sql = "DELETE FROM `" + table + "` WHERE `id`='" + fields[0].get(bean) + "'";
        return executeUpdate(sql);
    }

    public List<TypeBean> getAll() throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return getAll("");
    }

    public List<TypeBean> getAll(String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<TypeBean> beans = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `" + table + "` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TypeBean bean = getNewBean();   //получаем экземпляр класса дженерика
                for (Field field : fields) {
                    field.setAccessible(true);  //делаем поля публичными для записи
                    //перебираем самые распространенные типы значений полей
                    if (field.getType() == String.class)
                        field.set(bean, resultSet.getString(field.getName()));
                    if (field.getType() == Integer.class || field.getType() == int.class)
                        field.set(bean, resultSet.getInt(field.getName()));
                    if (field.getType() == Long.class || field.getType() == long.class)
                        field.set(bean, resultSet.getLong(field.getName()));
                    if (field.getType() == Double.class || field.getType() == double.class)
                        field.set(bean, resultSet.getDouble(field.getName()));
                    if (field.getType() == Float.class || field.getType() == float.class)
                        field.set(bean, resultSet.getFloat(field.getName()));
                    if (field.getType() == Short.class || field.getType() == short.class)
                        field.set(bean, resultSet.getShort(field.getName()));
                    if (field.getType() == Byte.class || field.getType() == byte.class)
                        field.set(bean, resultSet.getByte(field.getName()));
                    if (field.getType() == Boolean.class  || field.getType() == boolean.class)
                        field.set(bean, resultSet.getBoolean(field.getName()));
                    if (field.getType() == Timestamp.class)
                        field.set(bean, resultSet.getTimestamp(field.getName()));
                    if (field.getType() == Date.class)
                        field.set(bean, resultSet.getDate(field.getName()));
                    if (field.getType() == Time.class)
                        field.set(bean, resultSet.getTime(field.getName()));
                }
                beans.add(bean);
            }
        }
        return beans;
    }

    //получаем экземпляр класса дженерика
    private TypeBean getNewBean() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return beanClass.getConstructor().newInstance();
    }

    private boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    private long executeCreate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return 0;
    }
}
