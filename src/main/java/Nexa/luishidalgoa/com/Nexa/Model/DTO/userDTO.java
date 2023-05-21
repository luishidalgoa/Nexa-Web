package Nexa.luishidalgoa.com.Nexa.Model.DTO;

import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;

import java.util.Set;

public class userDTO {
    private User user;
    private Set<User> followers;
    private Set<User> followed;
}
