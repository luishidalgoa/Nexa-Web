package Nexa.luishidalgoa.com.Nexa.Model.domain.User;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Table
@Entity
public class Collection {
    @Column(name = "name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;
    @Id
    @Column(name = "user_name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String user_name;

}
