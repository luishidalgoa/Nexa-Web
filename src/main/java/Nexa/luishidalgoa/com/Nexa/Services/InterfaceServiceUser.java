package Nexa.luishidalgoa.com.Nexa.Services;

import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;

import java.util.List;

public interface InterfaceServiceUser {
    public User searchUser(String username);
    public List<User> findAll();
    public boolean save(String username,String pass,String bio);
    public User sing_in(String username,String pass);
}
