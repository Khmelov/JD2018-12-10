package by.it.skosirskiy.jd03_02;

import by.it.skosirskiy.jd03_02.beans.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressCRUD {
    boolean create(Address address) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `address`(`id`,`city`, `street`,`house`,`flat`) " +
                            "VALUES ('%d','%s','%s','%s','%d')",
                    address.getId(), address.getCity(), address.getStreet(), address.getHouse(), address.getFlat());
            System.out.println(sql);
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    address.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Address read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `address` WHERE `id`='%d'", id);

            ResultSet resultSet = statement.executeQuery(sql);


            if (resultSet.next()) {
                Address address= new Address();
                address.setId(resultSet.getLong("id"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setHouse(resultSet.getString("house"));
                address.setFlat(resultSet.getInt("flat"));
                return address;
            }

        }
        return null;
    }


    boolean update(Address address) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `address` " +
                            "SET `city`='%s',`street`='%s',`house`='%s',`flat`='%d'"+"WHERE `id`='%d'",
                    address.getCity(), address.getStreet(), address.getHouse(), address.getFlat(), address.getId());

            return 1 == statement.executeUpdate(sql);
        }
    }
    boolean delete(Address address) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `address` WHERE `id`='%d'",
                    address.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
