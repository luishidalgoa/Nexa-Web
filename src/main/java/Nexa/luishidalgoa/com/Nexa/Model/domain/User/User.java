package Nexa.luishidalgoa.com.Nexa.Model.domain.User;

import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.User_options;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Table
@Entity
@Data
public class User {

    @Id
    @Column(name = "user_name", nullable = false, length = 15)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String user_name;

    @Column(name = "pass", length = 100, nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String pass;

    @Column(name="perfil_file_name", length = 40)
    private String perfil_file_name;

    @Column(name = "biography")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String biography;


    @OneToOne(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, optional = false, orphanRemoval = true)
    private User_options user_options;

}
