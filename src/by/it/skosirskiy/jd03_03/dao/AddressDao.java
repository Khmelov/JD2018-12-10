package by.it.skosirskiy.jd03_03.dao;

import by.it.skosirskiy.jd03_03.beans.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDao extends AbstractDao implements InterfaceDAO<Address> {
@Override
public Address read(int id) {
        List<Address> Address = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (Address.size() > 0) {
        return Address.get(0);
        } else
        return null;
        }

@Override
public boolean create(Address address) {
        String sql = String.format(
        "insert INTO Address(address)" +
        " values('%s', '%s', '%s','%d');",
        address.getCity(), address.getStreet(), address.getHouse(), address.getFlat()
        );
        address.setId(executeUpdate(sql));
        return (address.getId()>0);
        }

@Override
public boolean update(Address address) {
        String sql = String.format(
        "UPDATE `Address` SET `city` = '%s', `street` = '%s', `house` = '%s',`flat` = '%d'  WHERE `users`.`id` = %d",
        address.getCity(), address.getStreet(), address.getHouse(), address.getFlat(), address.getId()
        );
        return (0 < executeUpdate(sql));
        }

@Override
public boolean delete(Address address) {
        String sql = String.format(
        "DELETE FROM `Addresses` WHERE `id` = %d;", address.getId()
        );
        return (0 < executeUpdate(sql));
        }

@Override
public List<Address> getAll(String WHERE) {
        List<Address> Addresses = new ArrayList<>();
        String sql = "SELECT * FROM address " + WHERE + " ;";
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
        Address address = new Address();
        address.setId(rs.getInt("id"));
        address.setCity(rs.getString("city"));
        address.setStreet(rs.getString("street"));
        address.setHouse(rs.getString("house"));
        address.setFlat(rs.getInt("flat"));

        Addresses.add(address);
        }
        } catch (SQLException e) {
        //тут нужно логгирование SQLException(e);
        }
        return Addresses;
        }

        }
