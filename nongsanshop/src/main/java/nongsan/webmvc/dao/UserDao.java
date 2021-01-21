package nongsan.webmvc.dao;

import java.util.List;

import nongsan.webmvc.model.User;

public interface UserDao {

    void insert(User user);

    void edit(User user);

    void delete(int id);

    User get(String name);

    User get(int id);

    List<User> getAll();

    boolean checkLogin1(String username, String password, int roleid, int status);

    boolean checkLogin(String username, String password, int roleid, int status);
}