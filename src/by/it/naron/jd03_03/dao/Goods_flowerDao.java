package by.it.naron.jd03_03.dao;
import by.it.naron.jd03_03.beans.*;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Goods_flowerDao extends AbstractDao implements InterfaceDao<Goods_flower> {

    @Override
    public boolean create(Goods_flower goodsFlower) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `goods_flower`(`name`, `colour`, `size`, `price`)" +
                        "VALUES  ('%s','%s','%d','%f');",
                goodsFlower.getName(), goodsFlower.getColour(),
                goodsFlower.getSize(), goodsFlower.getPrice());
        goodsFlower.setId(executeCreate(sql));
        return goodsFlower.getId() > 0;
    }

    @Override
    public boolean update(Goods_flower goodsFlower) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `goods_flower` " +
                        "SET `name`='%s',`colour`='%s',`size`='%d', `price`='%f'" +
                        "WHERE `id`='%d'",
                goodsFlower.getName(), goodsFlower.getColour(),
                goodsFlower.getSize(),goodsFlower.getPrice(),
                goodsFlower.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Goods_flower goodsFlower) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `Gds` WHERE `id`='%d'",
                goodsFlower.getId());
        return executeUpdate(sql);
    }

    @Override
    public Goods_flower read(long id) throws SQLException {
        List<Goods_flower> goodsFlower = getAll(" WHERE id=" + id);
        return goodsFlower.size() == 0 ? null : goodsFlower.get(0);
    }

    @Override
    public List<Goods_flower> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Goods_flower> getAll(String where) throws SQLException {
        List<Goods_flower> result = new ArrayList<>();
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "SELECT * FROM `Gds` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Goods_flower goodsFlower = new Goods_flower();
                goodsFlower.setId(resultSet.getLong("id"));
                goodsFlower.setName(resultSet.getString("name"));
                goodsFlower.setColour(resultSet.getString("colour"));
                goodsFlower.setSize(resultSet.getLong("size"));
                goodsFlower.setPrice(resultSet.getDouble("price"));
                result.add(goodsFlower);
            }
        }
        return result;
    }
}