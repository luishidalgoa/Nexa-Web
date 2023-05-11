package Nexa.luishidalgoa.com.Nexa.Model.Utils;


import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;
import Nexa.luishidalgoa.com.Nexa.Services.ServiceUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
    public static boolean Sing_up(User entity, ServiceUser serviceUser) {
        entity.setPass(encrypt(entity.getPass()));
        if (serviceUser.searchUser(entity.getUser_name()) == null && serviceUser.save(entity.getUser_name(), entity.getPass(), entity.getBiography())) {
            return true;
        }
        return false;

    }

    public static User Sing_in(String username, String passwordString, ServiceUser serviceUser) {
        return serviceUser.sing_in(username, encrypt(passwordString));
    }

    public static String encrypt(String password) {
        try {
            // Obtenemos una instancia del algoritmo de hash SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Convertimos la contraseña en bytes y la procesamos con el algoritmo de hash
            byte[] passwordBytes = password.getBytes();
            byte[] hashedBytes = md.digest(passwordBytes);

            // Convertimos los bytes hash en una cadena de caracteres en hexadecimal
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hashedBytes.length; i++) {
                sb.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
