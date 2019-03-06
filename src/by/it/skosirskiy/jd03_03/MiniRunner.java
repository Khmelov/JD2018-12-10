package by.it.skosirskiy.jd03_03;



import by.it.skosirskiy.jd03_03.beans.Address;
import by.it.skosirskiy.jd03_03.beans.Request;
import by.it.skosirskiy.jd03_03.beans.Status;
import by.it.skosirskiy.jd03_03.dao.Dao;
import by.it.skosirskiy.jd03_03.dao.StatusDao;

import java.sql.SQLException;
import java.util.List;

public class MiniRunner {
    private static void showUsers() throws SQLException {


        List<Status> statuses=new StatusDao().getAll("");
        for (Status each:statuses) System.out.println(each);
    }
    public static void main(String[] args) throws SQLException {
        Dao dao= Dao.getDao();
        String city = "minsk";
        String street = "lenina";
        String house = "11";
        Integer flat = 50;
        Address address= new Address(0, city,street,house,flat);
        dao.address.create(address);
        String where=String.format(" WHERE `city`='%s' AND `street`='%s' AND `house`='%s' AND `flat`='%d'",city,street,house,flat);
        System.out.println(where);
        List<Address> addressForId = Dao.getDao().address.getAll(where);
        Long user_id= addressForId.get(0).getId();
        System.out.println(user_id);
        List<Request> requests = Dao.getDao().request.getAll("");
        System.out.println("AAAAAAA "+requests.size());
    }
}
