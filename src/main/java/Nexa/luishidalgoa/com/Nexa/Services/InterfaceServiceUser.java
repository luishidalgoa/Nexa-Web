package Nexa.luishidalgoa.com.Nexa.Services;

import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;

import java.util.List;

public interface InterfaceServiceUser {
    public User searchUser(String username);
    public List<User> findAll();
}
