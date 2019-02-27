package by.it.dziomin.jd03_01.SQL_queries;

public interface ShowData {
    String SHOW_USERS = "SELECT user.name, role.name FROM dziomin.user, dziomin.role  WHERE role.id=user.role_id";
}
