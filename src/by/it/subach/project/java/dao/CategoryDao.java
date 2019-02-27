package by.it.subach.project.java.dao;


import by.it.subach.project.java.beans.Category;
import by.it.subach.project.java.dao.dbInit.ConnCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends AbstractDao implements InterfaceDao<Category> {

    public boolean create(Category category) throws SQLException {
            String sql = String.format("INSERT INTO `categories`" +
                            "(`category_name`, `category_description`) " +
                            "VALUES ('%s','%s')",
                    category.getName(),
                    category.getDescription()
            );
            long id = executeCreate(sql);
            if (id > 0) {
                    category.setId(id);
                    return true;
                }
        return false;
    }

    public Category read(long id) throws SQLException {
            String sql = String.format(" WHERE id=" +
                    id);
            List<Category> categories = getAll(sql);
            if(categories.size() > 0) {
                return categories.get(0);
            }
            return null;
    }

    public boolean update(Category category) throws SQLException {
            String sql = String.format("UPDATE `categories` " +
                            "SET `category_name`='%s',`category_description`='%s' " +
                            "WHERE `id`='%d'",
                    category.getName(),
                    category.getDescription(),
                    category.getId()
            );
            return executeUpdate(sql);
        }


    public boolean delete(Category category) throws SQLException {
            String sql = String.format("DELETE FROM `categories` WHERE id="+
                    category.getId()
            );
            return executeUpdate(sql);

    }

    @Override
    public List<Category> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Category> getAll(String where) throws SQLException {
    List<Category> categories = new ArrayList<>();
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `categories` " +
                    where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("category_name"));
                category.setDescription(resultSet.getString("category_description"));
                categories.add(category);
            }
        }
        return categories;
    }
}
