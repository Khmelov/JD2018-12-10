package by.it.subach.project.java.dao;


import by.it.subach.project.java.beans.Product;
import by.it.subach.project.java.dao.dbInit.ConnCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends AbstractDao implements InterfaceDao<Product> {

    @Override
    public boolean create(Product product) throws SQLException {
        String sql = String.format("INSERT INTO `products`" +
                        "(`product_name`, `product_price`, `product_description`, `categories_id`) " +
                        "VALUES ('%s','%.2f','%s','%d')",
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategories_id()
        );
        long id = executeCreate(sql);
        if (id == 1) {
            product.setId(id);
            return true;
        }
        return false;
    }

    public Product read(long id) throws SQLException {
        String sql = " WHERE id=" + id;
        List<Product> productList = getAll(sql);
        if (productList.size() == 1) {
            return productList.get(0);
        }
        return null;
    }

    public boolean update(Product product) throws SQLException {
        String sql = String.format("UPDATE `products` " +
                        "SET `product_name`='%s',`product_price`='%.2f',`product_description`='%s',`categories_id`='%d' " +
                        "WHERE `id`='%d'",
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategories_id(),
                product.getId()
        );
        return executeUpdate(sql);

    }

    public boolean delete(Product product) throws SQLException {
        String sql = String.format("DELETE FROM `products` WHERE `id`='%d'",
                product.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Product> getAll(String where) throws SQLException {
        List<Product> productList = new ArrayList<>();
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = "SELECT * FROM `products` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("product_price"));
                product.setDescription(resultSet.getString("product_description"));
                product.setCategories_id(resultSet.getInt("categories_id"));
                productList.add(product);
            }
        }
        return productList;
    }

}
