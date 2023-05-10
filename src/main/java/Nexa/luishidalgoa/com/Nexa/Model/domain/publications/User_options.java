package Nexa.luishidalgoa.com.Nexa.Model.domain.publications;

import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
@Entity
public class User_options {
    @Id
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, optional = false, orphanRemoval = true)
    @JoinColumn(name = "user_name", nullable = false)
    private User user;

    @Column(name = "language", unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String language="EN";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User_options that = (User_options) o;
        return getUser() != null && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
