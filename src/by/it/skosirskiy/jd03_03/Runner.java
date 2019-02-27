package by.it.skosirskiy.jd03_03;


import by.it.skosirskiy.jd03_03.beans.Role;
import by.it.skosirskiy.jd03_03.beans.User;
import by.it.skosirskiy.jd03_03.dao.Dao;
import by.it.skosirskiy.jd03_03.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    private static void showUsers() throws SQLException {

        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDao().getAll("");
        for (User each:users) System.out.println(each);
    }
    public static void main(String[] args) throws SQLException {

        Dao dao = Dao.getDao();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }

        showUsers();

        User user = new User(0,"Сергей Иванович", "sergio", "sergio@mail.ru",2);
        //добавим пользователя
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email sergio@mail.ru
        user = dao.user.getAll("WHERE `email`='sergio@mail.ru'").get(0);
        user.setLogin("up_ivan");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }
}
