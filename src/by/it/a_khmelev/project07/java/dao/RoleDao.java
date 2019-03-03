package by.it.a_khmelev.project07.java.dao;

import by.it.a_khmelev.project07.java.beans.Role;

public class RoleDao extends UniversalDao<Role> {
    public RoleDao() {
        super(Role.class, "roles");
    }
}
