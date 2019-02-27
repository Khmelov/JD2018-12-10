package by.it.dziomin.jd03_02.crud;

import by.it.dziomin.jd03_02.DBConnector;
import by.it.dziomin.jd03_02.beans.Cars;
import by.it.dziomin.jd03_02.beans.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarsCRUD {
    public boolean create(Cars car) {
        try {
            String sql = String.format(
                    "INSERT INTO `dziomin`.`car` (`id`, `name`, `number`, `engine`, `transmission`) " +
                            "VALUES ('%d', '%s', '%s', '%s', '%s');",
                    car.getId(),
                    car.getName(),
                    car.getNumber(),
                    car.getEngine(),
                    car.getTransmission());
            int count = DBConnector.getStatement().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = DBConnector.getStatement().getGeneratedKeys();
                if (generatedKeys.next()) {
                    car.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Cars car) {
        try {
            String sql = String.format(
                    "UPDATE `car` SET `name`='%s'," + "`number`='%s'," + "`engine`='%s'," + "`transmission`='%s'" +
                            "WHERE `id`='%d'",
                    car.getName(),
                    car.getNumber(),
                    car.getEngine(),
                    car.getTransmission(),
                    car.getId());
            return 1 == DBConnector.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Cars car) {
        try {
            String sql = String.format(
                    "DELETE FROM `car` WHERE `id`='%d'",
                    car.getId());

            return 1 == DBConnector.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Cars read(long id) {
        try {
            String sql = String.format(
                    "SELECT * FROM `car` WHERE `id`='%d'",
                    id);
            ResultSet resultSet = DBConnector.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                Cars car = new Cars();
                car.setId(resultSet.getLong("id"));
                car.setName(resultSet.getString("name"));
                car.setNumber(resultSet.getString("number"));
                car.setEngine(resultSet.getString("engine"));
                car.setTransmission(resultSet.getString("transmission"));
                return car;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
