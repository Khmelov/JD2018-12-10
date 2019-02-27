package by.it.dziomin.jd03_01;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.it.dziomin.jd03_01.SQL_queries.ShowData.SHOW_USERS;

class B_ShowUsers {
    static void showData() {
        try {
            ResultSet resultset = DBConnector.getStatement().executeQuery(SHOW_USERS);
            while (resultset.next()) {
                System.out.println(resultset.getString("name")+", "+resultset.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка заполнения таблиц данными");
        }
    }
}
